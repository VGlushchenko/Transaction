<!DOCTYPE html>
<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="all">
    <title>New User</title>
</head>
<body>

    <ul class="nav nav-tabs">
        <li><a href="/adduser">Users</a></li>
        <li><a href="/account">Accounts</a></li>
        <li class="active"><a href="">Transactions</a></li>
    </ul>

<table class="table table-striped" cellpadding="4" cellspacing="4">
    <tr><th>Id</th>
        <th>Debet</th>
        <th>Credit</th>
        <th>Summ, $</th>
    </tr>

    <c:if test="${transactions != null }">
        <c:set var="i" value="${0}" />
        <c:set var="summ" value="${0}" />
        <c:forEach var="tr" items="${transactions}">
            <c:set var="summ" value="${summ + tr.sum}" />
            <tr>
                <td> <c:out value="${tr.id}"/></td>
                <td> <c:out value="${tr.debetAccount.id}"/></td>
                <td> <c:out value="${tr.creditAccount.id}"/></td>
                <td> <c:out value="${tr.sum}"/></td>
            </tr>
        </c:forEach>
        <tr>
            <td>Total</td>
            <td> </td>
            <td> </td>
            <td><c:out value="${summ}"/> $</td>
        </tr>
    </c:if>

</table>

</body>
</html>
