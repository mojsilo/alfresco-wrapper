<node>
<properties>

	<#include 'include/defaultprops.ftl'>

	<entry>
		 <string>{http://www.alfresco.org/model/content/1.0}creator</string>
		 <string><![CDATA[${node.properties["cm:creator"]}]]></string>
	</entry>
	<entry>
		 <string>{http://www.alfresco.org/model/content/1.0}modified</string>
		 <string>${node.properties["cm:modified"]?datetime}</string>
	</entry>
	<entry>
		<string>{http://www.alfresco.org/model/forum/1.0}commentscount</string>
		<string>${node.children?size}</string>
	</entry>

	<#include 'include/content.ftl'>
<#--	
<#if node.properties["cm:content"]?exists>
	<entry>
	
		 <string>{http://www.alfresco.org/model/content/1.0}content</string>
		 <content>
		   <url> <![CDATA[ ${node.properties["cm:content"].url}]]></url>
		   <mimetype>${node.properties["cm:content"].mimetype}</mimetype>
		   <size>${node.properties["cm:content"].size}</size>
		<#if node.properties["cm:content"].encoding?exists>
		   <encoding>${node.properties["cm:content"].encoding}</encoding>
              <#else>
			<encoding></encoding>
		</#if>
		 </content>
	</entry>
</#if>-->

<#if node.type=='{http://www.alfresco.org/model/forum/1.0}post'>
<entry>
		<string>{http://www.alfresco.org/model/content/1.0}contentValue</string>
		<string><![CDATA[${node.content}]]></string>
	</entry>
</#if>

</properties>
<#if node.hasAspect("sc:referencedbyaspect")>
	<#include 'include/assocs.ftl'>
</#if>

<aspects>
</aspects>

<permissions>
</permissions>

<#include 'include/defaultinclude.ftl'>


</node>