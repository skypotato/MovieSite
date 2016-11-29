package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberInsertService;
import svc.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLogOutAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('·Î±×¾Æ¿ô')");
		out.println("location.href = '/MovieSite/login/loginform.jsp'");
		out.println("</script>");

		return forward;

	}

}
