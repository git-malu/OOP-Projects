package model;

import java.awt.Color;
import java.awt.Container;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.ADataPacketAlgoCmdGroupF;
import common.DataPacketGroupF;
import common.IChatServer;
import common.ICmd2ModelAdapter;
import common.IUser;

/**
 * Image data packet algorithm command
 * 
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public class ImageDataPacketAlgoCmd extends ADataPacketAlgoCmdGroupF<ImageIcon> {
	private static final long serialVersionUID = 2789479161545360434L;

	/**
	 * Command to model adapter, this should be set on the server side When sent
	 * from client to server
	 */
	transient ICmd2ModelAdapter cmd2ModelAdapter;

	@Override
	public String apply(Class<?> index, DataPacketGroupF<ImageIcon> host, IChatServer... params) {
		ImageIcon data = host.getData();
		try {
			IUser user = host.getSender().getUser();
			//Get show panel
			Container pnl_show = cmd2ModelAdapter.getScrollable();
			JLabel label;
			//Append data to show panel
			try {
				label = new JLabel(user.getName() + "@" + user.getIP() + ":");
				label.setOpaque(true);
				label.setBackground(Color.white);
				pnl_show.add(label);
				label = new JLabel(data);
				pnl_show.add(label);
				pnl_show.add(Box.createVerticalStrut(10));
				pnl_show.revalidate();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		return data.toString();
	}

	/**
	 * Set command to model adapter
	 */
	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = cmd2ModelAdpt;
	}
}
