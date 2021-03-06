package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.TimeListService;
import vo.ActionForward;
import vo.TimeInfo;

public class TicketMovieListAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	 	ActionForward forward = new ActionForward();
		
		TimeListService timeListService = new TimeListService();
		ArrayList<TimeInfo> timeArr = timeListService.registerArticle();

		if (timeArr!=null) {
			request.setAttribute("timeArr", timeArr);
			forward.setPath("/ticket/ticketingform.jsp");
		} else {
			response.setContentType("text/html;charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('불러오기실패')");
			out.println("history.back();");
			out.println("</script>");
		}

		return forward;

	}

}