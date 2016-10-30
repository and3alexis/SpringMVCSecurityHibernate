<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>
		<spring:message code="message.generomusical.list.title" text="default text" />
	</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="<spring:url value='/resources/css/jquery-confirm.min.css' />">
	<link rel="stylesheet" href="<spring:url value='/resources/css/style.css' />">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	
	<form:form cssClass="pure-form pure-form-stacked">
		
		<fieldset>
			<legend>
					<h2><spring:message code="message.generomusical.list.title" text="default text" /></h2>
			</legend>
		</fieldset>
		
	</form:form>
	
	<a class="pure-button button-green button-xlarge" href="<c:url value='/generoMusical/create' />" >
		<spring:message code="message.generomusical.list.button.create" text="default text" />
	</a>
	<br/>
	<br/>
	
	<c:if test="${!empty listGenerosMusicales}">
		
		<table class="pure-table pure-table-striped">
		<thead>
			<tr>
				<th><spring:message code="message.generomusical.list.table.column.id" text="default text" /></th>
				<th><spring:message code="message.generomusical.list.table.column.nombre" text="default text" /></th>
				<th><spring:message code="message.generomusical.list.table.column.historia" text="default text" /></th>
				<th><spring:message code="message.generomusical.list.button.edit" text="default text" /></th>
				<th><spring:message code="message.generomusical.list.button.delete" text="default text" /></th>
			</tr>
		</thead>
		<c:forEach items="${listGenerosMusicales}" var="generoMusical">
			<tr>
				<td>${generoMusical.id}</td>
				<td>${generoMusical.nombre}</td>
				<td>${generoMusical.historia}</td>
				<td><a href="<c:url value='/generoMusical/edit/${generoMusical.id}' />" ><spring:message code="message.generomusical.list.button.edit" text="default text" /></a></td>
				<td><a class="confirmLink" href="<c:url value='/generoMusical/remove/${generoMusical.id}' />" ><spring:message code="message.generomusical.list.button.delete" text="default text" /></a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="<spring:url value='/resources/js/jquery-confirm.min.js' />"></script>
	<script src="<spring:url value='/resources/js/core.js' />"></script>

</body>
</html>
