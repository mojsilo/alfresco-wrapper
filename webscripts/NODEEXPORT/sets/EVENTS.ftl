<node>
	<properties>

	<entry>
		<string>{http://www.alfresco.org/model/content/1.0}displaypath</string>
		<string><![CDATA[${node.qnamePath}]]></string>
	</entry>

	<entry>
		 <string>{http://www.alfresco.org/model/system/1.0}node-uuid</string>
		 <string>${node.properties["sys:node-uuid"]}</string>
	</entry>

	<entry>
		 <string>{http://www.organizeddocs.com/model/content/1.0}nodereftype</string>
		 <string>${node.properties["sc:nodereftype"]}</string>
	</entry>

	<entry>
		 <string>{http://www.organizeddocs.com/model/content/1.0}nodereftype</string>
		 <string>${node.properties["sc:nodereftype"]}</string>
	</entry>

	<entry>
		 <string>{http://www.organizeddocs.com/model/content/1.0}creator</string>
		 <string>${node.properties["sc:creator"]}</string>
	</entry>

	<entry>
		 <string>{http://www.organizeddocs.com/model/content/1.0}created</string>
		 <string>${node.properties["sc:created"]?datetime}</string>
	</entry>

<#if node.properties["sc:nodereftarget"]?exists && node.properties["sc:nodereftarget"].hasPermission("Read")>
	<entry>
		 <string>{http://www.organizeddocs.com/model/content/1.0}nodereftarget</string>
			<nodeRef>
				<id>${node.properties["sc:nodereftarget"].id}</id>
				<propertyName>{http://www.organizeddocs.com/model/content/1.0}nodereftarget</propertyName>
				<name><![CDATA[${node.properties["sc:nodereftarget"].name}]]></name>
				<storeProtocol>${node.properties["sc:nodereftarget"].properties["sys:store-protocol"]}</storeProtocol>
				<storeIdentifier>${node.properties["sc:nodereftarget"].properties["sys:store-identifier"]}</storeIdentifier>
				<type>${node.properties["sc:nodereftarget"].type}</type>
			</nodeRef>

	</entry>
</#if>
<#if node.properties["sc:noderef"]?exists && node.properties["sc:noderef"].hasPermission("Read")>
	<entry>
		 <string>{http://www.organizeddocs.com/model/content/1.0}noderef</string>
			<nodeRef>
				<id>${node.properties["sc:noderef"].id}</id>
				<propertyName>{http://www.organizeddocs.com/model/content/1.0}noderef</propertyName>
				<name><![CDATA[${node.properties["sc:noderef"].name}]]></name>
				<storeProtocol>${node.properties["sc:noderef"].properties["sys:store-protocol"]}</storeProtocol>
				<storeIdentifier>${node.properties["sc:noderef"].properties["sys:store-identifier"]}</storeIdentifier>
				<type>${node.properties["sc:noderef"].type}</type>
			</nodeRef>

	</entry>		
</#if>

	</properties>

<aspects>
</aspects>
<permissions>
	
</permissions>

	<type>${node.type}</type>



	
</node>