package svc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import vo.MovieBean;
import vo.MovieChart;

public class MovieNaverJSONService {
	public ArrayList<MovieBean> parsingJSON() throws Exception {
		ArrayList<MovieBean> movieArr = new ArrayList<MovieBean>();

		/* JSON파싱 */
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(readUrl());
		JSONObject json = (JSONObject) jsonobject.get("total");
		JSONArray array = (JSONArray) json.get("item");
		for (int i = 0; i < array.size(); i++) {
			JSONObject entity = (JSONObject) array.get(i);

			MovieBean movieBean = new MovieBean();
			movieBean.setTitle((String) entity.get("title")); // 제목
			movieBean.setLink((String) entity.get("link"));
			movieBean.setImage((String) entity.get("image"));
			movieBean.setSubtitle((String) entity.get("subtitle"));
			movieBean.setPubDate((String) entity.get("pubDate"));
			movieBean.setDirector((String) entity.get("director"));
			movieBean.setActor((String) entity.get("actor"));
			movieBean.setUserRating((String) entity.get("userRating"));
			
			movieArr.add(movieBean);
		}
		return movieArr;
	}

	private static String readUrl() throws Exception {
		String clientId = "lHVmULPa1i1UltPgijR0";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "7T4ycQI7YW";// 애플리케이션 클라이언트 시크릿값";
		String result = null;
		try {
			String text = URLEncoder.encode("광해", "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text;
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

}
