<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Регистрация</title>
</head>
<body>
	<form action="registration" method="post">
		<fieldset>
			<legend>Регистрация</legend>
			<p>
				<label>Login<em>*</em></label>
				<input name="login">
			</p>
			<p>
				<label>Имя</label>
				<input name="name">
			</p>
			<p>
				<label>E-mail</label>
				<input name="email">
			</p>
			
			<p>
				<label>Дата рождения</label>
				<input name="birthday">
			</p>
			
			<p>
				<label>Enum (ADMINISTRATOR/USER)</label>
				<input name="role">
			</p>
		</fieldset>

		<p>
			<input type="submit" value="Регистрация">
		</p>
	</form>
	<br>
	<br>
	<c:forEach var="error" items="${errors}">

			${error.defaultMessage}<br>

	</c:forEach>
</body>
</html>