package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.TicketInsertService;
import svc.TimeInsertService;
import vo.ActionForward;
import vo.Seat;

public class TicketInsertAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		ArrayList<Seat> seats = new ArrayList<Seat>();
		int timeid = Integer.parseInt(request.getParameter("timeid"));
		String[] seatList = request.getParameterValues("seat");
		HttpSession httpSession = request.getSession();
		String id = (String) httpSession.getAttribute("idKey");

		if (seatList.length > 0) {
			for (int i = 0; i < seatList.length; i++) {
				String[] temp = seatList[i].split("-");
				Seat seat = new Seat();
				seat.setRowChar(temp[0].charAt(0));
				seat.setColumnNum(Integer.parseInt(temp[1]));
				seat.setState(1);
				seat.setTheaterNum(Integer.valueOf(request.getParameter("theater")));
				seats.add(seat);
			}
		}

		TicketInsertService ticketInsertService = new TicketInsertService();
		boolean isRegisterSuccess = ticketInsertService.registerArticle(seats, timeid, id);

		if (isRegisterSuccess) {
			forward.setPath("main.do");
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