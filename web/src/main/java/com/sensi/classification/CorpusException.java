package com.sensi.classification;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jun 19, 2012
 */
public class CorpusException extends RuntimeException {
	
	private static final long serialVersionUID = 288005682398875100L;

	public CorpusException(final String message) {
		super(message);
	}
	
	public CorpusException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
