<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String minDanStr = request.getParameter("minDan");
String maxDanStr = request.getParameter("maxDan");

int minDan = 2;
int maxDan = 9;
if(minDanStr != null && minDanStr.matches("2-9")) {
	minDan = Integer.parseInt("minDanStr");
}		
if(maxDanStr != null && minDanStr.matches("2-9")) {
	maxDan = Integer.parseInt("maxDanStr");
}

StringBuffer gugudanTrTags = new StringBuffer();
String ptrn = "<td>%d*%d=%d</td>";
for(int dan=minDan; dan<=maxDan; dan++) {
	gugudanTrTags.append("<tr>");
	for(int mul=1; mul<=9; mul++) {
		gugudanTrTags.append(String.format(ptrn, dan, mul, (dan * mul)));
	}
	gugudanTrTags.append("</tr>");
}
%>

<html>
	<style type="text/css">
		body{
			background-color: aqua;
		}
	</style>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
	
	</script>
	<body>
		<h4>구구단</h4>
		<form>
			min : <input type="number" name="minDan" value="<%=minDan %> }" />
			max : <input type="number" name="maxDan" value="<%=maxDan %> " />
			<input type="submit" value="send" />
		</form>
		<table>
			<%=gugudanTrTags %>
		</table>
	</body>
</html>