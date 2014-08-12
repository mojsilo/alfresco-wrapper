package rs.e75.alfrescowrapper.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Class is extension of @Node , it has @NodeProperty s , used for edit and
 * creating new nodes
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class NodePropertyAbstraction extends Node {

	private static final long serialVersionUID = 218428190077548114L;

	Map<String, NodeProperty> map = new HashMap<String, NodeProperty>();

	public NodePropertyAbstraction(Node node) {
		super(node);
	}
	
	@Override
	public void setItSelf(Node node)
	{
		super.setItSelf(node);
		refreshNodeProperties();
	}

	public NodeProperty getPropertyNode(String name) {
		if (map.containsKey(name)) {
			return map.get(name);
		} else {

			Object object = getPropertie(name);
			NodeProperty nodeProperty = new NodeProperty(name, object);
			map.put(name, nodeProperty);
			return nodeProperty;
		}

	}

	public void refreshNodeProperties() {
		
		if(map==null)
		{
			map=new HashMap<String, NodeProperty>();
		}
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			NodeProperty nodeProperty = map.get(key);
			nodeProperty.setValue(getPropertie(nodeProperty.getName()));
		}
	}

	public List<NodeProperty> getModifiedNodeProperties() {
		Iterator<String> it = map.keySet().iterator();
		List<NodeProperty> list = new ArrayList<NodeProperty>();

		while (it.hasNext()) {
			String key = it.next();
			NodeProperty nodeProperty = map.get(key);
			if (nodeProperty.isValueChanged()) {
				list.add(nodeProperty);
			}

		}
		return list;
	}
}
