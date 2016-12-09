package action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import svc.MovieListJSONService;
import vo.ActionForward;
import vo.MovieList;
import vo.PageInfo;

public class MovieDetailJSONAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int page = 1;

		String movieNm = "";
		String directorNm = "";

		request.setCharacterEncoding("utf-8");
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("mode") != null) {
			switch (request.getParameter("mode")) {
			case "movieNm":
				movieNm = (String) request.getParameter("searchText");
				System.out.println(movieNm);
				break;
			case "director":
				directorNm = (String) request.getParameter("searchText");
				break;
			}
		}

		ActionForward forward = new ActionForward();
		MovieListJSONService movieListJSONService = new MovieListJSONService();
		ArrayList<MovieList> movieLists = movieListJSONService.parsingJSON(page, movieNm, directorNm); // List목록을
		// 파싱한다

		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page);
		pageInfo.setTotCnt(movieListJSONService.getTotalCount(movieNm, directorNm));

		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("movieLists", movieLists); // parameter값 전달

		forward.setPath("/movie/movieListform.jsp");

		return forward;

	}
}