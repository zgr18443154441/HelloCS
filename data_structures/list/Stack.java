package data_structures.list;

public class Stack {
	private final int DEFAULT_MAXSIZE = 10;
	private Object[] stack;
	private int maxSize;
	private int top;
	/**
	 * 无参初始化
	 */
	public Stack(){
		this.maxSize = this.DEFAULT_MAXSIZE;
		this.stack = new Object[this.maxSize];
		this.top = -1;
	}
	/**
	 * 有参初始化
	 * @param maxSize
	 */
	public Stack(int maxSize){
		this.maxSize = maxSize;
		this.stack = new Object[this.maxSize];
		this.top = -1;
	}
	/**
	 * 入栈
	 * @param obj
	 */
	public void push(Object obj){
		this.stack[++this.top] = obj;
	}
	/**
	 * 查看栈顶
	 * @return
	 */
	public Object peek(){
		return this.stack[this.top];
	}
	/**
	 * 出栈
	 * @return
	 */
	public Object pop(){
		return this.stack[top--];
	}
	/**
	 * 判断栈满
	 * @return
	 */
	public boolean isEmpty(){
		return this.top==-1;
	}
	/**
	 * 判断栈空
	 * @return
	 */
	public boolean isFull(){
		return this.top==this.maxSize-1;
	}
}
