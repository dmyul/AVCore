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
    <h3>
      <g:link action="col" controller="collection" id="${ins.docCore.collection.id}">
        ${ins.docCore.collection.title}
      </g:link>
    </h3>
    <h2>
      <g:link action="core" controller="docCore" id="${ins.docCore.id}">
        ${ins.docCore.title}
      </g:link>
    </h2>
      <g:link action="deletePhysInst" controller="physInst" id="${ins.id}">
      <img src="${createLinkTo(dir: 'images/icons', file: 'delete_32x32.png')}" width="20px" height="20px"/>
      </g:link>
      <g:link action="editSoundPhysInst" controller="physInst" id="${ins.id}">
      <img src="${createLinkTo(dir: 'images/icons', file: 'edit_32x32.png')}" width="20px" height="20px"/>
      </g:link>
  
  <h2>Fields</h2>
    <table>
      <tr>
        <td width="15%">label</td>
        <td>${ins.label}</td>
      </tr>
      <tr>
        <td>date</td>
        <td>${ins.date}</td>
      </tr>
      <tr>
        <td>dateType</td>
        <td>${ins.dateType}</td>
      </tr>
      <tr>
        <td>physdesc</td>
        <td>${ins.physDesc}</td>
      </tr><tr>
        <td>dimensions</td>
        <td>${ins.dimensions}</td>
      </tr>
      <tr>
        <td>unit</td>
        <td>${ins.dimensionsType}</td>
      </tr>
      <tr>
        <td>location</td>
        <td>${ins.location}</td>
      </tr>
      <tr>
        <td>media type</td>
        <td>${ins.mediaType}</td>
      </tr>
      <tr>
        <td>generation</td>
        <td>${ins.generation}</td>
      </tr>
      <tr>
        <td>tracks</td>
        <td>${ins.tracks}</td>
      </tr>
      <tr>
        <td>channel configuration</td>
        <td>${ins.channelConfiguration}</td>
      </tr>
      <tr>
        <td>Base Material</td>
        <td>${ins.material}</td>
      </tr>
  </table>
  <br />
  <h2>Assessment</h2>
  <table>
    <tr>
      <td><h2>To Be Determined</h2></td>
    </tr>
  </table>
