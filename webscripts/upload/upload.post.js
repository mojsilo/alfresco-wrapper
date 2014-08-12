<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

var realFilename="";
var content;
for each (field in formdata.fields)
{
 
  if (field.name == "file" && field.isFile)
  {
      realFilename = field.filename;
      content = field.content;
  }
  
}

// ensure mandatory file attributes have been located
if (realFilename == undefined || content == undefined)
{
  status.code = 400;
  status.message = "Uploaded file cannot be located in request";
  status.redirect = true;
}
else
{
	var currentRef="workspace://SpacesStore/"+args["current"];
	var currentNode = search.findNode(currentRef);

	var result=new Array();
	if(currentNode != undefined){
	 var name =args["{http://www.alfresco.org/model/content/1.0}name"];
	 var child=currentNode.childByNamePath(name);
	 logger.error("verzija postoji"+child+" "+name);
		if(child == null){
	
			upload = currentNode.createFile(name);
			for (arg in args)
				{
				logger.error(arg + "=" + args[arg]);
				if(arg!="current" && arg!="alf_ticket" && arg!="file")
					{
					
						upload.properties[arg]=decodeString(args[arg]);
						upload.save();
						result.push(upload);
					}
				}	
  
			upload.properties.content.write(content);
			upload.properties.content.setEncoding("UTF-8");
			upload.properties.content.guessMimetype(realFilename);
			upload.save();
		
		}else{
		
			var newversion = child.checkout();
			newversion.content=content;
			newversion.checkin("",true);
			
			result.push(child);
		}
		model.nodes=result;
	
	}else{
		status.code = 400;
		status.message = "You have sent wrong project id";
		status.redirect = true;
	} 
}
