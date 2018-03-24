package lm44_xw47.model.dataPacketAlgoCmd;

import java.rmi.RemoteException;

import javax.swing.SwingUtilities;

import common.DataPacketUser;
import common.DataPacketUserAlgoCmd;
import common.IUser;
import common.IUserCmd2ModelAdapter;
import common.datatype.IRequestCmdType;
import common.datatype.user.IUserExceptionStatusType;
import common.datatype.user.IUserInstallCmdType;
import common.datatype.user.IUserRejectionStatusType;
import lm44_xw47.model.dataType.UserExceptionStatusType;
import lm44_xw47.model.dataType.UserInstallCmdType;
import lm44_xw47.model.dataType.UserRejectionStatusType;
import provided.datapacket.DataPacketAlgo;

public class UserRequestCmd extends DataPacketUserAlgoCmd<IRequestCmdType>{

	/**
	 * An auto-generated id for serialization.
	 */
	private static final long serialVersionUID = -4815034249569486281L;
	
	/**
	 * The adapter this command uses to communicate with local system.
	 */
	private transient IUserCmd2ModelAdapter cmd2ModelAdpt;
	
	/**
	 * The visitor which holds this command.
	 */
	private transient DataPacketAlgo<String, String> algo;
	
	private transient IUser userStub;
	
	public UserRequestCmd(IUserCmd2ModelAdapter cmd2ModelAdpt, DataPacketAlgo<String, String> algo, IUser userStub) {
		this.cmd2ModelAdpt = cmd2ModelAdpt;
		this.algo = algo;
		this.userStub = userStub;
	}

	@Override
	public String apply(Class<?> index, DataPacketUser<IRequestCmdType> host, String... params) {
		IUser sender = host.getSender();
		index = host.getData().getCmdId();
		DataPacketUserAlgoCmd<?> cmd = (DataPacketUserAlgoCmd<?>) algo.getCmd(index);
		if (cmd != null) {
			try {
				System.out.println("it is executed");
				System.out.println(sender);
				sender.receive(new DataPacketUser<IUserInstallCmdType>(IUserInstallCmdType.class,
						new UserInstallCmdType(index, cmd), userStub));
				System.out.println("I should sent this command");
			} catch (RemoteException e) {
				e.printStackTrace();
				String exceptionInfo = "An remote exception when sending cmd to the receiver occured.";
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						cmd2ModelAdpt.appendMsg(exceptionInfo, "Remote Server Exception");;
					}
				});
				try {
					sender.receive(new DataPacketUser<IUserExceptionStatusType>(IUserExceptionStatusType.class,
							new UserExceptionStatusType(exceptionInfo, host), userStub));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		} else {
			String rejectionInfo = "The sender doesn't have the cmd to process the following data Type: " + index;
			try {
				sender.receive(new DataPacketUser<IUserRejectionStatusType>(IUserRejectionStatusType.class,
						new UserRejectionStatusType(rejectionInfo, host), userStub));
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
