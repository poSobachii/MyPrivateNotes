<%@ page import="myshop.BasketPack.BasketOrder"%>

<%
String name =(String)request.getParameter("bla2");
String id = (String)request.getParameter("blablabla");
out.println(name + " Added to the Basket");
BasketOrder.addOrder(id);
%>