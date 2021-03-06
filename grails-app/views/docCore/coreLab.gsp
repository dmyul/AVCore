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
    <g:javascript library="jqTabs"/>
    <div class="demo">
      <div style=" padding-left: 10px;">
        <h1>
          <g:link controller="collection" action="col" id="${core.collection.id}">${core.collection.identifier}: ${core.collection.title}</g:link>
        </h1>
      <h2>${core.title}</h2>
      <g:link controller="docCore" action="deleteCore" id="${core.id}">
        <img src="${createLinkTo(dir: 'images/icons', file: 'delete_32x32.png')}" width="20px" height="20px"/>
      </g:link>
      <img src="${createLinkTo(dir: 'images/icons', file: 'edit_32x32.png')}" width="20px" height="20px"/>
      <img src="${createLinkTo(dir: 'images/icons', file: 'wrench_32x32.png')}" width="20px" height="20px"/>
      </div>
      <br />
      <div id="tabs">
        <ul>
          <li><a href="#content">Intellectual Content</a></li>
          <li><a href="#property">Intellectual Property</a></li>
          <li><a href="#phys">Physical Instances</a></li>
          <li><a href="#digi">Digital Instances</a></li>
        </ul>
        
	<div id="content" style="color:black">
        <table>
        <tr>
          <td width="15%"><b>asset type</b></td>
          <td>${core.assetType}</td>
        </tr>
        <tr>
          <td><b>asset date</b></td>
          <td>${core.assetDate}</td>
        </tr>
        <tr>
          <td><b>identifier</b></td>
          <td>${core.identifier}</td>
        </tr>
        
        <tr>
          <td><b>description</b></td>
          <td>${core.description}</td>
        </tr>
        <tr>
          <td><b>Creator</b></td>
          <td>${core.creator} [${core.creatorRole}]</td>
        </tr>
        <tr>
          <td><b>Relationship Type</b></td>
          <td>${core.relationshipType}</td>
        </tr>
        <tr>
          <td><b>Relationship Identifier</b></td>
          <td>${core.relationshipIdentifier}</td>
        </tr>
        
        <tr>
          <td><b>subjects</b></td>
          <td>
            <table>
              <g:each in="${core.subject}" var="subject">
                <tr>
                  <td>${subject.subject}</td>
                </tr>
              </g:each>
              <tr>
                <td>
                  <img src="${createLinkTo(dir: 'images/icons', file: 'add_32x32.png')}" width="12px" height="12px"/>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
        </div>
        
        
	<div id="property" style="color:black">
          <table>
        <tr>
          <td><b>contributor</b></td>
          <td>${core.contributor} [${core.contributorRole}]</td>
        </tr>
        <tr>
          <td><b>publisher</b></td>
          <td>${core.publisher} [${core.publisherRole}]</td>
        </tr>
        <tr>
          <td><b>rights summary</b></td>
          <td>${core.rightsStatement}</td>
        </tr>
        
      </table>
        </div>
        
        
	<div id="phys" style="color:black">
          
          <table>
        <thead>
          <tr>
            
            <th>label</th>
            <th>generation</th>
            <th>physical format</th>
          </tr>
        </thead>
        <tbody>
        <g:each in="${core.physInst}" var="physInst">
          <tr>
            
            <td>
              <g:link controller="physInst" action="instance" id="${physInst.id}">${physInst.label}</g:link>
            </td>
            <td>${physInst.generation}</td>
            <td> ${physInst.physDesc}</td>
          </tr>
        </g:each>
          <tr>
            <td>
              <g:link controller="physInst" action="createSoundInstance" id="${core.id}">
                + sound Instance
              </g:link>
              <br />
              <g:link controller="physInst" action="createMovingImageInstance" id="${core.id}">
                + moving image Instance
              </g:link>
            </td>
            <td/>
          </tr>
      </tbody>
      </table>
        </div>
        <div id="digi" style="color:black">
          <table>
        <thead>
          <tr>
            <th/>
            <th>label</th>
            <th>generation</th>
            <th>physical format</th>
          </tr>
        </thead>
        <tbody>
        <g:each in="${core.digInst}" var="digInst">
          <tr>
            <g:if test="${digInst.mediaType} == Sound">
              <td>
                <img src="${createLinkTo(dir: 'images/icons', file: 'file_32x32.png')}" widht="20px" height="20px"/>
              </td>    
            </g:if>
            <td>
              <g:link controller="digInst" action="instance" id="${digInst.id}">${digInst.fileName}</g:link> 
            </td>
            <td>${digInst.generation}</td>
            <td>${digInst.standard}]</td>
          </tr>
      </g:each>
        <tr>
          <td>
              <img src="${createLinkTo(dir: 'images/icons', file: 'add_32x32.png')}" width="12px" height="12px"/>
          </td><td/><td/><td/>
          <td />
        </tr>
      </tbody>
      </table>
          
        </div>
        
      </div>

    </div>
  </body>
</html>
