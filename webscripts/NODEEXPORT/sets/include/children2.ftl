<!-- used for previews-->
<children>
	<#list node.children as child>
		<node>
			<properties>
				<entry>
					<string>{http://www.alfresco.org/model/content/1.0}name</string>
					<string><![CDATA[${child.properties["cm:name"]}]]></string>
				</entry>
			</properties>

			<asocs>
			</asocs>
			<type>${child.type}</type>
		</node>
	</#list>
</children>