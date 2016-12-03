package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MovieChartJSONService;
import svc.MovieNaverJSONService;
import vo.ActionForward;
import vo.MovieChart;

public class MovieNaverJSONAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		MovieNaverJSONService movieNaverJSONService = new MovieNaverJSONService();
		String movieNaver = movieNaverJSONService.parsingJSON(); // Chart목록을파싱한다
		request.setAttribute("movieDetail", movieNaver); // parameter값 전달
		forward.setPath("/movie/movieDetail.jsp");

		return forward;

	}
}