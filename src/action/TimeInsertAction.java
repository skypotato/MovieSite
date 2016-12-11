package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberInsertService;
import svc.TimeInsertService;
import vo.ActionForward;
import vo.MemberBean;
import vo.TimeInfo;

public class TimeInsertAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	 	ActionForward forward = new ActionForward();
		TimeInfo article = new TimeInfo();
		article.setMovieCd(Integer.parseInt(request.getParameter("movieCd")));
		article.setMovieNm(request.getParameter("movieNm"));
		article.setTheaterNum(Integer.parseInt(request.getParameter("theaterNum")));
		article.setStartDate(request.getParameter("startDate"));
		article.setEndDate(request.getParameter("endDate"));
		article.setStartTime(request.getParameter("startTime"));
		article.setEndTime(request.getParameter("endTime"));
		
		TimeInsertService timeInsertService = new TimeInsertService();
		boolean isRegisterSuccess = timeInsertService.registerArticle(article);

		if (isRegisterSuccess) {
			forward.setPath("registerMovieList.do");
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