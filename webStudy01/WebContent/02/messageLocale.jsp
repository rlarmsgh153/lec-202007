<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="javax.annotation.Resource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.flag{
		width : 100px;
		height: 100px;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<input type="image" src="<%=request.getContextPath() %>/images/korean.jpg"
	class="flag" id="KO"
/>
<input type="image" src="<%=request.getContextPath() %>/images/us.png" 
	class="flag" id="EN"
/>
<div id="resultArea">
	
</div>
<pre>
<%-- aceept-language : <%=acceptLanguage %> --%>
<%-- <%=message %> --%>
</pre>
<script type="text/javascript">
	$(".flag").on("click", function(event){
		let language = $(this).prop("id");
<%-- 		location.href="<%=request.getContextPath() %>/02/getMessage.jsp?lang="+language; --%>
		$.ajax({
			url:"<%=request.getContextPath() %>/02/getMessage.jsp",
			data:{
				lang:language
			},
			method:"GET",
			dataType:"text", // Accept : application/json | Content-Type
			seccess:function(resp){
				$("#resultArea").text(resp);
			},
			error:function(xhr){
				console.log(xhr.status);
			}
		});
	});
</script>
</body>
</html>