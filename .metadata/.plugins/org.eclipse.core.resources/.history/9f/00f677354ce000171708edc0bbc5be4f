package lm44_xw47.model.dataPacketAlgoCmd;

import java.rmi.RemoteException;
import java.util.Map;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IChatRoom;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import common.datatype.user.IInvitationType;
import lm44_xw47.chatRoom.model.ChatRoom;
import lm44_xw47.model.dataType.InvitationType;
import lm44_xw47.model.dataType.JoinTeamType;

/**
 * join team command
 *
 */
public class JoinTeamCmd extends DataPacketUserAlgoCmd<JoinTeamType> {
	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -2797418269631586544L;
	
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	private transient Map<IUser, IChatRoom> teamsByUser;
	
	private transient Map<String, IChatRoom> teamsByName;
	
	private transient IUser userStub;
	
	public JoinTeamCmd(IUserCmd2ModelAdapter cmd2ModelAdpt, Map<IUser, IChatRoom> teamsByUser, Map<String, IChatRoom> teamsByName, IUser userStub) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
		this.teamsByUser = teamsByUser;
		this.teamsByName = teamsByName ;
		this.userStub = userStub;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<JoinTeamType> host, String... params) {
		String teamName = host.getData().getTeamName();
		IUser sender = host.getSender();
		
		if (! teamsByUser.containsKey(sender)) {
			if (! teamsByName.containsKey(teamName)) {
				teamsByName.put(teamName, new ChatRoom(teamName));
			}
			IChatRoom team = teamsByName.get(teamName);
			teamsByUser.put(sender, team);
			try {
				sender.receive(new DataPacketUser<IInvitationType>(IInvitationType.class, new InvitationType(team), userStub));
				cmd2ModelAdpt.appendMsg("A user has joined a team. \n", "System: ");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}
		return "";
	}

	@Override
	public void setCmd2ModelAdpt(IUserCmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}

}
