<nodes>
<#if node?exists>
		<#include "../nodedetails.ftl">
<#elseif nodes?exists>
<#assign count=0/>

<#list nodes as node>
	<#assign count=count+1/>

	<#if start?exists && finish?exists>
		 <#if count &gt;= start?number && count <= finish?number>
			<#if node?exists>
				<#include "../nodedetails.ftl">
			</#if>
		 </#if>
	<#else>
		<#if node?exists>
			<#include "../nodedetails.ftl">
		</#if>
   	</#if>
</#list>




	
</#if>


</nodes>