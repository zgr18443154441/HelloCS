package data_structures.link;

import self_exception.OutOfIndexException;
/**
 * 循环链表（带头结点）
 * @author 张国荣
 *
 */
public class LoopChain {
	private LoopChain next;
	private int size;
	private Object data;
	/**
	 * 无参初始化
	 */
	public LoopChain(){
		this.next = this;
		this.size = 0;
	}
	/**
	 * 有参初始化
	 * @param ls
	 */
	public LoopChain(Object[] ls){
		this.next = this;
		this.size = 0;
		for(int i=0;i<ls.length;i++){
			this.addToTail(ls[i]);
		}
	}
	/**
	 * 节点初始化
	 * @param data
	 */
	private LoopChain(Object data){
		this.data = data;
	}
	public String toString() {
		if(this.isEmpty()){
			return "no_elem";
		}else{
			StringBuffer stringBuffer = new StringBuffer().append("Head>");
			LoopChain lc = this.next;
			while(lc.next!=this){
				stringBuffer.append(lc.data+">");
				lc = lc.next;
			}
			return stringBuffer.append("Head").toString();
		}
	}
	/**
	 * 空表判断
	 * @return
	 */
	public boolean isEmpty(){
		return this.next == this;
	}
	/**
	 * 计算链表长度
	 * @return
	 */
	public int size(){
		return this.size;
	}
	/**
	 * 添加节点到尾部
	 * @param data
	 */
	public void addToTail(Object data){
		LoopChain rear = new LoopChain(data);
		rear.next = this;
		if(this.next == this){
			this.next = rear;
		}else{
			LoopChain head = this;
			while(head.next!=this){
				head = head.next;
			}
			head.next = rear;
		}
		this.size++;
	}
	/**
	 * 插入节点
	 * @param data
	 * @param index
	 */
	public void insert(Object data,int index){
		if(index>this.size){
			try{
				throw new OutOfIndexException();
			}catch(OutOfIndexException e){
				e.printStackTrace();
			}
		}else{
			LoopChain insert = new LoopChain(data);
			LoopChain lc = this;
			for(int i=1;i<index;i++){
				lc = lc.next;
			}
			insert.next = lc.next;
			lc.next = insert;
			this.size++;
		}
	}
	/**
	 * 删除结点
	 * @param index
	 */
	public void delete(int index){
		if(index>this.size){
			try{
				throw new OutOfIndexException();
			}catch(OutOfIndexException e){
				e.printStackTrace();
			}
		}else{
			LoopChain lc = this;
			for(int i=1;i<index;i++){
				lc = lc.next;
			}
			lc.next = lc.next.next;
			this.size--;
		}
	}
}
