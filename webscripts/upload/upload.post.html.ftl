<actionreturn>
<message></message>
<messageCode></messageCode>
<nodes>
<#list nodes as node>
<#if node.hasPermission('Read')>

	<#include "../nodedetails.ftl">
	</#if>

</#list>
</nodes>

</actionreturn>