<%--
  Created by IntelliJ IDEA.
  booksystem.model.User: hh
  Date: 2017/11/25
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>BookSystem</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <form method="POST" action="login">
    <div class="form-group">
      <label >username</label>
      <input type="text" class="form-control" name="username" placeholder="Username">
    </div>
    <div class="form-group">
      <label>Password</label>
      <input type="password" class="form-control" name="password" placeholder="Password">
    </div>
    <div class="checkbox">
      <label>
        <input type="checkbox"> Check me out
      </label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
  <lable class="alert-danger">
    <% if(request.getAttribute("message") != null){ %>
      <%= request.getAttribute("message") %>
    <% } %>
  </lable><br>
  <lable class="alert-warning">
    ${message}
  </lable>
  <script src="js/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>