package kr.or.ddit.servlet01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageStreamingServlet
 */
@WebServlet("/imageView.do") //서브사이드는 절대경로만 사용
public class ImageStreamingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	File folder;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //반드시 super가 있어야한다.
		String contentFolder = getServletContext().getInitParameter("contenFolder");
		folder = new File(contentFolder);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imageName = request.getParameter("image");
		if(imageName == null || imageName.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		File imageFile = new File(folder, imageName);
		
		if(!imageFile.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		if(!getServletContext().getMimeType(imageName).startsWith("image")) {
			response.sendError(400);
			return;
		}
		
		String mime = getServletContext().getMimeType(imageFile.getName());
		response.setContentType(mime);
		
		try(
			FileInputStream fis = new FileInputStream(imageFile);
			OutputStream os = response.getOutputStream();  //OutputStream은 출력스트림의 최상위 //Wrtier는 writer의 최상위
		){
			byte[] buffer = new byte[1024];
			int cnt = -1;
			while((cnt = fis.read(buffer)) != -1 ) { //EOF 문자 : -1
				os.write(buffer, 0, cnt);
			}
		}
	}
}
