<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css/redmond/',file:'jquery-ui-1.8.17.custom.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css/blueprint/',file:'screen.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
        <g:javascript library ="jquery-1.6.2.min"/>
        <g:javascript library="jquery-ui-1.8.16.custom.min"/>

    </head>
    <body>
        
        <div style="width:75%;margin-left: 12.5%">
          <div style="color: #E6E6E6; font-size: x-large; font-family:Gill, Helvetica, sans-serif">AV/Core</div>
          <g:link controller="PBCoreVocab" action="admin">admin</g:link>
          <g:layoutBody />
        
          <br />
          <hr />
          <p>very much in dev</p>
        </div>
    </body>
</html>