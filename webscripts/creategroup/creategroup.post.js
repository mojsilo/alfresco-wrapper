<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

	var result=null;
	var currentId=args.current;
	var newgroup=args.newgroup;

	var currentGroup = null;

	if(currentId){
		currentGroup=people.getGroup(currentId);
	}

	var newGroup =  people.createGroup( currentGroup, newgroup) ;

	
	var result=new Array();
	result.push(newGroup );
	model.nodes=result;









	
	

	
	
	


