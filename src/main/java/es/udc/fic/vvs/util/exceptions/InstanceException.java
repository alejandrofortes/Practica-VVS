package es.udc.fic.vvs.util.exceptions;

@SuppressWarnings("serial")
public abstract class InstanceException extends Exception {

	protected InstanceException(String specificMessage, Object key,
			String className) {

		super(specificMessage + " (key = '" + key + "' - className = '"
				+ className + "')");

	}

}
