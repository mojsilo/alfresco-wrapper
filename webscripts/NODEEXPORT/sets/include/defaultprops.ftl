		<#include "nodeuuid.ftl">
		<entry>
			<string>{http://www.alfresco.org/model/content/1.0}displaypath</string>
			<string><![CDATA[${node.qnamePath}]]></string>
		</entry>

		

		<entry>
			 <string>{http://www.alfresco.org/model/content/1.0}name</string>
			 <string><![CDATA[${node.properties["cm:name"]}]]></string>
		</entry>

		<entry>
			<string>{http://www.alfresco.org/model/system/1.0}store-protocol</string>
			<string>${node.properties["sys:store-protocol"]}</string>
		</entry>

		<entry>
			<string>{http://www.alfresco.org/model/system/1.0}store-identifier</string>
			<string>${node.properties["sys:store-identifier"]}</string>
		</entry>
	
