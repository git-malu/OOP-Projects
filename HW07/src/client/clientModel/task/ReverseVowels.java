package client.clientModel.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;

import provided.client.model.taskUtils.ITaskFactory;
import provided.compute.ILocalTaskViewAdapter;
import provided.compute.ITask;
import provided.compute.ITaskResultFormatter;

/**
 * Task to take a string as input and reverse only the vowels of a string.
 * 
 * @author Yue Jiang, Lu Ma
 *
 */
public class ReverseVowels implements ITask<String> {

	/**
	 * SerialversionUID for well-defined serialization.
	 */
	private static final long serialVersionUID = 6542585194146333126L;

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
	public ReverseVowels(String input) {
		this.input = input;
	}

	/**
	 * Takes a string as input and reverse only the vowels of a string
	 * 
	 * @param s
	 *            A string to carry around.
	 * @return A reversed string to carry around.
	 */
	private String reverseVowels(String s) {
		s = s.replaceAll("\\s", "");
		StringBuilder sb = new StringBuilder(s);
		StringBuilder vowels = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'o' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'O' || s.charAt(i) == 'E'
					|| s.charAt(i) == 'I' || s.charAt(i) == 'U') {
				vowels.append(s.charAt(i));
			}
		}

		for (int i = 0; i < vowels.length() / 2; i++) {
			char t = vowels.charAt(i);
			vowels.setCharAt(i, vowels.charAt(vowels.length() - 1 - i));
			vowels.setCharAt(vowels.length() - 1 - i, t);
		}

		int start = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == 'a' || sb.charAt(i) == 'o' || sb.charAt(i) == 'e' || sb.charAt(i) == 'i'
					|| sb.charAt(i) == 'u' || sb.charAt(i) == 'A' || sb.charAt(i) == 'O' || sb.charAt(i) == 'E'
					|| sb.charAt(i) == 'I' || sb.charAt(i) == 'U') {
				sb.setCharAt(i, vowels.charAt(start++));
			}
		}
		return sb.toString();
	}

	@Override
	public String execute() throws RemoteException {
		// TODO Auto-generated method stub
		taskView.append("ReverseVowels task called with input = " + input + "\n");
		if (input == null || input.length() == 0) {
			return "";
		}
		return reverseVowels(input);
	}

	@Override
	public void setTaskViewAdapter(ILocalTaskViewAdapter viewAdapter) {
		// TODO Auto-generated method stub
		taskView = viewAdapter;
		viewAdapter.append("ReverseVowels task installed!\n");
	}

	@Override
	public ITaskResultFormatter<String> getFormatter() {
		// TODO Auto-generated method stub
		return new ITaskResultFormatter<String>() {
			public String format(String result) {
				return "ReverseVowels: " + result + "  (input = " + input + ")";
			}
		};
	}

	/**
	 * An ITaskFactory for this task
	 */
	public static final ITaskFactory<String> FACTORY = new ITaskFactory<String>() {

		@Override
		public ITask<String> make(String param) {
			return new ReverseVowels(param);
		}

		@Override
		public String toString() {
			return ReverseVowels.class.getName();
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
