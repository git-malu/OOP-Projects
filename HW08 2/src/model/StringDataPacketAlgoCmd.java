package model;

import java.awt.Color;
import java.awt.Container;
import java.rmi.RemoteException;
import javax.swing.Box;
import javax.swing.JLabel;
import common.ADataPacketAlgoCmdGroupF;
import common.DataPacketGroupF;
import common.IChatServer;
import common.ICmd2ModelAdapter;
import common.IUser;

/**
 * String data packet algorithm command
 * 
 * @author Gengwu Li, Zhaohan Jia
 * @version 1.0, Nov 14, 2016
 */
public class StringDataPacketAlgoCmd extends ADataPacketAlgoCmdGroupF<String> {
	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = -7821334978189129998L;

	/**
	 * Command to model adapter
	 */
	transient ICmd2ModelAdapter cmd2ModelAdapter;

	@Override
	public String apply(Class<?> index, DataPacketGroupF<String> host, IChatServer... params) {
		String data = host.getData();
		System.out.println(data);
		try {
			IUser user = host.getSender().getUser();
			Container pnl_show = cmd2ModelAdapter.getScrollable();
			JLabel label;
			try {
				label = new JLabel(user.getName() + "@" + user.getIP() + ":" + data);
				label.setOpaque(true);
				label.setBackground(Color.white);
				pnl_show.add(label);
				pnl_show.add(Box.createVerticalStrut(10));
				pnl_show.revalidate();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		return data;
	}

	/**
	 * Set command to model adapter
	 */
	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = cmd2ModelAdpt;
	}
}
