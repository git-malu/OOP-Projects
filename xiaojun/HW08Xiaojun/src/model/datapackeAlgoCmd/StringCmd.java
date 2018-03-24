package model.datapackeAlgoCmd;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import model.ILocalCmd2ModelAdapter;

public class StringCmd extends DataPacketAlgoCmd<String>{
	
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -8679114362982528617L;
	
	private transient  ILocalCmd2ModelAdapter _localCmd2ModelAdpt;
	
	@Override
	public String apply(Class<?> index, DataPacketChatRoom<String> host, String... params) {
		String msg = host.getData();
		System.out.println("pika" + msg);
		String x = "String case called. data = "+ msg;
		_localCmd2ModelAdpt.appendMsg(msg);
		return x;
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this._localCmd2ModelAdpt = (ILocalCmd2ModelAdapter) cmd2ModelAdpt;
	}

	
}
