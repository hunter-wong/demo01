<%--
  Created by IntelliJ IDEA.
  User: ibm
  Date: 2018/7/24
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="js/jquery1.42.min.js"></script>
</head>
<body>


<form action="user/excelImport" method="post"enctype="multipart/form-data">
    <input type="file" name="excel">
    <input type="submit" value="导入">
</form>



<hr>
<table border="1" width="100%">
    <tr>
        <th>id</th><th>name</th><th>sex</th><th>birthday</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>
                    ${user.id}
            </td>
            <td>
                    ${user.name}
            </td>
            <td>
                    ${user.sex}
            </td>
            <td>
                    ${user.birthday}
            </td>
        </tr>
    </c:forEach>
</table>

<hr>
<input type="button" value="导出" onclick="exp()">
<script>
        function exp(){
            $.ajax({
                type:'get',
                url:'user/exp',
                success:function (data) {
                    if (data == 'ok'){
                        alert('导出成功')
                    }
                },
                error:function () {
                    alert("导出失败")
                }
            });
        }
    
</script>
</body>
</html>
