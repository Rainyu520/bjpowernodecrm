
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" >
        $.ajax({
            "url":"",
            "data":"",
            "type":"",
            "dataType":"json",
            "success":function () {

            }
        })
    </script>
</head>
<body>

</body>
</html>
