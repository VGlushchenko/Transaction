<!DOCTYPE html>
<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core" %>
<% response.sendRedirect("/adduser");%>
<html>
    <head>
        <script src="js/jquery-1.9.1.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="all">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="all">
        <script type="text/javascript">
            $(document).ready(function() {

                $(".signin").click(function(e) {
                    e.preventDefault();
                    $("fieldset#signin_menu").toggle();
                    $(".signin").toggleClass("menu-open");
                });

                $("fieldset#signin_menu").mouseup(function() {
                    return false
                });
                $(document).mouseup(function(e) {
                    if($(e.target).parent("a.signin").length==0) {
                        $(".signin").removeClass("menu-open");
                        $("fieldset#signin_menu").hide();
                    }
                });

            });
        </script>

        <title>New User</title>
    </head>
    <body>

        <ul class="nav nav-tabs">
            <li class="active">
                <a href="">Users</a>
            </li>
            <li><a href="/account">Accounts</a></li>
            <li><a href="transaction">Transactions</a></li>
        </ul>

        <div id="container">
            <div id="topnav" class="topnav"><a href="#" class="signin"><span>Add new User +</span></a> </div>
            <fieldset id="signin_menu">
                <form action="adduser" method="post">
                    Name<br>
                    <input class="input-large" type="text" name="name" value="<c:out value="${form.name}"/>"><br>
                    Email<br>
                    <input class="input-large" type="text" name="email" value="<c:out value="${form.email}"/>"><br>
                    Password<br>
                    <input class="input-large" name="password" value="" title="password" tabindex="5" type="password"><br>
                    <input class="btn btn-primary" value="Add" tabindex="6" type="submit">
                </form>
            </fieldset>
        </div>

        <h4>List Users</h4>

        <table class="table table-striped" cellpadding="4" cellspacing="4">
            <tr><th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Action</th>
            </tr>

            <c:if test="${users != null }">
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td> <c:out value="${user.id}"/></td>
                        <td> <c:out value="${user.name}"/></td>
                        <td> <c:out value="${user.email}"/></td>
                        <td> <c:out value="${user.password}"/></td>
                        <td>
                            <input class="btn btn-primary" value="Update" onclick="location.href='/#'" type="button"/>
                            <input class="btn btn-primary" value="Delete" onclick="location.href='/#'" type="button"/>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

        </table>
        <h4>Create Account</h4>
        <form action="/account" method="post">
            Select User:<br>
            <select name="userId">
                <c:if test="${users != null }">
                    <c:forEach var="user" items="${users}">
                        <option value="<c:out value="${user.id}"/>"><c:out value="${user.name}"/></option>
                    </c:forEach>
                </c:if>
            </select>

            <input type="text" class="input-large" name="name" placeholder="Add Account" value="<c:out value="${accName}" />">
            <input type="submit" value="Create" class="btn btn-primary">
        </form>

    </body>
</html>
