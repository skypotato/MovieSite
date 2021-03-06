package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.input.KeyCombination.ModifierValue;
import svc.TicketTimeListService;
import svc.TimeListService;
import vo.ActionForward;
import vo.TimeInfo;

public class TicketTimeListAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	 	ActionForward forward = new ActionForward();
		
		TimeInfo timeInfo = new TimeInfo();
		timeInfo.setMovieCd(Integer.valueOf(request.getParameter("mvlist")));

		TicketTimeListService ticketTimeListService = new TicketTimeListService();
		ArrayList<TimeInfo> timeArr = ticketTimeListService.timeList(timeInfo);
		
		if (timeArr!=null) {
			request.setAttribute("timeArr", timeArr);
			forward.setPath("/ticket/ticketTimeform.jsp");
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