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
          <li><a href="#content">Intellectual Information</a></li>
          <li><a href="#phys">Physical Instances</a></li>
          <li><a href="#digi">Digital Instances</a></li>
        </ul>
        
	<div id="content" style="color:black">
          <h2>Content</h2>
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
          <td><b>creator</b></td>
          <td><b>${core.creator}</b></td>
        </tr>
        <tr>
          <td><b>description</b></td>
          <td>${core.description}</td>
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
        
        <tr>
          <td><b>Relationships</b></td>
          <td>
            <table>
              <tr>
                <td>
                  <img src="${createLinkTo(dir: 'images/icons', file: 'add_32x32.png')}" width="12px" height="12px"/>
                </td>
              </tr>
            </table>
          </td>
        </tr>
          </td>
        </tr>
      </table>
          
      <br />
      <br />
      <h2>Property</h2>
        
	
          <table>
        <tr>
          <td><b>Contributer</b></td>
          <td></td>
        </tr>
        <tr><td>+ contributer</td></tr>
        <tr>
          <td><b>Publisher</b></td>
          <td></td>
        </tr>
        <tr><td>+ contributer</td></tr>
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
            <th>media type</th>
            <th>generation</th>
            <th>physical format</th>
            <th>actions</th>
          </tr>
        </thead>
        <tbody>
        <g:each in="${core.physInst}" var="physInst">
          <tr>
            <g:if test="${physInst.mediaType.equals('Sound')}">
            <td>
              <g:link controller="physInst" action="soundInstance" id="${physInst.id}">${physInst.label}</g:link>
            </td>
            </g:if>
            <g:if test="${physInst.mediaType.equals('Moving image')}">
            <td>
              <g:link controller="physInst" action="movingImageInstance" id="${physInst.id}">${physInst.label}</g:link>
            </td>
            </g:if>
            <td>${physInst.mediaType}</td>
            <td>${physInst.generation}</td>
            <td>${physInst.physDesc}</td>
            <td>view edit delete</td>
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
            <th>media type</th>
            <th>generation</th>
            <th>physical format</th>
            <th>actions</th>
          </tr>
        </thead>
        <tbody>
        <g:each in="${core.digInst}" var="digInst">
          <tr>
            <g:if test="${digInst.mediaType.equals('sound')}">
              <td>
                <img src="${createLinkTo(dir: 'images/icons', file: 'file_32x32.png')}" widht="20px" height="20px"/>
              </td>    
            </g:if>
            <g:else>
              <td>
                MOV
              </td> 
            </g:else>
            <td>
              <g:link controller="digInst" action="instance" id="${digInst.id}">${digInst.fileName}</g:link> 
            </td>
            <td>${digInst.mediaType}</td>
            <td>${digInst.generation}</td>
            <td>${digInst.standard}]</td>
            <td>view edit delete</td>
          </tr>
      </g:each>
        <tr>
          <td>
            + sound file<br />+ moving image file
          </td>
          <td/><td/><td/>
          <td />
        </tr>

      </tbody>
      </table>
        </div>
      </div>
    </div>
  </body>
</html>
