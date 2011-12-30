<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <title>AV/Core: Update Sound Physical Instance</title>
</head>

<body>
  
  
    <div id="front">
      <h1>
        <g:link controller="collection" action="col" id="${instance.docCore.collection.id}">${instance.docCore.collection.identifier}: ${instance.docCore.collection.title}</g:link>
      </h1>
      <h2>${instance.docCore.title}</h2>
    </div>
  
  
    <div id="form">
      <h3>Create a new physical Instance</h3>
      <g:form action="updatePhysInst" method="post">
        <table>
          <tbody>
            
            <tr>
              <td width="15%">label</td>
              <td><g:textField name="label" value="${instance.label}"/></td>
            </tr>
            
            <tr>
              <td>media type</td>
              <td><g:select name="mediaType" value="${instance.mediaType} from="${['Sound', 'Moving image']}"/></td>
            </tr>
            
            <tr>
              <td>generation</td>
              <td><g:select name="generation" from="${['Original recording', 'Copy: access', 'Master: preservation']}"/></td>
            </tr> 
            
            <tr>
              <td>physical description</td>
              <td><g:select name="physDesc" value="${instance.physDesc}" from="${pIns.concept}"/></td>
            </tr> 
            
            <tr>
              <td>barcode</td>
              <td><g:textField name="barcode" value="${instance.barcode}"/></td>
            </tr>
            
            <tr>
              <td>location</td>
              <td><g:textField name="location" value="${instance.location}"/></td>
            </tr>
            
            <tr>
              <td>date</td>
              <td><g:datePicker name="date" precision="day" value="${instance.date}"/></td>
            </tr>
            
            <tr>
              <td>date type</td>
              <td><g:select name="dateType" from="${dType.concept}" value="${instance.dateType}"/></td>
            </tr>
            
            <tr>
              <td>dimensions</td>
              <td><g:textField name="dimensions" value="${instance.dimensions}"/></td>
            </tr>
            
            <tr>
              <td>dimensions type</td>
              <td><g:select name="dimensionsType" from="${['inches', 'feet']}" value="${instance.dimensionsType}"/></td>
            </tr>
            
            <tr>
              <td>tracks</td>
              <td><g:textField name="tracks" value="${instance.tracks}"/></td>
            </tr>
            
            <tr>
              <td>channel config</td>
              <td><g:textField name="channelConfiguration" value="${instance.channelConfiguration}"/></td>
            </tr> 
            
            <tr>
              <td>material</td>
              <td><g:textField name="material" value="${instance.material}"/></td>
            </tr>
            
          </tbody>
        </table> 
        <g:hiddenField name="instanceId" value="${instance.id}"/>
        <g:submitButton name="submit" value="update"/>
      </g:form>
    </div>