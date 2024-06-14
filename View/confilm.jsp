<%@page contentType="text/html; charset=UTF-8" %>
<% 
 String message = (String)request.getAttribute("message"); 
 if(message == null){ 
 message = ""; 
 } 
%> 
<!DOCTYPE html>
<html>
<head><title>確認</title></head>
<body>
<img src="/DailySystem/View/img/banner.png ">
<h2>確認画面</h2>
<br>
確認画面 confirm.jsp です。<br>
<font color="red"> <%= message %></font>
</body>
</html>