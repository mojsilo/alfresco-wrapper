<node>
	<properties>

		<#include 'include/defaultprops.ftl'>
		<#include 'include/content.ftl'>
		<#include 'include/share.ftl'>
		<#include 'include/destination.ftl'>
	
		<entry>
			<string>{http://www.alfresco.org/model/content/1.0}modifier</string>
			<string>${node.properties["cm:modifier"]}</string>
		</entry>

		<entry>
			 <string>{http://www.alfresco.org/model/content/1.0}description</string>
			 <string>
				<#if node.properties["cm:description"]?exists>
					<![CDATA[${node.properties["cm:description"]}]]>	
				</#if>
			</string>

		</entry>

		<entry>
			 <string>{http://www.alfresco.org/model/content/1.0}modified</string>
			 <string>${node.properties["cm:modified"]?datetime}</string>
		</entry>

		<entry>
			 <string>{http://www.organizeddocs.com/model/content/1.0}subscribedusers</string>
			 <string>
				<#if node.properties["sc:subscribedusers"]?exists>
					<![CDATA[${node.properties["sc:subscribedusers"]}]]>	
				</#if>
			</string>

		</entry>

		
	</properties>
	
		<#include 'include/preview.ftl'>

<aspects>
	<#if node.hasAspect("{http://www.organizeddocs.com/model/content/1.0}shareable")>
		<aspect>{http://www.organizeddocs.com/model/content/1.0}shareable</aspect>
	</#if>
	<#if node.hasAspect("{http://www.organizeddocs.com/model/content/1.0}subscribe")>
		<aspect>{http://www.organizeddocs.com/model/content/1.0}subscribe</aspect>
	</#if>

</aspects>
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

	

	<#include 'include/defaultinclude.ftl'>


</node>