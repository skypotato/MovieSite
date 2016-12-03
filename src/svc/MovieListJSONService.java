package svc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import vo.MovieList;

public class MovieListJSONService {

	public ArrayList<MovieList> parsingJSON(int page, String movieNm, String directorNm) throws Exception {
		// TODO Auto-generated method stub

		ArrayList<MovieList> movieArr = new ArrayList<MovieList>();

		/* JSON파싱 */
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(readUrl(page, movieNm, directorNm));
		JSONObject movieListResult = (JSONObject) jsonobject.get("movieListResult");
		JSONArray movieLists = (JSONArray) movieListResult.get("movieList");
		for (int i = 0; i < movieLists.size(); i++) {
			JSONObject entity = (JSONObject) movieLists.get(i);

			MovieList movieList = new MovieList();
			movieList.setMovieNm((String) entity.get("movieNm"));
			movieList.setPrdtYear((String) entity.get("prdtYear"));
			movieList.setTypeNm((String) entity.get("typeNm"));
			movieList.setRepGenreNm((String) entity.get("repGenreNm"));

			JSONArray directors = (JSONArray) entity.get("directors");
			String directorStr = "";
			for (int j = 0; j < directors.size(); j++) {
				JSONObject director = (JSONObject) directors.get(j);
				if (j == 0)
					directorStr += director.get("peopleNm");
				else
					directorStr += ", " + director.get("peopleNm");
				if (j > 2) {
					directorStr += "...";
					break;
				}
			}
			movieList.setDirectors(directorStr);

			movieArr.add(movieList);
		}

		return movieArr;

	}

	public int getTotalCount(String movieNm, String directorNm) throws Exception {
		/* JSON파싱 */
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(readUrl(1, movieNm, directorNm));
		JSONObject movieListResult = (JSONObject) jsonobject.get("movieListResult");
		int totCnt = Integer.parseInt(movieListResult.get("totCnt").toString());
		return totCnt;
	}

	private static String readUrl(int page, String movieNm, String directorNm) throws Exception {

		String key = "633a7091e0acaedfdcc1d858724bc56e";
		String result = null;

		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json" + "?key=" + key
				+ "&curPage=" + page + "&movieNm=" + movieNm + "&directorNm=" + directorNm;
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
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

		return result;
	}

}