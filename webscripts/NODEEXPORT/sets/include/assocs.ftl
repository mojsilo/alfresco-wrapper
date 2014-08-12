<asocs>


<#assign assocs = node.assocs?keys>
	<#list assocs as asoc>
 
		
		<entry>
		<string>${asoc}</string>
		<nodeRefs>
		<#list node.assocs[asoc] as seq>
		
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