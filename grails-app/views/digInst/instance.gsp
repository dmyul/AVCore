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
    <img src="${createLinkTo(dir: 'images/icons', file: 'delete_32x32.png')}" width="20px" height="20px"/>
    <img src="${createLinkTo(dir: 'images/icons', file: 'edit_32x32.png')}" width="20px" height="20px"/>
    <table>
      <tr>
        <td width="15%"><b>fileName<b></td>
        <td><b>${ins.fileName}<b></td>
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
        <td>standard</td>
        <td>${ins.standard}</td>
      </tr><tr>
        <td>file size</td>
        <td>${ins.fileSize} ${ins.fileSizeType}</td>
      </tr>
      <tr>
        <td>duration</td>
        <td>${ins.duration} s</td>
      </tr>
      <tr>
        <td>data rate</td>
        <td>${ins.dataRate} ${ins.dataRateType}</td>
      </tr>
      
      <tr>
        <td>media type</td>
        <td>${ins.mediaType}</td>
      </tr>
      
      <tr>
        <td>tracks</td>
        <td>${ins.tracks}</td>
      </tr>
      
      <tr>
        <td>annotation</td>
        <td>${ins.annotation}</td>
      </tr>
      
      <tr>
        <td>generation</td>
        <td>${ins.generation}</td>
      </tr>
      
      <tr>
        <td>location</td>
        <td>${ins.location}</td>
      </tr>
      <tr>
        <td>checksum</td>
        <td>${ins.checksum}</td>
      </tr>
      <tr>
        <td>algorithm</td>
        <td>${ins.checksumType}</td>
      </tr>
      <tr>
        <td>channel config</td>
        <td>${ins.channelConfiguration}</td>
      </tr>
      
    </table>
    <br /><h2>Essences</h2>
  <g:each in="${ins.essence}" var="essence">
    <table>
      <tr>
        <td width="15%"><b>${essence.trackType}</b></td>
        <td></td>
      </tr>
      <tr>
        <td>standard</td>
        <td>${essence.trackStandard}</td>
      </tr>
      <tr>
        <td>encoding</td>
        <td>${essence.trackEncoding} [${essence.trackEncodingProfile}]</td>
      </tr>
      <tr>
        <td width="15%">bit depth</td>
        <td>${essence.trackBitDepth}</td>
      </tr>
      
      <g:if test="${essence.trackSamplingRate != 0}">
      <tr>
        <td>sampling rate</td>
        <td>${essence.trackSamplingRate} ${essence.trackSamplingRateUnit}</td>
      </tr>
      </g:if>
      
      <g:if test="${essence.trackFrameRate != 0}">
      <tr>
        <td>frame rate</td>
        <td>${essence.trackFrameRate} fps</td>
      </tr>
      </g:if>
      
      <tr>
        <td>frame size</td>
        <td>${essence.trackFrameSize}</td>
      </tr>
      
      <tr>
        <td>data rate</td>
        <td>${essence.trackDataRate} ${essence.trackDataRateUnit} (${essence.trackDataRateType})</td>
      </tr>
      
      <g:if test="${!(essence.trackTimeStart == null)}"
      <tr>
        <td>time offset</td>
        <td>${essence.trackTimeStart}</td>
      </tr>
      </g:if>
      <tr>
        <td>duration</td>
        <td>${essence.trackDuration} s</td>
      </tr>
      
      
      <tr>
        <td>aspect ratio</td>
        <td>${essence.trackAspectRatio}</td>
      </tr>
      
      <tr>
        <td>track annotation</td>
        <td>${essence.trackAnnotation}</td>
      </tr>

    </table>
  </g:each>
   </body>
</html>
