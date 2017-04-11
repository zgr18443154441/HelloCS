package data_structures.link;

import self_exception.OutOfIndexException;

/**
 * 链表
 * @author 张国荣
 *
 */
public class ChainStruct {
	private Object obj;
	private ChainStruct next = null;
	private int size;
	/**
	 * 无参初始化
	 */
	public ChainStruct(){
		this.size = 0;
	}
	/**
	 * 有参初始化
	 * @param objs
	 */
	public ChainStruct(Object[] objs){
		for(Object e : objs){
			this.addToTail(e);
		}
	}
	
	/**
	 * 节点初始化
	 * @param obj
	 */
	private ChainStruct(Object obj){
		this.obj = obj;
	}
	
	public String toString() {
		if(this.isEmpty()){
			return "no_elem";
		}else{
			StringBuffer stringBuffer = new StringBuffer();
			ChainStruct cs = this;
			stringBuffer.append("Head>");
			while(cs.next!=null){
				cs = cs.next;
				stringBuffer.append(cs.obj).append(">");
			}
			stringBuffer.deleteCharAt(stringBuffer.length()-1);
			return stringBuffer.toString();
		}
	}
	/**
	 * 空链表判断
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * 计算链表长度
	 * @return
	 */
	public int size(){
		return this.size;
	}
	
	/**
	 * 添加节点到链表尾部
	 * @param obj
	 */
	public void addToTail(Object obj){
		ChainStruct end = new ChainStruct(obj);
		ChainStruct cs = this;
		while(cs.next!=null){
			cs = cs.next;
		}
		cs.next = end;
		this.size++;
	}
	
	/**
	 * 添加节点到链表头部
	 * @param obj
	 */
	public void addToHead(Object obj){
		ChainStruct head = new ChainStruct(obj);
		head.next = this.next;
		this.next = head;
		this.size++;
	}
	
	/**
	 * 插入节点到索引位置
	 * @param index
	 * @param obj
	 */
	public void insert(int index,Object obj){
		if(index>=this.size||index<0){
			try {
				throw new OutOfIndexException();
			} catch (OutOfIndexException e) {
				e.printStackTrace();
			}
		}else{
			ChainStruct insert = new ChainStruct(obj);
			ChainStruct cs = this;
			for(int i=0;i<index;i++){
				cs = cs.next;
			}
			insert.next = cs.next;
			cs.next = insert;
			this.size++;
		}
	}
	
	/**
	 * 整表删除
	 */
	public void clean(){
		this.next = null;
		this.size = 0;
	}
	
	/**
	 * 索引删除
	 * @param index
	 */
	public void IndexDelete(int index){
		if(index>=this.size||index<0){
			try {
				throw new OutOfIndexException();
			} catch (OutOfIndexException e) {
				e.printStackTrace();
			}
		}else{
			ChainStruct delete = this;
			for(int i=0;i<index;i++){
				delete = delete.next;
			}
			delete.next = delete.next.next;
			this.size--;
		}
	}
	
	/**
	 * 元素删除
	 * @param obj
	 */
	public void ObjectDelete(Object obj){
		ChainStruct cs = this;
		while(cs.next!=null){
			if(cs.next.obj.equals(obj)){
				cs.next = cs.next.next;
				this.size--;
			}else{				
				cs = cs.next;
			}
		}
	}
}
