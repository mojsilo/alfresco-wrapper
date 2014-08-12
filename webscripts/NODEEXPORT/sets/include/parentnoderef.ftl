			
			<#if node.parent?exists &&  node.parent.hasPermission('Read')>
			<parentNodeRef>
				<id>${node.parent.properties["sys:node-uuid"]}</id>
				<propertyName>empty</propertyName>
				<name><![CDATA[${node.parent.name} ]]></name>
				<storeProtocol>${node.parent.properties["sys:store-protocol"]}</storeProtocol>
				<storeIdentifier>${node.parent.properties["sys:store-identifier"]}</storeIdentifier>
				<type>${node.parent.type}</type>
			</parentNodeRef>
			</#if>