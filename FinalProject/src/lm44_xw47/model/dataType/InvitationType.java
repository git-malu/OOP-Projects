package lm44_xw47.model.dataType;

import common.IChatRoom;
import common.datatype.user.IInvitationType;

/**
 * 
 * invitation command type
 *
 */
public class InvitationType implements IInvitationType {
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -1309789572364445234L;
	
	/**
	 * chatroom
	 */
	private IChatRoom chatRoom;
	
	/**
	 * constructor that sets chatroom
	 * @param chatRoom
	 */
	public InvitationType(IChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}
	
	/**
	 * get chatroom
	 */
	@Override
	public IChatRoom getChatRoom() {
		return chatRoom;
	}
}
