<%@ page import="java.util.ArrayList" %>
<%@ page import="tasks.bitlab.db.Book" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Books JSP</title>
  <%@include file="styles.jsp"%>
</head>
<body>
<div class="container mt-3">
  <%@include file="navbar.jsp"%>
  <div class="row mt-3">
    <div class="col-6 mx-auto">
      <%
        String fail = (String) request.getAttribute("issuccess");
        System.out.println(fail);
        if(Objects.equals(fail, "failed")){
      %>
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
        Incorrect login or password!
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <%
        }else if(Objects.equals(fail, "success")){
      %>
      <div class="alert alert-success alert-dismissible fade show" role="alert">
        User created successfully!
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <%
        }
      %>
      <form action="/register" method="post">
        <div class="row mt-3">
          <div class="col-12">
            <label>Full Name:</label>
          </div>
        </div>
        <div class="row mt-1">
          <div class="col-12">
            <input class="form-control" type="text" name="full_name" placeholder="Insert Your Name" required>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>Email:</label>
          </div>
        </div>
        <div class="row mt-1">
          <div class="col-12">
            <input class="form-control" type="email" name="email" placeholder="Insert Email" required>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>Password:</label>
          </div>
        </div>
        <div class="row mt-1">
          <div class="col-12">
            <input class="form-control" type="password" name="password" placeholder="Insert Password" required>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <label>Confirm Password:</label>
          </div>
        </div>
        <div class="row mt-1">
          <div class="col-12">
            <input class="form-control" type="password" name="re-password" placeholder="Repeat Password" required>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-12">
            <button class="btn btn-success">SIGN UP</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
