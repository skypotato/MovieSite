package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberInsertService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberInsertAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	 	ActionForward forward = new ActionForward();
		MemberBean article = new MemberBean();
		article.setId(request.getParameter("id"));
		article.setName(request.getParameter("name"));
		article.setPass(request.getParameter("pass"));
		article.setPhone(request.getParameter("phone"));
		
		MemberInsertService memberInsertService = new MemberInsertService();
		boolean isRegisterSuccess = memberInsertService.registerArticle(article);

		if (isRegisterSuccess) {
			forward.setPath("/login/loginform.jsp");
		} else {
			response.setContentType("text/html;charset=EUC-KR");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입실패')");
			out.println("history.back();");
			out.println("</script>");
		}

		return forward;

	}

}