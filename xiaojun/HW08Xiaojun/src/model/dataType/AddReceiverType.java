package model.dataType;

import common.IAddReceiverType;
import common.IReceiver;

public class AddReceiverType implements IAddReceiverType{
	private IReceiver receiver;
	
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 1129217821143981134L;
	
	public AddReceiverType (IReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public IReceiver getReceiverStub() {
		return receiver;
	}
	
}
