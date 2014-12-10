<%-- 
    Document   : prova
    Created on : 10-dic-2014, 9.50.54
    Author     : johneisenheim
--%>

<%@page import="it.unisa.tirocinio.manager.concrete.ConcreteMessageForServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="/getStudentTrainingStatus" />
        <c:set var="statusMessage" value="${requestScope.message }"></c:set>
        <%
            ConcreteMessageForServlet _message = (ConcreteMessageForServlet)pageContext.getAttribute("statusMessage");
            int status = (Integer)_message.getMessage("status");
            String description = (String)_message.getMessage("description");
            pageContext.setAttribute("status", status);
            pageContext.setAttribute("description", description);
        %>
        <c:out value="The status is ${status} and the description is ${description}"></c:out>
    </body>
</html>
