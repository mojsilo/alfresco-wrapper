<#if node.hasAspect("{http://www.organizeddocs.com/model/content/1.0}shareable")>
<!--share begin-->
		<entry>
			 <string>{http://www.organizeddocs.com/model/content/1.0}sharedat</string>
			 <string>
				<#if node.properties["sc:sharedat"]?exists>
					<![CDATA[${node.properties["sc:sharedat"]?datetime}]]>	
				</#if>
			</string>

		</entry>

		<entry>
			 <string>{http://www.organizeddocs.com/model/content/1.0}isShareable</string>
			 <string><#if node.properties["sc:isShareable"]?exists><![CDATA[${node.properties["sc:isShareable"]?string}]]></#if></string>

		</entry>

		<entry>
			 <string>{http://www.organizeddocs.com/model/content/1.0}sharedby</string>
			 <string>
				<#if node.properties["sc:sharedby"]?exists>
					<![CDATA[${node.properties["sc:sharedby"]}]]>	
				</#if>
			</string>

		</entry>

		<entry>
			 <string>{http://www.organizeddocs.com/model/content/1.0}sharecode</string>
			 <string>
				<#if node.properties["sc:sharecode"]?exists>
					<![CDATA[${node.properties["sc:sharecode"]}]]>	
				</#if>
			</string>

		</entry>
<!--share end-->
</#if>