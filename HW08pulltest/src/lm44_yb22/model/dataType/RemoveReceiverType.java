package lm44_yb22.model.dataType;

import common.IReceiver;
import common.IRemoveReceiverType;

public class RemoveReceiverType implements IRemoveReceiverType{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8945498932231455988L;
	
	private IReceiver receiver;
	
	public RemoveReceiverType(IReceiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public IReceiver getReceiverStub() {
		return receiver;
	}

}
