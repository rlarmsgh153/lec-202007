package kr.or.ddit.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mime.do")
public class MimeDescriptionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		MIME : Multipurposed Inernet Mail Extension, main_type/sub_type;charset=encoding
//		text/html;charset=EUC-KR, text/javascript, text/plain;carset-UTF-8
		
		String mime = "text/plain;charset=UTF-8";
		resp.setContentType(mime);
		String data = "안녕 서블릿";
		String html = "";
		html+="<html>		";
		html+="<body>       ";
		html+="<h4>"+data+"</h4>";
		html+="</body>      ";
		html+="</html>		";
//		PrintWriter out = null;
//		try {
//			out = resp.getWriter();
//			out.println(html);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}finally {
//			if(out!=null)
//				out.close();
//		}
		try(
			//closable 객체 생성 코드
			PrintWriter out = resp.getWriter();
		){
			out.println(html);
		}
	}
}
