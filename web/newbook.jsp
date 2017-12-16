<%--
  Created by IntelliJ IDEA.
  User: hh
  Date: 2017/12/5
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NewBook</title>
</head>
<body>
    <form action="booklist" method="post">
        <div class="form-group">
            <label >bookname</label>
            <input type="text" class="form-control" name="bookname" placeholder="BookName">
        </div>
        <div class="form-group">
            <label>author</label>
            <input type="text" class="form-control" name="author" placeholder="Author">
        </div>
        <div class="form-group">
            <label >number</label>
            <input type="text" class="form-control" name="number" placeholder="Number">
        </div>
        <div class="form-group">
            <label>description</label>
            <input type="text" class="form-control" name="description" placeholder="Description">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</body>
</html>
