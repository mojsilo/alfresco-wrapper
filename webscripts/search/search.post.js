<import resource="classpath:alfresco/templates/webscripts/snt/handleset.js">
<import resource="classpath:alfresco/templates/webscripts/snt/functions.js">

var result=null;

var store =args.store;
var query =decodeString(args.query);

var sortColumn =args.sortColumn;
var asc =args.asc;
var ascBool = Boolean(asc);  
//query=search.ISO9075Encode(query);

if(query!= null){
	if(asc!=null && sortColumn!=null){
		result = search.luceneSearch( query,  sortColumn,  false) ;
	}else if(store!=null){
		result = search.luceneSearch( store,  query) ;
	}else{
		result = search.luceneSearch( query) ;
	}
}

model.nodes=result;
model.children=args.children;
model.query = query;
model.typeorder=args.typeorder;

var currentPage=args["currentPage"];
var lenT=args["lengthh"];

if(currentPage){
	if(lenT){
		var finish = currentPage*lenT;
		var start =  (currentPage-1)*lenT;
		if(start>0)
			{
				start=start+1;
			}

		model.start=start;
		model.finish=finish;
	}	
}














	
	

	
	
	


