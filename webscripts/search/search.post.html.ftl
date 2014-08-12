<actionreturn>
<message></message>
<messageCode></messageCode>
<#if args.store?exists>
<store> ${args.store}</store>
<#else>
<store></store>
</#if>

<#if args.sortColumn?exists>
<sortColumn> ${args.sortColumn}</sortColumn>
<#else>
<sortColumn></sortColumn>
</#if>


<#if args.asc?exists>
<asc> ${args.asc}</asc>
<#else>
<asc></asc>
</#if>
<query> ${query}</query>


<nodes>
<#assign count=0/>


<#if typeorder=='false'>
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

<#if typeorder=='true'>
<#list nodes as node>
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

<#list nodes as node>
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
</#if>
</nodes>

</actionreturn>