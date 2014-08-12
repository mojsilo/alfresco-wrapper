<type>${node.type}</type>
	<#if node.parent?exists &&  node.parent.hasPermission('Read')>
		<parent>${node.parent.id}</parent>
		<parentname><![CDATA[${node.parent.name}]]></parentname>
	<#else>
		<parent></parent>
		<parentname></parentname>
	</#if>
	<folder>${node.isContainer?string("true", "false")}</folder>
	
	<#include 'parentnoderef.ftl'>