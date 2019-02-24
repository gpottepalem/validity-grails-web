<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="customer" />
        <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-customer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                %{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
            </ul>
        </div>

        <div>
        <h1><b>Potential Duplicates</b></h1>
            <g:each in="${potentialDuplicates}">
                ${it}<br/>
            </g:each>
        </div>

        <div>
            <h1><b>None Duplicates</b></h1>
            <g:each in="${nonDuplicates}">
                ${it}<br/>
            </g:each>
        </div>
    </body>
</html>