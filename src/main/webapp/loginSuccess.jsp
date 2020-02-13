<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <h1>Welcome to flight tickets order panel</h1>
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
<center>
    <h1>Departures</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>From</th>
            <th>To</th>
            <th>Distance</th>
        </tr>
        <c:forEach var="root" items="${rootList}">
            <tr>
                <td><c:out value="${root.id_root}" /></td>
                <td><c:out value="${root.from_Location}" /></td>
                <td><c:out value="${root.to_Location}" /></td>
                <td><c:out value="${root.distance}" /></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Booking Form HTML Template</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="css/style.css" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div id="booking" class="section">
    <div class="section-center">
        <div class="container">
            <div class="row">
                <div class="booking-form">
                    <form  action="order" method="POST">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <span class="form-label">Flying from</span>
                                    <input class="form-control" type="text" name="from_Location" placeholder="City or airport">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <span class="form-label">Flyning to</span>
                                    <input class="form-control" type="text" name="to_Location" placeholder="City or airport">
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="form-btn">
                                    <button class="submit-btn">Show flights</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>