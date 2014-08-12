<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

	var result=null;
	var deleteWho=args.who;
	var splitWhos= deleteWho.split(';');
	var result=new Array();
	result.push(companyhome);
	
	
	var storesArray = avm.stores ;
	
	for(var i=0;i<storesArray.length;i++)
	{
		logger.log( storesArray[i].name );
	}
	
	
	
	
 
	for(var i=0;i<splitWhos.length;i++)
	{
		var nodeRefcurrent=splitWhos[i];
		var whoNode = search.findNode(nodeRefcurrent);
		
		
		if(whoNode.hasPermission("Delete")){
			/*whoNode.addAspect("sys:archived");
			whoNode.proprerties['sys:archivedBy']=user.properties['userName'];
			whoNode.proprerties['sys:archivedDate']=new Date();
			whoNode.proprerties['sys:archivedOriginalParentAssoc']=whoNode.parent();
		
			var creator=whoNode.properties['cm:creator'];
		
			if(!creator)
				{
				creator=whoNode.properties['cm:owner'];
				}
		
			whoNode.proprerties['sys:archivedOriginalOwner']=creator;
			whoNode.addAspect('cm:ownable');
		
			whoNode.proprerties['cm:owner']=user.properties['userName'];*/
		
		   whoNode.remove();
			
		}
	}
	
 
	model.nodes=result;









	
	

	
	
	


