<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Система управления проектами</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>
<script src="/js/action-buttons.js" type="text/javascript"></script>

</head>
<body>
	<p>${currentUser.login}, добро пожаловать в систему управления проектами!</p>

	
		<c:if test="${user.role == 'ADMINISTRATOR'}">
            <div><a href="/admin">Кнопка для админа</a></div>
        </c:if>
	
	<br><br>
	
	<a href="/board/${board.id}" class="add-board-page-reload">Добавить новую доску с перезагрузкой страницы</a>
	
	<br><br>
	
	<button type="button" class="add-board-ajax">Добавить новую доску динамически</button>
	
	<br><br>

	<table>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td><a href="/board/${board.id}">${board.name}</a></td>
			</tr>
		</c:forEach>
	</table>

	<br><br>
	<a href="/logout">Выход</a>
	<br>
</body>
</html>