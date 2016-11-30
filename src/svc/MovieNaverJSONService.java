package svc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import vo.MovieBean;

public class MovieNaverJSONService {
	public ArrayList<MovieBean> parsingJSON() throws Exception {
		String clientId = "lHVmULPa1i1UltPgijR0";// ���ø����̼� Ŭ���̾�Ʈ ���̵�";
		String clientSecret = "7T4ycQI7YW";// ���ø����̼� Ŭ���̾�Ʈ ��ũ����";
		try {
			String text = URLEncoder.encode("�׸����丮", "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text;
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
			br.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
