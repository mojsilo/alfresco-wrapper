<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">


var storeIdentifier=args["storeIdentifier"];
var storeProtocol=args["storeProtocol"];

if(args.current == null)
{
	model.node=companyhome;
	
}else{

	var nodeRefcurrent="workspace://SpacesStore/"+args.current;

	if(storeIdentifier !=null && storeProtocol != null)
		{
			nodeRefcurrent=storeProtocol+"://"+storeIdentifier+"/"+args.current;
		}

	var whatNode = search.findNode(nodeRefcurrent);

	model.node=whatNode;

	model.include="include/projectusertype.ftl";
	model.projectusertype = projectUserType(whatNode);
	
	if(whatNode.type == '{http://www.alfresco.org/model/user/1.0}authorityContainer'){
		model.project=getProjectFromGroup(whatNode);
		model.include2="include/project.ftl";
	}



}







	
	

	
	
	


