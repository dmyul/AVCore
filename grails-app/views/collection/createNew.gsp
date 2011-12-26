<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <title>AVC - Create new collection</title>
  </head>
  <body>
    <h1>Create new collection</h1>
    <g:form action="commit" method="post">
      <table>
        <tbody>
            <tr>
              <td>identifier</td>
              <td>
                <g:textField name="identifier"/>
              </td>
            </tr>
            <tr>
              <td>title</td>
              <td>
                <g:textField name="title"/>
              </td>
            </tr>
            <tr>
              <td>description</td>
              <td>
                <g:textArea name="description"/>
              </td>
            </tr>
            <tr>
              <td>source</td>
              <td>
                <g:textField name="source"/>
                </td>
            </tr>
            <tr>
              <td/>
              <td>
                <g:submitButton name="submit" value="create"/>
              </td>
            </tr>
          </tbody>
      </table>
      </g:form>
  </body>
</html>
