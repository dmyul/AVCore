<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <title>Sample title</title>
  </head>
  <body>
      <h1>${col.identifier}: ${col.title}</h1>
      <h2>Create New Unit</h2>
      <g:form action="commit" method="post">
        <g:hiddenField name="colId" value="${params.colId}"/>
        <table>
          <tbody>
            <tr>
              <td>asset type</td>
              <td>
                <g:select name="assetType" from="${vocab.getAt(0).concept}"/>
              </td>
            </tr>
            <tr>
              <td>asset date</td>
              <td>
                <g:datePicker name="assetDate" value="${new Date()}" precision="day"/>
              </td>
            </tr>
            <tr>
              <td>identifier</td>
              <td>
                <g:textField name="identifier"/>
              </td>
            </tr>
            <tr>
              <td>title</td>
              <td><g:textField name="title"/></td>
            </tr>
            <tr>
              <td>description</td>
              <td><g:textField name="description"/></td>
            </tr>
            <tr>
              <td>creator name</td>
              <td><g:textField name="creatorName"/></td>
            </tr>
            <tr>
              <td>creator role</td>
              <td><g:textField name="creatorRole"/></td>
            </tr>
            <tr>
            <tr>
              <td/>
              <td><g:submitButton name="create" value="create unit"/></td>
            </tr>
          </tbody>
        </table>
      </g:form>
  </body>
</html>
