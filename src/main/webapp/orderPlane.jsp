<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Tickets</title>
    <meta charset="utf-8">
    <title>Order panel flight tickets</title>
</head>
<body>
<div style="text-align: center">
    <h1>Route order panel</h1>
    <b>${user.firstName} (${user.lastName})</b>
    <br><br>
    <a href="http://localhost:8080/flighttickets_war_exploded/">Logout</a>
</div>
</body>
</html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Tickets</title>
    <title>Order tickets</title>
</head>
<body>
<div align="center">
    <h2>Direct route</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Id_route</th>
            <th>From</th>
            <th>To</th>
            <th>Distance</th>
            <th>Action</th>
        </tr>
        <c:forEach var="route" items="${routes}">
            <tr>
                <td><c:out value="${route.id_root}" /></td>
                <td><c:out value="${route.from_Location}" /></td>
                <td><c:out value="${route.to_Location}" /></td>
                <td><c:out value="${route.distance}" /></td>
                <td>
                    <a href="http://localhost:8080/flighttickets_war_exploded/plane?id_root=<c:out value='${route.id_root}' />">add</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <table border="1" cellpadding="5">
        <c:if test="${location == null}">
            <h2>No multicity transfer</h2>
        </c:if>
            <c:if test="${location!= null}">
                <h2>Multicity transfer</h2>
        <tr>
            <th>From</th>
            <th>To</th>
            <th>Distance</th>
            <th>Id_route</th>
            <th>From</th>
            <th>To</th>
            <th>Distance</th>
        </tr>
        <tr>
        <td>${location.from_locationStart}</td>
        <td>${location.roots_to_location}</td>
        <td>${location.roots_distance}</td>
        <td>${location.transfer}</td>
        <td>${location.to_location}</td>
        <td>${location.distance}</td>
            <td>
                <a href="http://localhost:8080/flighttickets_war_exploded/plane?id=<c:out value='${route.id_root}' />">add</a>
            </td>
        </tr>
</c:if>
    </table>
</div>
</body>
</html>