<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Система управления проектами</title>
</head>
<body>
	<p>${currentUser.login}, добро пожаловать в систему управления проектами!</p>

	<table>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td><a href="/board/${board.id}">${board.name}</a></td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<br>
	<a href="/logout">Выход</a>
	<br>
</body>
</html>