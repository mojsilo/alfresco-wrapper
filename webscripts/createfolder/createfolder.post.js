<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

var result=null;
var currentId=args.current;

var currentRef="workspace://SpacesStore/"+currentId;
var currentNode = search.findNode(currentRef);

var result=new Array();


var newFolder = currentNode.createFolder('132132121321');

for (arg in args)
{
  if(arg!="current")
  {
	logger.log(arg + "=" + args[arg]);
	newFolder.properties[arg]=decodeString(args[arg]);
  }
  newFolder.save();
  result.push(newFolder);
}

model.nodes=result;









	
	

	
	
	


