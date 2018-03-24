package model.dataType;

import common.IReceiver;
import common.IRemoveReceiverType;

public class RemoveReceiverType implements IRemoveReceiverType{
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -2542760323584792544L;
	
	private IReceiver receiver;
	
	public RemoveReceiverType(IReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public IReceiver getReceiverStub() {
		return receiver;
	}
	
	
}
