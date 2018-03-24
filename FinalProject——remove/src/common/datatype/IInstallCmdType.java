package common.datatype;

import java.io.Serializable;
import common.ICmd2ModelAdapter;

/**
 * Common data type for transmitting command between remote peers.
 * Typically, when a receiver receives such a message (Due to the receiver sends a IRequestCmdType message before), 
 * it installs the command into the visitor.
 */
public interface IInstallCmdType<T extends provided.datapacket.ADataPacketAlgoCmd<java.lang.String,?,java.lang.String,? extends ICmd2ModelAdapter<?>,? extends provided.datapacket.DataPacket<?,?>>> extends Serializable {

	/**
	 *  Get the command
	 * @return the command
	 */
	public T getCmd();
	
	/**
	 * Get the command id
	 * @return the command id
	 */
	public Class<?> getCmdId();
}
