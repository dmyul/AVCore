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
    <h2>Physical Inventory</h2>
    <table>
      <thead>
        <tr>
          <th>title</th>
          <th>label</th>
          <th>physical description</th>
          <th>media type</th>
          <th>generation</th>
        </tr>
      </thead>
      <g:each in="${pIns}" var="physIns">
        <tr>
          <td>${physIns.docCore.title}</td>
          <td>${physIns.label}</td>
          <td>${physIns.physDesc}</td>
          <td>${physIns.mediaType}</td>
          <td>${physIns.generation}</td> 
        </tr>
      </g:each>
      <tr>
        
      </tr>
    </table>

