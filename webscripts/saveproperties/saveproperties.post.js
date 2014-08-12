<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

var result=null;
var currentId=args.current;

var currentRef="workspace://SpacesStore/"+currentId;
var currentNode = search.findNode(currentRef);

var result=new Array();
result.push(currentNode);

for (arg in args)
{
  
  
  if(arg!="current")
  {
  logger.log(arg + "=" + args[arg]);
  currentNode.properties[arg]=decodeString(args[arg]);
  
  }
  
}
currentNode.save();


model.nodes=result;









	
	

	
	
	


