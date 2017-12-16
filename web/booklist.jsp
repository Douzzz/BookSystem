<%--
  Created by IntelliJ IDEA.
  booksystem.model.User: hh
  Date: 2017/11/27
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>BookSystem HomePage</title>

    <!-- Bootstrap -->
    <link href ="css/bootstrap-theme.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">edit book</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label >name</label>
                        <input type="text" class="form-control" name="name" placeholder="name">
                    </div>
                    <div class="form-group">
                        <label >author</label>
                        <input type="text" class="form-control" name="author" placeholder="author">
                    </div>
                    <div class="form-group">
                        <label>number</label>
                        <input type="text" class="form-control" name="number" placeholder="number">
                    </div>
                    <div class="form-group">
                        <label>description</label>
                        <input type="text" class="form-control" name="description" placeholder="description">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" id="edit"  class="btn btn-primary">Save changes</button>
                    <input class="hidden">
                    <input class="row hidden">
                </div>
            </div>
        </div>
    </div>

    <a href="newbook.jsp">新增</a>
    <table class="table table-hover">
        <tr>
            <th>name</th>
            <th>author</th>
            <th>num</th>
            <th>description</th>
            <th>delete</th>
            <th>edit</th>
        </tr>
        <c:forEach var="book" items="${books}" >
        <tr>
            <td><c:out value="${book.name}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.number}"/></td>
            <td><c:out value="${book.description}"/></td>
            <td class="delete">delete</td>
            <td class="edit" >edit</td>
        </tr>
        </c:forEach>
    </table>
</body>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(function () {
        $('.delete').click(function () {
            var domtr = $(this).parent('tr');
            var name = domtr.children().first().text();
            $.ajax({
                url:"/booklist?name=" + name,
                type:"delete",
                success:function(data){
                    if(data.result == 0) {
                        alert("delete failed!");
                    } else {
                        domtr.remove();
                    }
                },
                error:function(e){
                    alert("错误！！");
                }
            });
        })
    });


    $(function () {
        $(".edit").click(function () {
            var domtr = $(this).parent('tr');
            var name = domtr.children().first().text();
            var author = domtr.children()[1].innerHTML;
            var number = domtr.children()[2].innerHTML;
            var description = domtr.children()[3].innerHTML;

            $('.form-group input')[0].value = name;
            $('.form-group input')[1].value = author;
            $('.form-group input')[2].value = number;
            $('.form-group input')[3].value = description;

            $('.hidden').val(name)
            $('.row').val($(this).parent()[0].rowIndex);
            $('#myModal').modal();
        })
    })

    $(function () {
        $("#edit").click(function () {
            var name = $('.form-group input')[0].value;
            var author = $('.form-group input')[1].value;
            var number = $('.form-group input')[2].value;
            var description = $('.form-group input')[3].value;
            var oldname = $('.hidden').val();
            var row = $('.row').val();

            $.ajax({
                url:"/booklist?name=" + name + "&number=" + number + "&author=" + author + "&description=" + description + "&oldname=" + oldname,
                type:"put",
                success:function(data){
                    if(data.result == 0) {
                        alert("edit failed!");
                    } else {
                        $('#myModal').modal('hide');
                        var choiceRow = $('tbody tr')[row];
                        $(choiceRow).children()[0].innerHTML = name;
                        $(choiceRow).children()[1].innerHTML = author;
                        $(choiceRow).children()[2].innerHTML = number;
                        $(choiceRow).children()[3].innerHTML = description;
                    }
                },
                error:function(e){
                    alert("错误！！");
                }
            });
        })
    })
</script>
</html>
