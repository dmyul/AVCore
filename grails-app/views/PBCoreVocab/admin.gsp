<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <title>Admin</title>
  </head>
  <body>
    <h1>Admin</h1>
    <ul>
      <g:each in="${list}" var="type">
        <g:link action="viewList" id="${type}">${type}</g:link><br />
      </g:each>
    </ul>
  </body>
</html>
