<entry>
	<string>{http://www.organizeddocs.com/model/content/1.0}parentpermissions</string>
	 <detailedpermissions>
	<#list  node.parent.permissions as perm>
	<permission>
		<allowed>${perm?split(";")[0]}</allowed>
		<who>${perm?split(";")[1]}</who>
		<role>${perm?split(";")[2]}</role>
	</permission>
	</#list>
	</detailedpermissions>
</entry>
