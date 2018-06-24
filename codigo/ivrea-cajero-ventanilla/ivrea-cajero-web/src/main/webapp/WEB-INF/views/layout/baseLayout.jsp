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
<table>
      <tr>
        <td>
          <div class="header">
            <tiles:insertAttribute name="header" />
          </div>
        </td>
      </tr>
      <tr>
        <td>
          <div class="areaTrabajo">
            <tiles:insertAttribute name="body" />
          </div>
        </td>
      </tr>
      <tr>
        <td>
          <div class="footer">
            <tiles:insertAttribute name="footer" />
          </div>
        </td>
      </tr>
    </table>
</body>
</html>