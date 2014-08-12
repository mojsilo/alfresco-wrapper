<#if node.type=='{http://www.alfresco.org/model/forum/1.0}topic'>
		<entry>
			<string>{http://www.alfresco.org/model/forum/1.0}commentscount</string>
			<string>${node.children?size}</string>
		</entry>
		<#if node.children?size != 0>
			<entry>
				<string>{http://www.alfresco.org/model/forum/1.0}firstreply</string>
				<string><![CDATA[${node.children?first.properties['cm:content'].url}]]></string>
			</entry>
			<entry>
				<string>{http://www.alfresco.org/model/forum/1.0}lastreply</string>
				<string><![CDATA[${node.children?last.properties['cm:content'].url}]]></string>
			</entry>
			<entry>
				<string>{http://www.alfresco.org/model/forum/1.0}lastreplydate</string>
				<string><![CDATA[${node.children?last.properties['cm:created']?datetime}]]></string>
			</entry>
			<entry>
				<string>{http://www.alfresco.org/model/content/1.0}contentValue</string>
				<string><![CDATA[${node.children?last.content}]]></string>
			</entry>
		</#if>	
	</#if>