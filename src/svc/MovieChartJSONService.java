package svc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import vo.MovieList;
import vo.MovieChart;

public class MovieChartJSONService {

	public ArrayList<MovieChart> parsingKobisJSON() throws Exception {
		ArrayList<MovieChart> result = new ArrayList<MovieChart>();
		/* JSON�Ľ� */
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(kobisMovieChartUrl());
		JSONObject json = (JSONObject) jsonobject.get("boxOfficeResult");
		JSONArray array = (JSONArray) json.get("dailyBoxOfficeList");
		for (int i = 0; i < array.size(); i++) {
			String[] pubDate = null;
			JSONObject entity = (JSONObject) array.get(i);

			MovieChart movieChart = new MovieChart();
			movieChart.setRnum((String) entity.get("rnum")); // ����
			movieChart.setRank((String) entity.get("rank"));
			movieChart.setMovieCd((String) entity.get("movieCd")); // movie��ȣ
			movieChart.setMovieNm((String) entity.get("movieNm"));// movie�̸�
			movieChart.setOpenDt((String) entity.get("openDt")); // ������
			movieChart.setSalesAcc((String) entity.get("salesAcc"));// ���������
			movieChart.setAudiAcc((String) entity.get("audiAcc"));// ����������
			movieChart.setScrnCnt((String) entity.get("scrnCnt"));// ��ũ����
			movieChart.setShowCnt((String) entity.get("showCnt"));// ��Ƚ��
			pubDate = movieChart.getOpenDt().split("-");
			movieChart.setImage(parsingNaverJSON(movieChart.getMovieNm(), pubDate[0])); // imageURL

			result.add(movieChart);
		}
		return result;
	}

	private static String kobisMovieChartUrl() throws Exception {
		String key = "633a7091e0acaedfdcc1d858724bc56e";
		String result = null;

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String day = simpleDateFormat.format(calendar.getTime());

		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
				+ "?key=" + key + "&targetDt=" + day;
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) { // ���� ȣ��
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // ���� �߻�
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		result = response.toString();
		br.close();

		return result;
	}

	private static String naverImageUrl(String movieNm, String pubDate) throws Exception {
		String clientId = "lHVmULPa1i1UltPgijR0";// ���ø����̼� Ŭ���̾�Ʈ ���̵�";
		String clientSecret = "7T4ycQI7YW";// ���ø����̼� Ŭ���̾�Ʈ ��ũ����";
		String result = null;

		String text = URLEncoder.encode(movieNm, "UTF-8");
		String apiURL = "https://openapi.naver.com/v1/search/movie.json?" + "query=" + text + "&display=1"
				+ "&yearfrom=" + pubDate + "&yearto=" + pubDate;
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) { // ���� ȣ��
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // ���� �߻�
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		result = response.toString();
		br.close();

		return result;
	}

	private String parsingNaverJSON(String movieNm, String pubDate) throws Exception {
		String imageURL = null;

		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(naverImageUrl(movieNm, pubDate));

		JSONArray array = (JSONArray) jsonobject.get("items");
		for (int i = 0; i < array.size(); i++) {
			JSONObject entity = (JSONObject) array.get(i);
			imageURL = (String) entity.get("image");
		}
		return imageURL;
	}
}