<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

var password = args["password"];

var username=args["username"];
var peopleCollection=new Array();
model.adminvalue=false;
//if(username)
//{
	var pers=people.getPerson(username);


	if(pers)
	{
		people.setPassword(username,password);
		peopleCollection.push(people.getPerson(username));
	}
//}
model.nodes = peopleCollection;
model.include="useradition.ftl";

