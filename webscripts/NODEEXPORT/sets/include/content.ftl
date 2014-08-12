
<#assign t="{http://www.alfresco.org/model/content/1.0}content">
<#if 	node.properties[t]?exists >

<entry>
	<string>${t}</string>
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

</entry>

</#if>