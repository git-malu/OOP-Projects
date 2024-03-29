package lm44_xw47.model.dataPacketAlgoCmd;

import common.DataPacketCR;
import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IChatRoom;
import common.IReceiver;
import common.IUserCmd2ModelAdapter;
import common.datatype.chatroom.IAddReceiverType;
import common.datatype.user.IInvitationType;
import lm44_xw47.chatRoom.model.dataType.AddReceiverType;
import lm44_xw47.model.ILocalUserCmd2ModelAdapter;
/**
 * command that invites
 *
 */
public class InvitationCmd extends DataPacketUserAlgoCmd<IInvitationType>{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = 3391248506497811811L;
	
	private transient ILocalUserCmd2ModelAdapter cmd2ModelAdpt;
	
	public InvitationCmd(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = (ILocalUserCmd2ModelAdapter) cmd2ModelAdpt;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<IInvitationType> host, String... params) {
		IChatRoom chatRoom = host.getData().getChatRoom();
		IReceiver receiver = cmd2ModelAdpt.joinTeam(chatRoom);
		System.out.println("Add Receiver.");
		chatRoom.sendPacket(new DataPacketCR<IAddReceiverType>(IAddReceiverType.class, new AddReceiverType(receiver), receiver));
		chatRoom.addIReceiverStub(receiver);
		return "Invitation command has been executed";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = (ILocalUserCmd2ModelAdapter) cmd2ModelAdpt;
	}
	
}
