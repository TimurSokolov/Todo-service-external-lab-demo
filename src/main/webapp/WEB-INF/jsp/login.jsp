<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Вход</title>

<link rel="stylesheet" type="text/css" href="/css/base-style.css" />

</head>
<body>
	<form action="/login" method="post" id="login-form">
		<fieldset>
			<legend>Вход</legend>
			<p>
				<label>Login</label>
				<input name="login" id="login">
			</p>
			<p>
				<label>Пароль<em>*</em></label>
				<input name="password">
			</p>
		</fieldset>

		<p>
			<input type="submit" value="Войти">
		</p>
	</form>
	<br>
	<a href="/registration">Регистрация</a>
	<br>
	<br>
${error}


</body>
</html>