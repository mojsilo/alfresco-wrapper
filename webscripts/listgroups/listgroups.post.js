<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

var group=args["group"];
var root=args["root"];
var groupCollection=null;
var makesort=false;
if(group != null)
{
	nodeRefcurrent="workspace://SpacesStore/"+args.group;
	var whatNode = search.findNode(nodeRefcurrent);
	
	model.nodes = whatNode.children;
	makesort=true;
}else if(root != null){
	groupCollection = search.luceneSearch('PATH:"/sys:system/sys:authorities/."') 
	model.nodes = groupCollection;
}else{
	groupCollection = search.luceneSearch('PATH:"/sys:system/sys:authorities/*"');
	model.nodes = groupCollection;
	makesort=true;

}


model.makesort=makesort;

//var lenT=args["lengthh"];
//if(lenT){
//	model.len=args["lengthh"];
//}

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

