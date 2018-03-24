package lm44_yb22.model.cmd;

import javax.swing.ImageIcon;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import lm44_yb22.model.IReceiverAdapter;

public class ImageCmd extends DataPacketAlgoCmd<ImageIcon>{
	private ICmd2ModelAdapter cmd2ModelAdpt;
	public ImageCmd(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated constructor stub
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1394179602353345770L;

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<ImageIcon> host, String... params) {
		// TODO Auto-generated method stub
		((IReceiverAdapter)cmd2ModelAdpt).displayImage(host.getData());
		return null;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		
	}

}
