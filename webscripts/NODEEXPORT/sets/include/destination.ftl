<#assign t="{http://www.alfresco.org/model/content/1.0}destination">

<#if 	node.properties[t]?exists >

<entry>
	<string>${t}</string>
	        <nodeRef>
				<id>${node.properties[t].properties["sys:node-uuid"]}</id>
				<propertyName>${t}</propertyName>
				<name> <![CDATA[${node.properties[t].name}]]></name>
				<storeProtocol>${node.properties[t].properties["sys:store-protocol"]}</storeProtocol>
				<storeIdentifier>${node.properties[t].properties["sys:store-identifier"]}</storeIdentifier>
				<type>{http://www.alfresco.org/model/content/1.0}content</type>
			</nodeRef>

</entry>
</#if>