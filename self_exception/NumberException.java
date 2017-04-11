package self_exception;

public class NumberException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NumberException(){
		super("数据选择有误");
	}

}
