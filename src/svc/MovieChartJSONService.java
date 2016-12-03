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

import vo.MovieBean;
import vo.MovieChart;

public class MovieChartJSONService {

	public ArrayList<MovieChart> parsingJSON() throws Exception {
		// TODO Auto-generated method stub

		ArrayList<MovieChart> movieArr = new ArrayList<MovieChart>();

		/* JSON파싱 */
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(readUrl());
		JSONObject json = (JSONObject) jsonobject.get("boxOfficeResult");
		JSONArray array = (JSONArray) json.get("dailyBoxOfficeList");
		for (int i = 0; i < array.size(); i++) {
			String[] pubDate = null;
			JSONObject entity = (JSONObject) array.get(i);

			MovieChart movieChart = new MovieChart();
			movieChart.setRnum((String) entity.get("rnum")); // 순위
			movieChart.setRank((String) entity.get("rank"));
			movieChart.setMovieCd((String) entity.get("movieCd")); // movie번호
			movieChart.setMovieNm((String) entity.get("movieNm"));// movie이름
			movieChart.setOpenDt((String) entity.get("openDt")); // 개봉일
			movieChart.setSalesAcc((String) entity.get("salesAcc"));// 누적매출액
			movieChart.setAudiAcc((String) entity.get("audiAcc"));// 누적관객수
			movieChart.setScrnCnt((String) entity.get("scrnCnt"));// 스크린수
			movieChart.setShowCnt((String) entity.get("showCnt"));// 상영횟수
			pubDate = movieChart.getOpenDt().split("-");
			movieChart.setImage(parsingNaverJSON(movieChart.getMovieNm(), pubDate[0])); // imageURL

			movieArr.add(movieChart);
		}

		return movieArr;

	}

	private static String readUrl() throws Exception {
		BufferedInputStream reader = null;
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -1);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String day = simpleDateFormat.format(calendar.getTime());
			URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/"
					+ "searchDailyBoxOfficeList.json" + "?key=633a7091e0acaedfdcc1d858724bc56e" + "&targetDt=" + day);
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	private static String ImageUrl(String movieNm, String pubDate) throws Exception {
		String clientId = "lHVmULPa1i1UltPgijR0";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "7T4ycQI7YW";// 애플리케이션 클라이언트 시크릿값";
		String result = null;
		try {
			String text = URLEncoder.encode(movieNm, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/movie.json?"
			+ "query=" + text
			+ "&display=1"
			+ "&yearfrom=" + pubDate
			+ "&yearto=" + pubDate;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			result = response.toString();
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	private String parsingNaverJSON(String movieNm, String pubDate) throws Exception {
		String imageURL = null;

		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(ImageUrl(movieNm, pubDate));

		JSONArray array = (JSONArray) jsonobject.get("items");
		for (int i = 0; i < array.size(); i++) {
			JSONObject entity = (JSONObject) array.get(i);
			imageURL = (String) entity.get("image");
		}
		return imageURL;
	}
}