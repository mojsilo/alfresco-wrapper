<node>
	<properties>
		<#include 'include/defaultprops.ftl'>
		<entry>
			 <string>{http://www.alfresco.org/model/content/1.0}creator</string>
			 <string><![CDATA[${node.properties["cm:creator"]}]]></string>
		</entry>
		<entry>
			 <string>{http://www.alfresco.org/model/content/1.0}created</string>
			 <string>${node.properties["cm:created"]?datetime}</string>
		</entry>
		<#include 'include/topic.ftl'>
	</properties>

	<#include 'include/defaultinclude.ftl'>
	
	<aspects>
	</aspects>
	<permissions>
		<entry>
			<string>AddChildren</string>
			<string>${node.hasPermission('AddChildren')?string('true', 'false')}</string>
		</entry>
	</permissions>
</node>