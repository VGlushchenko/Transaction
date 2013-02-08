<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Success!</title>
    </head>
    <body>

        <h4>Employee list</h4>

        <table cellpadding="4" cellspacing="4">
            <tr><th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
            </tr>

            <c:if test="${users != null }">
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td> <c:out value="${user.id}"/></td>
                        <td> <c:out value="${user.name}"/></td>
                        <td> <c:out value="${user.email}"/></td>
                        <td> <c:out value="${user.password}"/></td>
                    </tr>
                </c:forEach>
            </c:if>

        </table>
        
        <form action="/update" method="POST">
            <input type="submit" value="Add new User"><br>
        </form>
        
    </body>
</html>