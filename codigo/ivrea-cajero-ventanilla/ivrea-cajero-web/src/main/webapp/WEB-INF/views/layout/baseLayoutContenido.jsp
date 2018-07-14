<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../taglib.jsp" %>
<%@ include file="../staticResources.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>
<div class="container">
    <div class="row" style="margin-bottom:11%">
        <div class="col">
                <div class="header">
                    <tiles:insertAttribute name="header" />
                </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="areaTrabajo">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="footer">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </div>
</div>
</body>
</html>