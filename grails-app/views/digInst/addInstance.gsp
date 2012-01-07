<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <title>AVCore: add digital instance</title>
  </head>
  <body>
    <div style=" padding-left: 10px;">
      <h1>
        <g:link controller="collection" action="col" id="${core.collection.id}">${core.collection.identifier}: ${core.collection.title}</g:link>
      </h1>
      <h2>${core.title}</h2>
      <h3>add a digital instance</h3>
      <div style="padding-top: 10px">
        <g:uploadForm action="readMediaInfo" method="post" id="${core.id}">
          <input type="hidden" name="mediaType" value="${mediaType}"/>
          <label for="payload">File:</label>
          <input type="file" id="payload" name="payload"/>
          <g:submitButton name="submit" value="submit"/>
        </g:uploadForm>
      </div>
  </body>
</html>
