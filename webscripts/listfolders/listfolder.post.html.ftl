<nodes>
<#assign count=0/>
<#list current.children?sort_by(['properties','cm:name']) as node>
<#if node.isContainer >
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

</#if>

</#list>



<#list current.children?sort_by(['properties','cm:name']) as node>
<#if !node.isContainer >
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


</#if>


</#list>
</nodes>