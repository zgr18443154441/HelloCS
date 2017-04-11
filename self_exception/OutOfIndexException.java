package self_exception;

public class OutOfIndexException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutOfIndexException(){
		super("索引越界");
	}
}
