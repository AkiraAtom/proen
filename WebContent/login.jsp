<%@ page language="java" contentType="text/html; charset=Windows-31J"
  pageEncoding="Windows-31J"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="Windows-31J">
	<title>proen ���O�C�����</title>
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
	<h4>���O�C��</h4>
	<div class="form">
		<form action="login" method="post" name="myForm" onSubmit="validateForm()">
			<p id="emailValidation"></p>
			<input type="text" name="userId" size="40" class="textField"
			pattern="^[0-9A-Za-z]+$" title="���p�p��24�����ȓ��Ń��[�UID����͂��Ă�������"
			placeholder="���[�UID:�@�@�@24�����ȓ��œ���" maxlength="24"/>
            <p id="passwordValidation"></p>
			<input type="password" name="password" size="40" class="textField"
			pattern="^[0-9A-Za-z]+$" title="���p�p����32�����ȓ��Ńp�X���[�h����͂��Ă�������"
			placeholder="�p�X���[�h:�@�@�@32�����ȓ��œ���"  maxlength="32"/>


			<input type="submit" value="���O�C��"  class="submit_button"  name="ACTION"/>

		</form>
	</div>
    <div class="link_wrap">
	    <ul>
		    <li>���o�^�̕��͂�����<a href="GoUserCreateServlet" class="button_link">�V�K�o�^</a></li>
	    </ul>
    </div>






<footer class="footer">
	<p>&copy; 2017 proen All Rights Reserved.</p>
</footer>

</body>
</html>