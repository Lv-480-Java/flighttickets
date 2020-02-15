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
    <h1>Plane order panel</h1>
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
    <title>Your order</title>
</head>
<body>
<div align="center">
    <h2>Thanks have a nice flight</h2>
    <b>${order.route} (${order.cost})</b>
    <br><br>
    <b>${location.from_locationStart} (${location.roots_to_location}) (${location.roots_distance}) (${location.transfer}) (${location.to_location}) (${location.distance})</b>
    <br><br>
</div>
</body>
</html>
</head>
<body>
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="bs-example">
                    <table class="table table-dark">
                        <thead>
                        <tr>
                            <th>City</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="route" items="${routeList}">
                            <tr>
                                <td><c:out value="${route}"/></td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="booking-form">

                </div>
            </div>
        </div>
    </div>
</div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
