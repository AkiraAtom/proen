<%@ page language="java" contentType="text/html; charset=Windows-31J"
  pageEncoding="Windows-31J"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="Windows-31J">
	<title>proen メニュー画面</title>
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
	<h4>メニュー</h4>
	<div class="link_wrap">
	    <ul>
		    <li>従業員情報一覧ページはこちら<a href="emp_list" class="button_link">従業員情報一覧ページ</a></li>
		    <li>従業員新規登録ページはこちら<a href="/proen/emp_create.jsp" class="button_link">従業員新規登録ページ</a></li>
		    <li>ログアウトはこちら<a href="/proen/logout.jsp" class="button_link">ログアウト</a></li>
	    </ul>
    </div>






<footer class="footer">
	<p>&copy; 2017 proen All Rights Reserved.</p>
</footer>

</body>
</html>