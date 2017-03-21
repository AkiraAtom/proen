<%@ page language="java" contentType="text/html; charset=Windows-31J"
  pageEncoding="Windows-31J"%>
<%@ page import="entity.EmpListBean"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="Windows-31J">
	<title>proen 従業員情報一覧画面</title>
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
		    <li>従業員情報一覧ページはこちら<a href="list" class="button_link">従業員情報一覧ページ</a></li>
		    <li>従業員新規登録ページはこちら<a href="create" class="button_link">従業員情報一覧ページ</a></li>
		    <li>ログアウトはこちら<a href="logout" class="button_link">ログアウト</a></li>
	    </ul>
    </div>

    <hr>
    <form action="book" method="POST">
        <input type="submit" value="削除" name="ACTION">
        <table border="1">
            <col width="50px">
            <col width="50px">
            <tr>
                <td>従業員コード</td>
                <td>氏</td>
                <td>名</td>
                <td>氏(ふりがな)</td>
                <td>名(ふりがな)</td>
                <td>性別</td>
                <td>誕生日</td>
                <td>所属部署名</td>
                <td>入社日</td>
            </tr>
            <%
               ArrayList<EmpListBean> empList = (ArrayList<EmpListBean>) request
                       .getAttribute("empList");
               if(empList != null) {
                   for(int i = 0; i < empList.size(); i++) {
                	   EmpListBean emplist = empList.get(i);
            %>
            <tr>
                <td align="center">
                    <input type="checkbox" name="delete" value="<%=emplist.getEmpCode()%>">
                </td>
                <td><%=i + 1%></td>
                <td><%=emplist.getlName()%></td>
                <td><%=emplist.getlName()%></td>
                <td><%=emplist.getlKanaName()%></td>
                <td><%=emplist.getfKanaName()%></td>
                <td><%=emplist.getSex()%></td>
                <td><%=emplist.getBirthDay()%></td>
                <td><%=emplist.getSectionName()%></td>
                <td><%=emplist.getEmpDate()%></td>
            </tr>
            <%
                   }
               }
            %>
        </table>
    </form>




<footer class="footer">
	<p>&copy; 2017 proen All Rights Reserved.</p>
</footer>

</body>
</html>