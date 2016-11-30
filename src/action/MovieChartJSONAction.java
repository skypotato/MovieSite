package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MovieJSONService;
import vo.ActionForward;
import vo.MovieChart;

public class MovieJSONAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		MovieJSONService movieJSONService = new MovieJSONService();
		ArrayList<MovieChart> movieCharts = movieJSONService.parsingJSON(); // Chart목록을 파싱한다
		request.setAttribute("movieCharts", movieCharts); // parameter값 전달
		forward.setPath("/main.jsp");

		return forward;

	}
}
