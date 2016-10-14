<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit users</title>
</head>
<body>
	<form action="usuario" method="post">
		<fieldset>
			<legend>Form to edit users</legend>
			<label for="pk">Id:</label> 
			<input type="text" name="id" id="pk" value="${user.id }" size="3"   ><br>
			<label for="nam">Name:</label> <input type="text" name="name"
				id="nam" value="${user.name }"><br> 
			<label for="lastname">Last Name:</label> <input type="text" name="lastname"
				id="lastname" value="${user.lastname }"  ><br>
            <label for="user">Nick:</label> <input type="text" name="user"
				id="user" value="${user.user }"  ><br>
			<label for="key">Password:</label> <input
				type="password" name="password" id="clave" value="${user.password }">
			<input type="hidden" value="EDIT" name="action">
		</fieldset>
		<input type="submit" value="Send">

	</form>

</body>
</html>
