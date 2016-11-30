package svc;

import java.io.BufferedInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import vo.MovieChart;

public class MovieChartJSONService {

	public ArrayList<MovieChart> parsingJSON() throws Exception {
		// TODO Auto-generated method stub

		ArrayList<MovieChart> movieArr = new ArrayList<MovieChart>();

		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(readUrl());
		JSONObject json = (JSONObject) jsonobject.get("boxOfficeResult");
		JSONArray array = (JSONArray) json.get("dailyBoxOfficeList");
		for (int i = 0; i < array.size(); i++) {
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
}