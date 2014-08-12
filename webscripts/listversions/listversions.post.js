<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">

if(args.current == null)
{
model.current=companyhome;
}else{

var nodeRefcurrent="workspace://SpacesStore/"+args.current;
var whatNode = search.findNode(nodeRefcurrent);
model.current=whatNode;

var result=new Array();
     logger.error("versioned ");
if(whatNode.isVersioned){


result = cmisserver.getAllVersions(whatNode);

	var versionHistory = whatNode.versionHistory ;
     logger.error("versioned "+versionHistory.length);
	for(var vh in versionHistory)
	{
		logger.error("versioned "+vh.nodeRef);
		//result.push(vh.node);
	}
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
	
	

	
	
	


