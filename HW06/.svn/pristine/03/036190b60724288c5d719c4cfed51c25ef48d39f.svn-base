package model;

import provided.music.APhraseVisitor;
import provided.music.IPhrase;
import provided.music.IPhraseVisitorCmd;
import provided.music.MTSeqList;
import provided.music.NESeqList;

/**
 * A visitor that supports toString() function
 * @author caixy
 *
 */
public class PrintPhraseVisitor extends APhraseVisitor {

	/**
	 * A pointer to itself
	 */
	private final PrintPhraseVisitor _pointerToThis = this; //it has to be here

	/**
	 * Constructor
	 */
	public PrintPhraseVisitor() {
		super(new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				return host.toString();
			}
		});

		/**
		 * Handle NESeqList
		 */
		this.addCmd(NESeqList.ID, new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				NESeqList neHost = (NESeqList) host;
				return (String) params[0]
						+ (String) neHost.getRest().execute(_pointerToThis, ", " + neHost.getFirst().toString());
			}
		});

		/**
		 * Handle MTSeqList
		 */
		this.addCmd(MTSeqList.ID, new IPhraseVisitorCmd() {
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				return "}"; 
			}
		});
	}
}
