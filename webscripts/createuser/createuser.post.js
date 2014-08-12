<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

var result=null;

var username=args["username"];

var email=args["email"];
var firstname=args["firstname"];
var lastname=args["lastname"];
var username=args["username"];
var password=args["password"];

var user=people.getPerson(args["username"]);

if( user == null){
 user = people.createPerson(username,firstname,lastname,email,password,true);
 logger.log("AAAAAAAAAAAAAAAAAA"+user.properties["cm:firstName"]);
 user.save();
}


//people.setPassword(username,args["password"]);

var result=new Array();
result.push(user);


model.nodes=result;










	
	

	
	
	


