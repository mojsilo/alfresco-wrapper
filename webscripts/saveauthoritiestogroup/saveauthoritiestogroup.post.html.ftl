<actionreturn>
<message></message>
<messageCode>messageCode 1</messageCode>
<nodes>
<#list nodes as node>
<#if node.hasPermission('Read')>

	<#include "../nodedetails.ftl">

	</#if>

</#list>
</nodes>

</actionreturn>