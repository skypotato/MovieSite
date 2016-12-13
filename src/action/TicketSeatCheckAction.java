package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.TicketSeatCheckService;
import svc.TimeInsertService;
import vo.ActionForward;
import vo.Seat;
import vo.TimeInfo;

public class TicketSeatCheckAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	 	ActionForward forward = new ActionForward();
		TimeInfo timeInfo = new TimeInfo();
		ArrayList<Seat> seats = new ArrayList<Seat>();
		timeInfo.setTime_id(Integer.valueOf(request.getParameter("mvtime")));
		
		TicketSeatCheckService ticketSeatCheckService = new TicketSeatCheckService();
		seats = ticketSeatCheckService.seatCheck(timeInfo);
		
		if (seats!=null) {
			request.setAttribute("seats", seats);
			request.setAttribute("timeid", timeInfo.getTime_id());
			forward.setPath("/ticket/seatCheckform.jsp");
		} else {
			response.setContentType("text/html;charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}

		return forward;

	}

}