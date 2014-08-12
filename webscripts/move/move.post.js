<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">

var result=null;
var whereId=args.where;

var nodeRefWhere="workspace://SpacesStore/"+whereId;
var whereNode = search.findNode(nodeRefWhere);

var moveWho=args.who;
var splitWhos= moveWho.split(';');
 var result=new Array();
 
for(var i=0;i<splitWhos.length;i++)
{
 
	var nodeRefcurrent=splitWhos[i];
	var whoNode = search.findNode(nodeRefcurrent);
	
	var destinationNode = whereNode.childByNamePath(whoNode.name)
	if(destinationNode!=null&& destinationNode.isDocument)
		{
		
		destinationNode.addAspect("cm:versionable");
	
		// check it out and update content on the working copy
		var workingCopy = destinationNode.checkout();
		//workingCopy.content = whoNode.content;
		workingCopy.properties.content.write(whoNode.properties.content);

		// check it in
		doc = workingCopy.checkin();
		result.push(destinationNode);
		
		whoNode.remove();
		
		}else{
			whoNode.move(whereNode);
			result.push(whoNode);
		}
	

	
}
 


model.nodes=result;









	
	

	
	
	


