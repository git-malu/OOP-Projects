package client.clientModel.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;

import provided.client.model.taskUtils.ITaskFactory;
import provided.compute.ILocalTaskViewAdapter;
import provided.compute.ITask;
import provided.compute.ITaskResultFormatter;

/**
 * Given an input string, reverse the string word by word.
 * 
 * @author Yue Jiang, Lu Ma
 *
 */
public class ReverseWordsInString implements ITask<String> {

	/**
	 * SerialversionUID for well-defined serialization.
	 */
	private static final long serialVersionUID = 4972954745839814117L;

	/**
	 * Adapter to the local view. Marked "transient" so that it is not serialized
	 * and instead is re-attached at the destination (the server).
	 */
	private transient ILocalTaskViewAdapter taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER;

	/**
	 * Input string given to the constructor
	 */
	private String input = "";

	/**
	 * Constructor for the class.
	 * 
	 * @param input
	 *            A string to carry around.
	 */
	public ReverseWordsInString(String input) {
		this.input = input;
	}

	@Override
	public String execute() throws RemoteException {
		// TODO Auto-generated method stub
		taskView.append("ReverseWordsInString task called with input = " + input + "\n");
		if (input == null || input.length() == 0) {
			return "";
		}

		String[] array = input.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i = array.length - 1; i >= 0; --i) {
			if (!array[i].equals("")) {
				sb.append(array[i]).append(" ");
			}
		}

		// remove the last " "
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);

	}

	@Override
	public void setTaskViewAdapter(ILocalTaskViewAdapter viewAdapter) {
		// TODO Auto-generated method stub
		taskView = viewAdapter;
		viewAdapter.append("ReverseWordsInString task installed!\n");
	}

	@Override
	public ITaskResultFormatter<String> getFormatter() {
		// TODO Auto-generated method stub
		return new ITaskResultFormatter<String>() {
			public String format(String result) {
				return "ReverseWordsInString: " + result + "  (input = " + input + ")";
			}
		};
	}

	/**
	 * An ITaskFactory for this task
	 */
	public static final ITaskFactory<String> FACTORY = new ITaskFactory<String>() {

		@Override
		public ITask<String> make(String param) {
			return new ReverseWordsInString(param);
		}

		@Override
		public String toString() {
			return ReverseWordsInString.class.getName();
		}

	};

	/**
	 * Reinitializes transient fields upon deserialization. See the <a href=
	 * "http://download.oracle.com/javase/6/docs/api/java/io/Serializable.html">
	 * Serializable</a> marker interface docs. taskView is set to a default value
	 * for now (ILocalTaskViewAdapter.DEFAULT_ADAPTER).
	 * 
	 * @param stream
	 *            The object stream with the serialized data
	 * @throws IOException
	 *             if the input stream cannot be read correctly
	 * @throws ClassNotFoundException
	 *             if the class file associated with the input stream cannot be
	 *             located.
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject(); // Deserialize the non-transient data
		taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER; // re-initialize the transient field
	}
}
