<%--
  Created by IntelliJ IDEA.
  User: hsenid
  Date: 5/9/16
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/bootstrap/css/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
  <link href="assets/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="assets/css/form-elements.css">
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <!-- <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">-->
  <link rel="stylesheet" href="assets/css/form-elements.css">
  <link rel="stylesheet" href="assets/css/style.css">
  <link rel="stylesheet" type="text/css" href="successDesign.css">


  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script type="text/javascript" src="assets/js/date.js"></script>
  <script src="assets/js/date.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

  <!-- <script src="jquery.date-dropdowns.min.js"></script>-->
  <link rel="shortcut icon" href="assets/ico/favicon.png">
  <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" media="all" href="datepicker/daterangepicker.css" />
  <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>
  <script type="text/javascript" src="datepicker/moment.js"></script>
  <script type="text/javascript" src="datepicker/daterangepicker.js"></script>

</head>
<body>
<fmt:bundle basename="jstl_fmt">
 <%-- <%
    String role= (String)session.getAttribute("Role");
    pageContext.setAttribute("role",role);
  %>&ndash;%&gt;
  <c:choose>
    <c:when test="{role == 'Administrator'}">
        <li><a href="signup.jsp">Add User</a></li>
        <li><a href="searchuser.jsp">Search</a></li>

    </c:when>
    <c:otherwise>
      <li><a href="logoutprocess.jsp">Search</a></li>

    </c:otherwise>
  </c:choose>--%>--%>
<div class="container">
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <ul class="nav navbar-nav">
      <li id="translate_lst"><a href="success.jsp">
        <fmt:message key="header.translate_lst"> </fmt:message>
      </a></li>
      <li class="dropdown">
        <a class="dropdown-toggle-active" data-toggle="dropdown" href="#">User Panel <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li id="adduser_lst"><a href="signup.jsp">
            <fmt:message key="header.adduser_lst"> </fmt:message>
          </a></li>
          <li id="search_lst"><a href="searchuser.jsp"><fmt:message key="header.search_lst"> </fmt:message></a></li>
        </ul>
      </li>

    </ul>
  </nav>
</div>
  <%--<ul id="nav">

    <%
      //String username= (String) session.getAttribute("username");
      String username=request.getParameter("username");
      if (username == "kk") {
    %>
    <li><a href="signup.jsp">Register</a></li>
    <li><a href="searchuser.jsp">search</a></li>

    <% } else {
    %>
    <li> (<a href="logoutprocess.jsp">all</a>)</li>
    <% }%>
  </ul>--%>
<div class="col-sm-8 col-sm-offset-2 text">
</div>
</fmt:bundle>

</body>
</html>
