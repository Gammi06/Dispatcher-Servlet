package site.metacoding.ds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
		// 톰캣이 만든 req, resp를 서블릿이 받아 사용함
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doProcess 요청됨");

		String httpMethod = req.getMethod();
		System.out.println(httpMethod);

		String identifier = req.getRequestURI();
		System.out.println(identifier);

		//주소를 파싱해서 컨트롤러에 넘겨준다
		UserController c = new UserController();
		if (identifier.equals("/join")) {
			c.join();
		} else if (identifier.equals("/login")) {
			c.login();
		} else {
			System.out.println("잘못된 요청입니다.");
		}
	}
}
