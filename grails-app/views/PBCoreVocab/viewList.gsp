<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <title>Admin: edit list</title>
  </head>
  <body>
    <h1>${type}</h1>
    <g:if test="${flash.message}">
      <div style="background-color: #fafafa; border-color: #ffdb1f; padding: 10px; border-style: solid; border-width: 1px; width: 33%;">
        <p><strong>! ${flash.message}</strong></p>
      </div>
    </g:if>
    <p>Add a concept: 
      <g:form action="add" method="post">
        <g:hiddenField name="type" value="${type}"/>
        <g:textField name="concept"/>
        <g:submitButton name="submit" value="add"/>
      </g:form>
    </p>
    <table>
      <g:each in="${concepts}" var="concept">
      <tr>
        <td width="50%">${concept.concept}</td>
        <td>edit</td>
        <td><g:link action="remove" id="${concept.id}">delete</g:link></td>
      </tr>
      </g:each>
    </table>
    
  </body>
</html>
