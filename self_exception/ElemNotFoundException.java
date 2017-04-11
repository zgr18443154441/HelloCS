package self_exception;

public class ElemNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElemNotFoundException(){
		super("未找到该元素");
	}
}
