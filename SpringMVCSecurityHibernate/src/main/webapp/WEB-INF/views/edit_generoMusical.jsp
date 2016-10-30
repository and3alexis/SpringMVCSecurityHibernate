<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Generos Musicales Page</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="<spring:url value='/resources/css/style.css' />">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<c:url var="addAction" value="/generoMusical/add" ></c:url>
	<c:url var="cancelAction" value="/generoMusical/cancel" ></c:url>

	<form:form cssClass="pure-form pure-form-stacked" action="${addAction}" commandName="generoMusical">
		<fieldset>
			<legend><h1>Editar Genero Musical</h1></legend>
			
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
			
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
			
			<form:label path="nombre">
				<spring:message text="Name"/>
			</form:label>
			
			<form:input cssClass="pure-input-1-4" path="nombre" />
			
			<form:label path="historia">
				<spring:message text="Historia"/>
			</form:label>
			
			<form:textarea cssClass="pure-input-1-4" path="historia" />
			
			<button type="submit" class="pure-button pure-button-primary">Add</button>
		</fieldset>
		
	</form:form>
	
	<a class="pure-button button-green button-xlarge" href="${cancelAction}" >Cancel</a>

</body>
</html>
