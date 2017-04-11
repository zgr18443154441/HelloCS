package self_exception;

public class TypeSelectException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TypeSelectException(){
		super("类型选择有误");
	}

}
