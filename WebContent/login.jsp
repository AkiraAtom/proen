<%@ page language="java" contentType="text/html; charset=Windows-31J"
  pageEncoding="Windows-31J"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="Windows-31J">
	<title>proen ログイン画面</title>
	<link rel="SHORTCUT ICON" href="img/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/Style.css">
	<link rel="stylesheet" type="text/css" href="css/Login.css">
	<script src="js/loginValidation.js"></script>

</head>

<body>

<header>
	<nav>
		<ul>
			<li class="project_title"><a href="menu.jsp">proen</a></li>
		</ul>
	</nav>
</header>
	<h4>ログイン</h4>
	<div class="form">
		<form action="login" method="post" name="myForm" onSubmit="validateForm()">
			<p id="emailValidation"></p>
			<input type="text" name="userId" size="40" class="textField"
			pattern="^[0-9A-Za-z]+$" title="半角英数24文字以内でユーザIDを入力してください"
			placeholder="ユーザID:　　　24文字以内で入力" maxlength="24"/>
            <p id="passwordValidation"></p>
			<input type="password" name="password" size="40" class="textField"
			pattern="^[0-9A-Za-z]+$" title="半角英数字32文字以内でパスワードを入力してください"
			placeholder="パスワード:　　　32文字以内で入力"  maxlength="32"/>


			<input type="submit" value="ログイン"  class="submit_button"  name="ACTION"/>

		</form>
	</div>
    <div class="link_wrap">
	    <ul>
		    <li>未登録の方はこちら<a href="GoUserCreateServlet" class="button_link">新規登録</a></li>
	    </ul>
    </div>






<footer class="footer">
	<p>&copy; 2017 proen All Rights Reserved.</p>
</footer>

</body>
</html>