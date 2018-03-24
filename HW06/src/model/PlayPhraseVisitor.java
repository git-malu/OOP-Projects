package model;

import provided.music.APhraseVisitor;
import provided.music.Chord;
import provided.music.Header;
import provided.music.IPhrase;
import provided.music.IPhraseVisitorCmd;
import provided.music.MTSeqList;
import provided.music.NESeqList;
import provided.music.Note;
import provided.music.Triplet;
import provided.player.ISequencePlayerStatus;
import provided.player.SequencePlayer;
import provided.util.ABCUtil;
import provided.util.KeySignature;

/**
 * A extend visitor class that support playing the music
 * @author caixy
 */
public class PlayPhraseVisitor extends APhraseVisitor {
	/**
	 * A pointer to itself, very important.
	 */
	PlayPhraseVisitor _pointerToThis = this;
	/**
	 * A SequencePlayer instance
	 */
	SequencePlayer sp;

	/**
	 * A int object to track the time when the new notes should be insert
	 */
	int tick = 0;

	/**
	 * A KeySignature instance to adjust the notes
	 */
	KeySignature keySignature;

	/**
	 * Constructor
	 * @param instrument the instrument we want play with
	 */
	public PlayPhraseVisitor(int instrument) {
		super();

		/**
		 * Initialize the SequencePlayer
		 */
		initSequencePlayer(instrument);

		/**
		 * Handle with default header
		 */
		String headerString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < headerString.length(); i++) {
			this.addCmd("" + headerString.charAt(i), new IPhraseVisitorCmd() {
				@Override
				public Object apply(String id, IPhrase host, Object... params) {
					return null;
				}
			});
		}

		/**
		 * L header
		 */
		this.addCmd("L", new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				Header header = (Header) host;
				/**
				 * We multiple header's value by ticks per quarter note and 4 
				 * in order to adjust the speed. 
				 * A... why there are so many parameters... It took me a lot of time to get to know
				 * these parameters' meaning and find the right parameters
				 */
				sp.setTicksPerDefaultNote(
						(int) (ABCUtil.Singleton.parseFraction(header.getValue()) * sp.getTicksPerQuarterNote() * 4));
				return null;
			}
		});

		/**
		 * Handle the header Q
		 */
		this.addCmd("Q", new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				Header header = (Header) host;
				sp.setTempo((int) ABCUtil.Singleton.parseTempo(header.getValue(),
						sp.getTicksPerQuarterNote() / sp.getTicksPerDefaultNote()));
				return null;
			}
		});

		/**
		 * Handle the header K
		 */
		this.addCmd("K", new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				Header header = (Header) host;
				keySignature = new KeySignature(header.getValue());
				return null;
			}
		});

		this.addCmd(Note.ID, new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				Note note = (Note) host;
				note = keySignature.adjust(note);
				tick = sp.addNote(note, tick);
				return null;
			}
		});

		/**
		 * Handler chords
		 */
		this.addCmd(Chord.ID, new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				Chord chord = (Chord) host;
				int tmpTick = tick;
				for (Note note : chord.getNotes()) {
					note = keySignature.adjust(note);
					tmpTick = sp.addNote(note, tick);
				}
				tick = tmpTick;
				return null;
			}
		});

		/**
		 * Handle triplets
		 */
		this.addCmd(Triplet.ID, new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				Triplet triplets = (Triplet) host;
				for (Note note : triplets.getNotes()) {
					note = keySignature.adjust(note);
					note.setDuration(note.getDuration() * ((double)2 / 3));
					tick = sp.addNote(note, tick);
				}
				return null;
			}
		});

		/**
		 * Handle NESeqList
		 */
		this.addCmd(NESeqList.ID, new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				NESeqList neList = (NESeqList) host;
				neList.getFirst().execute(_pointerToThis);
				neList.getRest().execute(_pointerToThis);
				return null;
			}

		});

		/**
		 * Handle MTSeqList
		 */
		this.addCmd(MTSeqList.ID, new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				sp.play(ISequencePlayerStatus.NULL);
				return params;
			}
		});
	}

	/**
	 * Initialize the SequencePlayer
	 * @param instrument the instrument we want play with
	 */
	private void initSequencePlayer(int instrument) {
		sp = new SequencePlayer(16, instrument);
		sp.setTicksPerDefaultNote(16); // 16 = ticks per DEFAULT note
		sp.setTempo(140); // 140 quarter notes (beats) per minute
	}
}
