package model.datapackeAlgoCmd;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import model.ILocalCmd2ModelAdapter;
public class DefaultCmd extends DataPacketAlgoCmd<Object> {
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 2550789087966390011L;
	
	private transient ILocalCmd2ModelAdapter _localCmd2ModelAdpt;
	
	@Override
	public String apply(Class<?> index, DataPacketChatRoom<Object> host, String... params) {
		Object x= host.getData();
		String msg = "Default case called. data = "+ x;
		_localCmd2ModelAdpt.appendMsg(msg);
		return msg;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this._localCmd2ModelAdpt = (ILocalCmd2ModelAdapter) cmd2ModelAdpt;
	}

}
