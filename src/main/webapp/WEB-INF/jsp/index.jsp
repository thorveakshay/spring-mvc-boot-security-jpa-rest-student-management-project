<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">


    <title>Student Management | Home</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">


    <!--[if lt IE 9]>
    <script src="static/js/html5shiv.min.js"></script>
    <script src="static/js/respond.min.js"></script>
    <![endif]-->


</head>
<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">Bootsample</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="new-student">New Student</a></li>
                <li><a href="all-students">All Students</a></li>
            </ul>
        </div>
    </div>
</div>

<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Welcome to Student Manager</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_TASKS'}">
        <div class="container text-center" id="tasksDiv">
            <h3>My Students</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Birth date</th>
                        <th>Division</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.first_name}</td>
                            <td>${student.last_name}</td>
                            <td>${student.dob}</td>
                            <td>${student.division}</td>
                            <td><a href="update-student?id=${student.id}"><span
                                    class="glyphicon glyphicon-pencil"></span></a></td>
                            <td><a href="delete-student?id=${student.id}"><span
                                    class="glyphicon glyphicon-trash"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
        <div class="container text-center">
            <h3>Manage Student</h3>
            <hr>
            <form class="form-horizontal" method="POST" action="save-student">
                <input type="hidden" name="id" value="${student.id}"/>
                <div class="form-group">
                    <label class="control-label col-md-3">First Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="first_name" value="${student.first_name}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Last Name</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="last_name" value="${student.last_name}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Birth Date</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="dob" value="${student.dob}"/>

                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3">Division</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="division" value="${student.division}"/>

                    </div>
                </div>


                <div class=" form-group">
                        <input type="submit" class="btn btn-primary" value="Save"/>
                    </div>
            </form>
        </div>
    </c:when>
</c:choose>

<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>