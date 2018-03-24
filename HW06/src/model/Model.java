package model;

import provided.abcParser.ABCParser;
import provided.music.IPhrase;
import provided.music.NESeqList;
import provided.util.ABCUtil;

public class Model {

	/**
	 * An ABCParser
	 */
	ABCParser abcParser;

	/**
	 * A IPhrase object
	 */
	IPhrase phrase;

	/**
	 * load .abc file
	 * @param fileName the short name of the songs' files' name 
	 * @return the contents of the file
	 */
	public String loadFile(String fileName) {
		abcParser = new ABCParser(fileNameFix(fileName));
		phrase = abcParser.parse();
		return ABCUtil.Singleton.getFileContents(fileNameFix(fileName));
	}

	/**
	 * Return the full name of the song's file
	 * @param fileName name of the song
	 * @return the full name of the song's file
	 */
	private String fileNameFix(String fileName) {
		return "/songs/" + fileName + ".abc";
	}

	/**
	 * Parse the music file
	 * @return parsed content of the file
	 */
	public String parse() {
		return phrase.toString();
	}

	/**
	 * Play the music file
	 * @param instrument instrument we would like to play with
	 */
	public void playMusic(int instrument) {
		phrase.execute(new PlayPhraseVisitor(instrument));
	}

	/**
	 * Start the model
	 */
	public void start() {
		NESeqList.setToStringAlgo(new PrintPhraseVisitor());
	}
}
