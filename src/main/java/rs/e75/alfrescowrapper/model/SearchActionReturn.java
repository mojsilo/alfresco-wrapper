package rs.e75.alfrescowrapper.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;



/**
 * Retuns after search , holds store, query, sortColumn,asc
 * 
 * @author Savic Prvoslav
 * 
 */
public class SearchActionReturn extends ActionReturn {

	private static final long serialVersionUID = 5518811404680772419L;
	private String store = "";
	/**
	 * real lucene query
	 */
	private String query = "";
	/**
	 * query part to show to user
	 */
	private String showText = "";

	private String sortColumn = "";
	private String asc = "";

	public void setShowText(String showText) {
		this.showText = showText;
	}

	public String getShowText() {
		// so it would always return search value
		if (showText != null && !showText.equals("")) {
			return showText;
		} else {
			return query;
		}
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		String value;
		try {
			value = URLEncoder.encode(query, "UTF-8");
			this.query = value.replace("+", " ");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.query = query;
		}
		
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getAsc() {
		return asc;
	}

	public void setAsc(String asc) {
		this.asc = asc;
	}

}
