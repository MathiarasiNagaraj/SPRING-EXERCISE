<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form  action="/api/createuser" method="POST" modelAttribute="User">
	UserID:<form:input path="id"/><br>
	UserName:<form:input path="name"/><br>
	Amount:<form:input path="amount"/><br>
	<input type="submit" value="click...">
	
</form:form>