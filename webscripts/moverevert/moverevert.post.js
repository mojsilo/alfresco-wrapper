/*<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">*/

var result=null;
var whereId=args.where;

var nodeRefWhere="workspace://SpacesStore/"+whereId;
var whereNode = search.findNode(nodeRefWhere);

var moveWho=args.who;
var splitWhos= moveWho.split(';');
 var result=new Array();

logger.error("POKRENUO SI");

for(var i=0;i<splitWhos.length;i++)
{
 
	var nodeRefcurrent=splitWhos[i];
	var whoNode = search.findNode(nodeRefcurrent);
	
	var destinationNode = whereNode.childByNamePath(whoNode.name);


    var vHistoryList =  whoNode.versionHistory;

    for(var i=0;i<vHistoryList.length;i++)
    {
        logger.error(vHistoryList[i].label);
        logger.error(vHistoryList[i].type);
    }

    if(vHistoryList.length>1)//if should revert
    {

        logger.error("it has more then one verzions "+vHistoryList.length)
        var vHistory =  vHistoryList[0];//open prev version
        var historyNode = vHistory.node;
        var historyLabel = vHistory.label;

        if(destinationNode!=null && destinationNode.isDocument)
        {
            destinationNode.addAspect("cm:versionable");
            // check it out and update content on the working copy
            var workingCopy = destinationNode.checkout();
            //workingCopy.content = whoNode.content;
            workingCopy.properties.content.write(historyNode.properties.content);

            // check it in
            doc = workingCopy.checkin();
            result.push(destinationNode);

        }else{
            var createdFile = whereNode.createFile(whoNode.name);
            createdFile.properties.content.write(historyNode.properties.content);
            createdFile.save();

            result.push(createdFile);
        }

        whoNode.revert("approved by Prle", true, vHistoryList[1].label);


    }else{//do the plain move as we have one version

        if(destinationNode!=null && destinationNode.isDocument)
        {
            destinationNode.addAspect("cm:versionable");
            // check it out and update content on the working copy
            var workingCopy = destinationNode.checkout();
            //workingCopy.content = whoNode.content;
            workingCopy.properties.content.write(whoNode.properties.content);

            // check it in
            doc = workingCopy.checkin();
            result.push(destinationNode);

            whoNode.remove();
        }else{
            whoNode.move(whereNode);
            result.push(whoNode);
        }
    }





	
}
 


model.nodes=result;









	
	

	
	
	


