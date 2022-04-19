<%-- 
    Document   : details
    Created on : Apr 19, 2022, 5:16:18 PM
    Author     : Dung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.dung.mobileshop.models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jakarta.servlet.RequestDispatcher"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
        <title>Product Page</title>
        <style>
            .product-container{
                display: flex;
                flex-direction: row;
                margin: 20px;
                padding: 5px;
                border-radius: 10px;
                background: #e7e6e6;
            }
            
            .product-card{                
                margin: 10px;
                padding: 5px;
                width: 130px;
                height: 200px;
                border-radius: 10px;
                border: 4px solid #de22ad;
                cursor: pointer;
                box-shadow: 1px 2px #888888;
            }
            
            .product-card:hover{ 
                background: white;
                border: 4px solid #ed6dcc;                
            }
            
            .desc-text{
                font-size: 12px;
                color: #de22ad;
            }
            
            .product-image{
                width: 110px;
                height: 140px;
            }
        </style>
    </head>
    <body>        
        <div id="main">          
            <jsp:include page="./WEB-INF/layout/header.jspf" />
            <div id="leftMenu">
                left column
            </div>
            <div id="content">                
                <div class="product-container">
                details
                 <%
                List<Product> pdts = (List<Product>)request.getAttribute("productList");
                int count =0;
                if(pdts!=null){
                    for(Product prod: pdts){
                        count++;
                    %>
                        <div class='product-card'">
                        <div><img class='product-image' src='images/mobile_example.jpg'/></div>
                        <div class='desc-text'><%=prod.getName()%></div>
                        <div class='desc-text'>VND<%=prod.getPrice()%></div>
                        <div class='desc-text'>VND<%=prod.getSize()%></div>
                        </div>                        
                    <%                        
                    }
                }
                %>
                </div>
            </div>
            <jsp:include page="./WEB-INF/layout/footer.jspf" />
        </div>       
    </body>
</html>