package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MemberIDcheckService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberIDcheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		String id = null;

		id = request.getParameter("id");

		MemberIDcheckService idcheckService = new MemberIDcheckService();
		boolean checkSuccess = idcheckService.idCheck(id);

		if (!checkSuccess) {
			response.setContentType("text/html;charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('사용가능한 아이디입니다')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('중복된 아이디입니다')");
			out.println("history.back();");
			out.println("</script>");
		}

		return forward;
	}

}
