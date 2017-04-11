package data_structures.link;

import self_exception.OutOfIndexException;

/**
 * 可扩容的静态链表
 * @author 张国荣
 *
 */
public class StaticChain {
	private Node[] list;
	private Node[] temp;
	private int maxSize;
	private int size = 1;
	private final int DEFAULTSIZE = 10;
	private class Node{
		private Object obj;
		private int cursor;	//游标（0代表链表尾部，-1代表数据为null，数组第一项的游标代表下一个数据要插入的索引位置）
	}
	/**
	 * 无参初始化
	 */
	public StaticChain(){
		this.maxSize = this.DEFAULTSIZE;
		this.list = new Node[this.maxSize];
		this.list[0] = new Node();
		this.list[0].cursor = 1;
	}
	
	/**
	 * 有参初始化
	 * @param size
	 */
	public StaticChain(int size){
		this.maxSize = size;
		this.list = new Node[this.maxSize];
		this.list[0] = new Node();
		this.list[0].cursor = 1;
	}
	
	/**
	 * 有值初始化
	 * @param list
	 */
	public StaticChain(Object[] list){
		this.maxSize = list.length*2;
		this.list = new Node[this.maxSize];
		this.list[0] = new Node();
		this.list[0].cursor = 1;
		for(Object e : list){
			this.add(e);
		}
	}
	
	public String toString() {
		if(this.isEmpty()){
			return "no_elem";
		}else{
			StringBuffer stringBuffer = new StringBuffer().append("Head>");
			int first_index = this.list[0].cursor;
			for(int i=1;i<this.maxSize;i++){
				if(this.list[i]!=null&&this.list[i].cursor<first_index&&this.list[i].cursor>0){
					first_index = i;
				}
			}
			Node n = this.list[first_index]; 
			while(n.cursor!=0){
				stringBuffer.append(n.obj).append(">");
				n = this.list[n.cursor];
			}
			stringBuffer.append(n.obj);
			return stringBuffer.toString();
		}
	}
	
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return this.size == 1;
	}
	
	/**
	 * 判断链表是否已满
	 * @return
	 */
	public boolean isFull(){
		return this.size == this.maxSize;
	}
	
	/**
	 * 计算链表长度
	 * @return
	 */
	public int size(){
		return this.size-1;
	}
	
	/**
	 * 链表扩容
	 */
	public void enlarge(){
		this.temp = this.list.clone();
		this.maxSize*=2;
		this.list = new Node[this.maxSize];
		for(int i=0;i<this.temp.length;i++){
			this.list[i] = this.temp[i];
		}
	}
	/**
	 * 添加结点到尾部
	 * @param obj
	 */
	public void add(Object obj){
		//判断链表是否有空余位置
		if(this.isFull())this.enlarge();
		//确定新结点要插入的索引位置
		int insert_index = this.list[0].cursor;
		//插入新结点
		this.list[insert_index] = new Node();
		//插入数据
		this.list[insert_index].obj = obj;
		//遍历数组
		for(int i=0;i<this.maxSize;i++){
			//寻找链表原尾部结点
			if(this.list[i]!=null&&this.list[i].cursor==0){
				//将尾部结点的游标指向新插入节点的索引位置
				this.list[i].cursor = insert_index;
				break;
			}
		}
		//更新链表尾部
		this.list[insert_index].cursor = 0;
		//链表长度更新
		this.size++;
		this.updateHead();
	}
	
	public void insert(Object obj,int index){
		if(this.isFull())this.enlarge();
		if(index>this.size){
			try {
				throw new OutOfIndexException();
			} catch (OutOfIndexException e) {
				e.printStackTrace();
			}
		}else{
			int insert_index = this.list[0].cursor;
			this.list[insert_index].obj = obj;
		}
	}
	
	/**
	 * 插入数据后更新头结点的游标
	 */
	private void updateHead(){
		//判断数组是否已满
		if(this.isFull()){
			//数组已满则将头指针的游标直接指向扩容后的第一个空位置索引
			this.list[0].cursor = this.size;
		}else{			
			//数组未满则寻找数组中第一个空位置的索引
			for(int i = 0;i<this.maxSize;i++){
				if(this.list[i] == null){
					//更新头指针的游标
					this.list[0].cursor = i;
					break;
				}
			}
		}
	}
	
}
