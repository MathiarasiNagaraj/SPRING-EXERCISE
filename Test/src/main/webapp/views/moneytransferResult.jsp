<h1>Transaction done</h1>
<h1>Creditor Id</h1><%= request.getAttribute("CreditId") %>
<h1>Creditor previous  Balance</h1><%= request.getAttribute("CrediterpreviousCurrentBalance") %>
<h1>Creditor current Balance</h1><%= request.getAttribute("CrediterCurrentBalance") %>
<h1>Debitor Id</h1><%= request.getAttribute("debitId") %>
<h1>Debitor  previous Balance</h1><%= request.getAttribute("Debitorpreviouscurrentbalance") %>
<h1>Debitor current Balance</h1><%= request.getAttribute("Debitorcurrentbalance") %>
<button><a href="/api">Back to Home</a></button>