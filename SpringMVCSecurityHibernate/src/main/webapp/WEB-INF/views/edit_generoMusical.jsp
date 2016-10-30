<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title><spring:message code="message.generomusical.edit.title" text="default text" /></title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="<spring:url value='/resources/css/style.css' />">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<c:url var="addAction" value="/generoMusical/add" ></c:url>
	<c:url var="cancelAction" value="/generoMusical/cancel" ></c:url>

	<form:form cssClass="pure-form pure-form-stacked" action="${addAction}" commandName="generoMusical">
		<fieldset>
			<legend>
				<h2>
					<spring:message code="message.generomusical.edit.title" text="default text" />
				</h2>
			</legend>
			
			<form:label path="nombre">
				<spring:message code="message.generomusical.edit.form.name" text="default text" />(*):
			</form:label>
			
			<form:input cssClass="pure-input-1-4" path="nombre" />
			
			<form:label path="historia">
				<spring:message code="message.generomusical.edit.form.history" text="default text" />:
			</form:label>
			
			<form:textarea cssClass="pure-input-1-4" path="historia"  rows="10"/>
			
			<button type="submit" class="pure-button button-blue button-xlarge"><spring:message code="message.generomusical.edit.form.button.create" text="default text" /></button>
			<a class="pure-button button-red button-xlarge" href="${cancelAction}" ><spring:message code="message.generomusical.edit.button.cancelar" text="default text" /></a>
		</fieldset>
		
	</form:form>
	
	

</body>
</html>
