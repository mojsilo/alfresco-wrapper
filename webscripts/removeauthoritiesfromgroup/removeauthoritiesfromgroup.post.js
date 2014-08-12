<import resource="classpath:alfresco/webscripts/yanado/handleset.js">

var result=null;
var group=args.current;
var authoritie=args.authoritie;


var groupNode = people.getGroup(group);
var urs = people.getPerson(authoritie);

var result=new Array();
if(groupNode!=null && urs !=null)
{
	people.removeAuthority(groupNode,urs  );
	result.push(groupNode);
}else{
	result.push(companyhome);
}

model.nodes=result;












	
	

	
	
	


