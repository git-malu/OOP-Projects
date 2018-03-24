package view;

public interface IView2ModelAdapter {

	/**
	 * Load the song's file
	 * @param fileName the song's file's name
	 * @return the content of the song's .abs file
	 */
	public String loadFile(String fileName);

	/**
	 * Play the song
	 * @param instrument the instrument we want to play with
	 */
	public void playMusic(int instrument);

	/**
	 * Parse the file we just loaded
	 * @return the parsed content of the song's file
	 */
	public String parseFile();

	/**
	 * A null object to of the adapter
	 */
	public static IView2ModelAdapter NULL_OBJECT = new IView2ModelAdapter() {

		@Override
		public String loadFile(String fileName) {
			return null;
		}

		@Override
		public void playMusic(int instrument) {
		}

		@Override
		public String parseFile() {
			return null;
		}

	};
}
