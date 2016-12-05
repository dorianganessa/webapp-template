<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/style.min.css" />
<title>Accedi all'area riservata</title>
</head>
<body class="login" onload='document.loginForm.username.focus();'>
<div class="content">
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4 login-form">
	   <c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>	
		
			<a href="/LaMagis/" class="navbar-brand"><span class="glyphicon glyphicon-home"></span>LaMagis</a>
				
		
						
						
				<form:form method="POST" action="login" modelAttribute="user">
				<div class="col-xs-12">
					<div class="form-group has-feedback">
						<label class="control-label" for="username">Inserisci username</label>
						<div class="input-group">
						    <span class="input-group-addon glyphicon glyphicon-user"></span>
						    <input type="text" class="form-control" id="username" name="username" aria-describedby="username">
						</div>
					</div>
				</div>
				<div class="col-xs-12">
					<div class="form-group">
					    <label for="password" class="control-label">Inserisci password</label>
					    <div class="input-group">
					    	<span class="input-group-addon glyphicon glyphicon-lock"></span>
					      <input type="password" class="form-control" id="password" name="password" placeholder="">
					    </div>
					</div>
				</div>
				<div class="col-xs-3"><input name="submit" type="submit" value="Login" class="btn btn-primary"/></div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form:form>
		</div>
	</div>
</div>
</body>
</html>