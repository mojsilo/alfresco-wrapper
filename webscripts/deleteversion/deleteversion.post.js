<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">

if(args.current == null)
{
	model.current=companyhome;
}else{

	var nodeRefcurrent="workspace://SpacesStore/"+args.current;
	var whatNode = search.findNode(nodeRefcurrent);
	model.current=whatNode;

	var result=new Array();

	if(whatNode.isVersioned){

		var deleteVersion = actions.create("deleteVersion");
		deleteVersion.parameters.version = args.version;
		deleteVersion.execute(whatNode);
		result = cmisserver.getAllVersions(whatNode);
	}
	model.nodes=result;
}

var currentPage=args["currentPage"];
var lenT=args["lengthh"];

if(currentPage){
	if(lenT){
		var finish = currentPage*lenT;
		var start =  (currentPage-1)*lenT;
		if(start>0)
			{
				start=start+1;
			}

		model.start=start;
		model.finish=finish;
	}	
}
	
	

	
	
	


