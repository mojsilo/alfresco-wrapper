function decodeString(value)
{
 value =  decodeURIComponent(value);
 logger.log(value);
 //return value.replace('t','5');
 return value;
 
}


function getProjectFromGroup(whatNode)
{

			logger.log("PROBAMO PARENT ");
	var project = null;
	if(whatNode.hasAspect("sc:rootprojectgroup"))
	{
		project=whatNode.properties["sc:project"];
		
	}else{
		var whileNode = whatNode;
		while(whatNode.parent !=null)
		{
			whileNode=whileNode.parent;
			if(whileNode.type!='{http://www.alfresco.org/model/user/1.0}authorityContainer')
			{
				break;
			}
			if(whileNode.hasAspect("sc:rootprojectgroup"))
			{
				project=whileNode.properties["sc:project"];
				break;
			}
		}
	}
	return project;
}

function getFormData(name)
{
	for each (field in formdata.fields)
		{
 
		if (field.name == name )
			{
			return field.value;
			}
  
		}
}



function projectUserType(whatNode)
{

 var nodeTemp = whatNode;

 while(nodeTemp.parent!=null)
 {


	var par=nodeTemp;
	logger.log(par.type+" "+par.name);
	if(par.type=="{http://www.organizeddocs.com/model/content/1.0}project")
	{
		var group = par.properties["sc:projectgroup"];
		var adminGroup = par.properties["sc:projectgroup"];
		var publicGroup = par.properties["sc:projectgroup"];
		var privateGroup = par.properties["sc:projectgroup"];
		
		
		logger.log(privateGroup.properties["usr:authorityName"]);
		logger.log(adminGroup.properties["usr:authorityName"]);
		logger.log(publicGroup.properties["usr:authorityName"]);
		
		if(userInGroup(adminGroup))
		{
			return "admin";
		}else if(userInGroup(privateGroup)){
			return "private";
		}else if(userInGroup(publicGroup)){
			return "public";
		}
		 return "none";
		
		logger.log(privateGroup.properties["usr:authorityName"]);
		logger.log(adminGroup.properties["usr:authorityName"]);
		logger.log(publicGroup.properties["usr:authorityName"]);
		
		 return "none";
	}
	 nodeTemp=nodeTemp.parent;
 }
	return "none";	
 }

function userInGroup(group)
{

var members = people.getMembers(group,true);
var unCurrent = person.properties.userName;

for(var i=0;i<members.length;i++)
	{
	var un = members[i].properties.userName;
	
	if(un==null || unCurrent==null)
	{
	 continue;
	}
	if(un == unCurrent)
		{
		
			return true;
		}
	}
	return false;
}


function getFormData(name)
{
	for each (field in formdata.fields)
		{
 
		if (field.name == name )
			{
			return field.value;
			}
  
		}
}
