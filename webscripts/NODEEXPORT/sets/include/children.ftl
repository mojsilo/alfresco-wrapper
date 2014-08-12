<children>
	<#list node.children as child>
			
	<#assign props = child.properties?keys>
	<node>
		<properties>
		<#if include?exists>
			<#include include>
			</#if>

		<#include 'topic.ftl'>

		<entry>
			<string>{http://www.alfresco.org/model/content/1.0}displaypath</string>
			<string><![CDATA[${child.qnamePath}]]></string>
		</entry>


<#list props as t>
    <#if child.properties[t]?exists>
	<#assign tshort = t>
	<entry>
	<string>${tshort}</string>
	
	<#if child.properties[t]?is_date>
		<string>${child.properties[t]?datetime}</string>
		
	<#elseif child.properties[t]?is_boolean>
		<string>${child.properties[t]?string("true", "false")}</string>
		
	 <#elseif child.properties[t]?is_sequence>	

	 <list>
	<#list child.properties[t] as seq>
		<listelement><![CDATA[${seq}]]></listelement>
	</#list>
	 </list>		
		
	   <#elseif child.properties[t]?is_hash && child.properties[t].nodeRef?exists   >
	  
			<nodeRef>
				<id>${child.properties[t].id}</id>
				<propertyName>${t}</propertyName>
				<name><![CDATA[${child.properties[t].name}]]></name>
				<storeProtocol>${child.properties[t].properties["sys:store-protocol"]}</storeProtocol>
				<storeIdentifier>${child.properties[t].properties["sys:store-identifier"]}</storeIdentifier>
				<type>${child.properties[t].type}</type>
			</nodeRef>
		
		<#elseif child.properties[t]?is_hash  && child.properties[t].url?exists  >
		 <content>
		   <url> <![CDATA[ ${child.properties[t].url}]]></url>
		   <mimetype>${child.properties[t].mimetype}</mimetype>
		   <size>${child.properties[t].size}</size>
		<#if child.properties[t].encoding?exists>
		   <encoding>${child.properties[t].encoding}</encoding>
              <#else>
			<encoding></encoding>
		</#if>
		 </content>
		 
		<#else>	
	    <string><![CDATA[${child.properties[t]}]]></string>
		   
	   </#if>
	   </entry>
    </#if>
	
 </#list>
 
 </properties>

<asocs>


<#assign assocs = child.assocs?keys>
	<#list assocs as asoc>
 
		
		<entry>
		<string>${asoc}</string>
		<nodeRefs>
		<#list child.assocs[asoc] as seq>
		
			<nodeRef>
				<id>${seq.id}</id>
				<propertyName>${asoc}</propertyName>
				<name><![CDATA[${seq.name}]]></name>
				<storeProtocol>${seq.properties["sys:store-protocol"]}</storeProtocol>
				<storeIdentifier>${seq.properties["sys:store-identifier"]}</storeIdentifier>
				<type>${seq.type}</type>
			</nodeRef>

		
		</#list>
			</nodeRefs>
		</entry>
		
		
	</#list>


</asocs>
<type>${child.type}</type>

</node>

</#list>
</children>