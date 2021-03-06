<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <title>AV/Core: Create Moving Image Physical Instance</title>
  </head>
  <body>
    <div id="front">
      <h1>
        <g:link controller="collection" action="col" id="${core.collection.id}">${core.collection.identifier}: ${core.collection.title}</g:link>
      </h1>
      <h2>${core.title}</h2>
    </div>
    <br />
    <div id="form">
      <h3>Create Moving Image Physical Instance</h3>
      <g:form action="commitInst" method="post">
        <table>
          <tbody>
            
            <tr>
              <td>media type</td>
              <td><g:textField name="mediaType" value="Moving image"/></td>
            </tr>
            
            <tr>
              <td>label</td>
              <td><g:textField name="label"/></td>
            </tr>
            
            <tr>
              <td>generation</td>
              <td><g:select name="generation" from="${['Original recording', 'Copy: access', 'Master: preservation']}"/></td>
            </tr> 
            <tr>
              <td>physical description</td>
              <td><g:select name="physDesc" from="${pIns.concept}"/></td>
            </tr> 
            <tr>
              <td>barcode</td>
              <td><g:textField name="barcode"/></td>
            </tr>
            <tr>
              <td>location</td>
              <td><g:textField name="location"/></td>
            </tr>
            <tr>
              <td>date: </td>
              <td><g:datePicker name="date" precision="day"/></td>
            </tr>
            <tr>
              <td>date type</td>
              <td><g:select name="dateType" from="${dType.concept}"/></td>
            </tr>
            <tr>
              <td>dimensions</td>
              <td><g:textField name="dimensions"/></td>
            </tr>
            <tr>
              <td>dimensions type</td>
              <td><g:select name="dimensionsType" from="${['inches', 'feet']}"/></td>
            </tr>
            <tr>
              <td>material</td>
              <td><g:textField name="material"/></td>
            </tr>
            
            
           <tr>
              <td>colors</td>
              <td><g:textField name="colors"/></td>
            </tr>  
            <tr>
              <td>sound field</td>
              <td><g:textField name="sound"/></td>
            </tr>  
          </tbody>
        </table>
        <g:hiddenField name="core" value="${params.id}"/>
        <g:submitButton name="submit" value="submit"/>
      </g:form>
    </div>
      