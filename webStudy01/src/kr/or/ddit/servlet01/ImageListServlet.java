package kr.or.ddit.servlet01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import kr.or.ddit.utils.TemplateUtils;

/**
 * Servlet implementation class ImageListServlet
 */
//@WebServlet("/01/imageList.tmpl")
public class ImageListServlet extends UseTemplateServlet {
	File folder;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //반드시 super가 있어야한다.
		String contentFolder = getServletContext().getInitParameter("contenFolder");
		folder = new File(contentFolder);
	}
	
	@Override
	public String getMimeType() {
		return "text/html;charset=UTF-8";
	}

	@Override
	public void getDataMap(Map<String, Object> dataMap, HttpServletRequest req) {
		String[] imageList = folder.list((dir, name)->{
			String mime = getServletContext().getMimeType(name);
			return mime!=null && mime.startsWith("image");
		});
		String pattern = "<option value=%1$s>%1$s</option>";
		StringBuffer options = new StringBuffer("");
		for( String filename : imageList ) {
			options.append( String.format(pattern, filename) );
		}
		
		dataMap.put("title", "이미지 목록");
		dataMap.put("optionData", options);
		dataMap.put("today", new Date());
	}
	
}
