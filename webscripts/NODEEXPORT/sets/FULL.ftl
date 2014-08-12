<#if  node.hasPermission('Read')>

<#assign props = node.properties?keys>
<node>
	<properties>
	<#if include?exists>
		<#include include>
	</#if>
	<#if include2?exists>
		<#include include2>
	</#if>
	
	
	<#include 'include/topic.ftl'>
	<#if node.type=='{http://www.alfresco.org/model/forum/1.0}post'>
		<entry>
			<string>{http://www.alfresco.org/model/content/1.0}contentValue</string>
			<string><![CDATA[${node.content}]]></string>
		</entry>
	</#if>
	<entry>
		<string>{http://www.alfresco.org/model/content/1.0}displaypath</string>
		<string><![CDATA[${node.qnamePath}]]></string>
	</entry>


<#list props as t>
    <#if node.properties[t]?exists>
	<#assign tshort = t>
	<entry>
	<string>${tshort}</string>
	
	<#if node.properties[t]?is_date>
		<string>${node.properties[t]?datetime}</string>
		
	<#elseif node.properties[t]?is_boolean>
		<string>${node.properties[t]?string("true", "false")}</string>
		
	<#elseif node.properties[t]?is_sequence>	
		<list>
			<#list node.properties[t] as seq>
				<#if seq?exists>
					<listelement>${seq}</listelement>
				<#else>

				</#if>			
			</#list> 
		</list>		
		
	<#elseif node.properties[t]?is_hash && node.properties[t].nodeRef?exists   >
	  	<nodeRef>
			<id>${node.properties[t].id}</id>
			<propertyName>${t}</propertyName>
			<name><![CDATA[${node.properties[t].name}]]></name>
			<storeProtocol>${node.properties[t].properties["sys:store-protocol"]}</storeProtocol>
			<storeIdentifier>${node.properties[t].properties["sys:store-identifier"]}</storeIdentifier>
			<type>${node.properties[t].type}</type>
		</nodeRef>
		
	<#elseif node.properties[t]?is_hash  && node.properties[t].url?exists  >
		<content>
			<url> <![CDATA[ ${node.properties[t].url}]]></url>
			<mimetype>${node.properties[t].mimetype}</mimetype>
			<size>${node.properties[t].size}</size>
			<#if node.properties[t].encoding?exists>
				<encoding>${node.properties[t].encoding}</encoding>
			<#else>
				<encoding></encoding>
			</#if>
		 </content>
		 
	<#else>	
	    <string><![CDATA[${node.properties[t]}]]></string>
		   
	</#if>
	</entry>
    </#if>
</#list>
 
 </properties>
 
<#include 'include/defaultinclude.ftl'>
<#include 'include/assocs.ftl'>
<#include 'include/preview.ftl'>

<aspects>
<#assign aspects = node.aspects>
	<#list aspects as seq>
		<aspect>${seq}</aspect>
	</#list>	
</aspects>


<permissions>
	<entry>
		<string>Read</string>
		 <string>${node.hasPermission('Read')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>Write</string>
		 <string>${node.hasPermission('Write')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>Delete</string>
		 <string>${node.hasPermission('Delete')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>AddChildren</string>
		 <string>${node.hasPermission('AddChildren')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>Administrator</string>
		 <string>${node.hasPermission('Administrator')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>Coordinator</string>
		 <string>${node.hasPermission('Coordinator')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>Contributor</string>
		 <string>${node.hasPermission('Contributor')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>Editor</string>
		 <string>${node.hasPermission('Editor')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>ReadContent</string>
		 <string>${node.hasPermission('ReadContent')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>WriteContent</string>
		 <string>${node.hasPermission('WriteContent')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>ExecuteContent</string>
		 <string>${node.hasPermission('ExecuteContent')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>TakeOwnership</string>
		 <string>${node.hasPermission('TakeOwnership')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>CheckIn</string>
		 <string>${node.hasPermission('CheckIn')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>CheckOut</string>
		 <string>${node.hasPermission('CheckOut')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>CancelCheckOut</string>
		 <string>${node.hasPermission('CancelCheckOut')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>Lock</string>
		 <string>${node.hasPermission('Lock')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>Unlock</string>
		 <string>${node.hasPermission('Unlock')?string('true', 'false')}</string>
	</entry>

	<entry>
		<string>FullControl</string>
		 <string>${node.hasPermission('FullControl')?string('true', 'false')}</string>
	</entry>


</permissions>






 
 </node>

</#if>
				
