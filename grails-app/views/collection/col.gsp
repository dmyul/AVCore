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
    
    <h1>${cols.identifier}: ${cols.title} <g:link action="inventory" id="${cols.id}">[view inventory]</g:link></h1>
      <p><b>source</b>: ${cols.source}</p>
      <p><b>description</b>:${cols.description}</p>
      <br />
      <g:if test="${cols.docCore.size() > 0}">
        <h2>Bibliographic Units</h2>
        <table id="unitTable">
          <thead>
            <tr><th>title</th><th>asset type</th><th>asset date</th><th>action</th></tr>
          </thead>
          <tbody>
            <g:each in="${cols.docCore}" var="core">
              <tr>
                <td>
                  <g:link controller="docCore" action="core" id="${core.id}">${core.title}</g:link>
                </td>
                <td>${core.assetType}</td>
                <td>${core.assetDate}</td>
                <td>
                  <g:link controller="docCore" action="deleteCore" id="${core.id}">
                    <img src="${createLinkTo(dir: 'images/icons', file: 'delete_32x32.png')}" width="20px" height="20px"/>
                  </g:link>
                  <img src="${createLinkTo(dir: 'images/icons', file: 'edit_32x32.png')}" width="20px" height="20px"/>
                  <img src="${createLinkTo(dir: 'images/icons', file: 'wrench_32x32.png')}" width="20px" height="20px"/>
                </td>
              </tr>
            </g:each>
          </tbody>
          <tfoot>
            <tr>
           
            </tr>
          </tfoot>
        </table>
        
      </g:if>
      <g:form controller="docCore" action="createCore" method="post">
          <g:hiddenField name="colId" value="${cols.id}"/>
          <g:submitButton name="submit" value="create new unit"/>
        </g:form>

  </body>
</html>
