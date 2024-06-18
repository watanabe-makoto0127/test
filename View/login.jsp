<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>ログイン</title></head>
<body>
<img src="/DailySystem/View/img/banner.png">
<h2>ログイン</h2>
<br>
<form action="/DailySystem/login" method="post">
 ログイン ID：<input type="text" name="id"><br>
 パスワード：<input type="password" name="pass"><br>
 <input type="submit" name="login" value="ログイン">
</form>

</body>
</html>
