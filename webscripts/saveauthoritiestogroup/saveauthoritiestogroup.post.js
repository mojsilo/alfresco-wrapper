<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

var result=null;
var currentId=args.current;

var currentNode = search.findNode(currentId);

var users=args.authorities;

var historyUsers = people.getMembers(currentNode ,false);

for(var i=0;i<historyUsers.length;i++)
{
	people.removeAuthority(currentNode ,historyUsers[i]);

}

if(users!=null && users.length>0){
	var usersSplit=  users.split(";");
	for(var i=0;i<usersSplit.length;i++)
	{
		usr = usersSplit[i];
		usr = search.findNode(usr);
		people.addAuthority(currentNode ,usr );
	}
}
var result=new Array();
result.push(currentNode);
model.nodes=result;














	
	

	
	
	


