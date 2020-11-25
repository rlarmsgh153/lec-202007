<%@page import="java.util.Date"%>
<html>
	<style type="text/css">
		body{
			background-color: aqua;
		}
	</style>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
// 		function changeCallback(event){
// 			console.log(event);
// 			console.log(event.target.value);
// 			location.href="/webStudy01/imageView.do?image="+event.target.value;
// 		}
// 		$(document).ready(function(){
			
// 		});
		$(function(){
			$("select").on("change", function(){
				var imageName = $(this).val();
//	 			<img src="../imageView.do?image="/>
				$("#imageArea").html( 
					$("<img>").attr("src", "<%=request.getContextPath() %>/imageView.do?image="+imageName)
				);
		});
	</script>
	<body>
	<%
		String[] imageFiles = (String[]) request.getAttribute("imageFiles");
	%>
		<h4>${title }</h4>
		<h4>${today }</h4>
		<select>
			<%
				for(String image:imageFiles){
					%>
					<option><%=image %></option>
					<%
				}
			%>
		</select>
		<div id="imageArea">
			
		</div>
	</body>
</html>