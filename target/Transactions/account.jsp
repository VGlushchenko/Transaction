<!DOCTYPE html>
<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core" %>
<% response.sendRedirect("/adduser");%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="all">
        <title>New User</title>
    </head>
    <body>

        <ul class="nav nav-tabs">
            <li><a href="/adduser">Users</a></li>
            <li class="active"><a href="">Accounts</a></li>
            <li><a href="transaction">Transactions</a></li>
        </ul>

        <form action="/transaction" method="post">
            From:<br>
            <select name="accIdFrom">
                <c:if test="${accounts != null }">

                    <c:forEach var="acc" items="${accounts}">
                        <option value="<c:out value="${acc.id}"/>"><c:out value="${acc.name}"/></option>
                    </c:forEach><br>

                </c:if>
            </select><br>

            To:<br>
            <select name="accIdTo">
                <c:if test="${accounts != null }">
                    <c:forEach var="acc" items="${accounts}">
                        <option value="<c:out value="${acc.id}"/>"><c:out value="${acc.name}"/></option>
                    </c:forEach>
                </c:if>
            </select>

            <input type="text" class="input-large" name="summ" placeholder="summ">
            <input type="submit" value="Add Transaction" class="btn btn-primary">
        </form>

        <h5><c:out value="${error}" /></h5>

        <table class="table table-striped" cellpadding="4" cellspacing="4">
            <tr><th>Id</th>
                <th>Name</th>
                <th>User Id</th>
                <th>Type Id</th>
                <th>Action</th>
            </tr>

            <c:if test="${accounts != null }">
                <c:forEach var="acc" items="${accounts}">
                    <tr>
                        <td> <c:out value="${acc.id}"/></td>
                        <td> <c:out value="${acc.name}"/></td>
                        <td> <c:out value="${acc.user.name}"/></td>
                        <td> <c:out value="${acc.typeId}"/></td>
                        <td>
                            <input class="btn btn-primary" value="Update" onclick="location.href='/edit?action=update&accId=<c:out value="${acc.id}"/>'" type="button"/>
                            <input class="btn btn-primary" value="Delete" onclick="location.href='/edit?action=delete&accId=<c:out value="${acc.id}"/>'" type="button"/>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

        </table>

    </body>
</html>
