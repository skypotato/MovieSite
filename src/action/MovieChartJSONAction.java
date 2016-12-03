package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MovieChartJSONService;
import vo.ActionForward;
import vo.MovieChart;

public class MovieChartJSONAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		MovieChartJSONService movieChartJSONService = new MovieChartJSONService();
		ArrayList<MovieChart> movieCharts = movieChartJSONService.parsingKobisJSON(); // Chart����� �Ľ��Ѵ�
		request.setAttribute("movieCharts", movieCharts); // parameter�� ����
		forward.setPath("/main.jsp");

		return forward;

	}
}
