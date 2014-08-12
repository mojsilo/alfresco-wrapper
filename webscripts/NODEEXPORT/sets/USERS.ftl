<node>
<properties>

	<#if include?exists>
		<#include include>
	</#if>
	<#include "include/noderef.ftl">
	<#include 'include/nodeuuid.ftl'>
	<entry>
		 <string>{http://www.alfresco.org/model/content/1.0}userName</string>
		 <string>${node.properties["cm:userName"]}</string>
	</entry>
	<entry>
		<string>{http://www.alfresco.org/model/content/1.0}email</string>
		<string><![CDATA[${node.properties["cm:email"]}]]></string>
	</entry>
	<entry>
		 <string>{http://www.alfresco.org/model/content/1.0}lastName</string>
		 <string>${node.properties["cm:lastName"]}</string>
	</entry>
	<entry>
		 <string>{http://www.alfresco.org/model/content/1.0}firstName</string>
		 <string>${node.properties["cm:firstName"]}</string>
	</entry>
</properties>

<permissions>
	<entry>
		<string>Write</string>
		 <string>${node.hasPermission('Write')?string('true', 'false')}</string>
	</entry>
	<entry>
		<string>Delete</string>
		 <string>${node.hasPermission('Delete')?string('true', 'false')}</string>
	</entry>
</permissions>

<#include 'include/assocs.ftl'>
<type>${node.type}</type>
</node>