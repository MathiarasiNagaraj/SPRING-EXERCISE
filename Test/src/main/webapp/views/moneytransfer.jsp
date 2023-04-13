<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form  action="/api/domoneytransfer" method="POST" modelAttribute="Transaction">
	Debit ID:<form:input path="debitId"/><br>
	Credit ID:<form:input path="creditId"/><br>
	Amount :<form:input path="amount"/><br>
	<input type="submit" value="click...">
	
</form:form>