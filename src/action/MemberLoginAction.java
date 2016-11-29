package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberInsertService;
import svc.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		MemberBean article = new MemberBean();
		HttpSession httpSession = request.getSession();
		article.setId(request.getParameter("id"));
		article.setPass(request.getParameter("pass"));
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean isRegisterSuccess = memberLoginService.loginArticle(article);

		if (isRegisterSuccess) {
			httpSession.setAttribute("idKey", article.getId());
			forward.setPath("/");
		} else {
			response.setContentType("text/html;charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;

	}

}
