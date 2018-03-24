package model;

import common.IChatServer;

/**
 * Mini model to main model adapter
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public interface IMini2MainAdpt {
	/**
	 * Create a server in the main model
	 * @return the chat server
	 */
	IChatServer createServer();
}
