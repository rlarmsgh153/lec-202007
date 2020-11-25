<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String language = request.getParameter("lang");
	String acceptLanguage = request.getHeader("accept-language");
	Locale locale = request.getLocale();
	if(language != null && !language.isEmpty()){
		locale = Locale.forLanguageTag(language.toLowerCase());
	}
	ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.msg.message", locale);
	String message = bundle.getString("bow");
%>
<%=message %>