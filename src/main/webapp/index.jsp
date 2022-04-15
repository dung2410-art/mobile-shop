<%-- 
    Document   : index
    Created on : Apr 14, 2022, 2:42:26 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="main">          
            <jsp:include page="./WEB-INF/layout/header.jspf" />
            <div id="leftMenu">
                left column
            </div>
            <div id="content">
                <h1>Hello World!</h1>        
                <form name="Name Input Form" action="response.jsp">
                    Enter your name:
                    <input type="text" name="name" />
                    <input type="submit" value="OK" />
                </form>                
            </div>
            <jsp:include page="./WEB-INF/layout/footer.jspf" />
        </div>       
    </body>
</html>
