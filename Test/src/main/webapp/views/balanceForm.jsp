<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form  action="/api/checkbalance" method="POST" modelAttribute="User">
	UserID:<form:input path="id"/><br>
	<input type="submit" value="click...">
	
</form:form>