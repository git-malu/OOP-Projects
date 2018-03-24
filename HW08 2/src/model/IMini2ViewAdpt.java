package model;

import javax.swing.JPanel;

import common.IChatServer;

/**
 * Mini to view adapter
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public interface IMini2ViewAdpt {

	/**
	 * Add chatserver to list
	 */
	void addToList();

	/**
	 * Append information to view
	 * @param text The text to be displayed
	 */
	void append(String text);

	/**
	 * Add to JList the chatserver
	 * @param chatStub Chatserver stub
	 */
	void addToList(IChatServer chatStub);

	/**
	 * Get panel show
	 * @return The show panel
	 */
	JPanel getPnlShow();

	/**
	 * Remove chat server from JList
	 * @param chatServer The chatserver to be removed
	 */
	void remove(IChatServer chatServer);
}
