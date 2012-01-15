<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <title>AV/Core Collections</title>
  </head>
  <body>
    
    <h2>AV/Core Collections</h2>
      <table>
        <thead>
          <tr>
            <th width="15%">identifier</th>
            <th>title</th>
            <th>actions</th>
          </tr>
        </thead>
        <tbody>
          <g:each in="${cols}" var="col">
          <tr>
            <td><g:link action="col" id="${col.id}">${col.identifier}</g:link></td>
            <td>${col.title}</td>
            <td>
              <img src="${createLinkTo(dir: 'images/icons', file: 'delete_32x32.png')}" width="20px" height="20px"/>
              <img src="${createLinkTo(dir: 'images/icons', file: 'edit_32x32.png')}" width="20px" height="20px"/>
            </td>
          </tr>
          </g:each>
        </tbody>
      </table>
      <g:form action="createNew">
        <g:submitButton name="submit" value="create new"/>
      </g:form>
  </body>
</html>
