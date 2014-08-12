package rs.e75.alfrescowrapper.util;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

/**
 * 
 * @author Savic Prvoslav
 * 
 */
public class YanadoDefaultHttpClient extends DefaultHttpClient {

	private static YanadoDefaultHttpClient defaultHttpClient = null;

	protected YanadoDefaultHttpClient(ThreadSafeClientConnManager clientConnManager) {
		super(clientConnManager);
	}

	public static YanadoDefaultHttpClient getInstance() {

		//if (defaultHttpClient == null) {
			ThreadSafeClientConnManager clientConnManager = new ThreadSafeClientConnManager();
			
			defaultHttpClient = new YanadoDefaultHttpClient(clientConnManager);
		//}
		
		return defaultHttpClient;

	}

}
