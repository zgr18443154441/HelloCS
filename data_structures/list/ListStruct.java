package data_structures.list;

import self_exception.ElemNotFoundException;
import self_exception.OutOfIndexException;

/**
 * 可扩容的线性表
 * @author 张国荣
 *
 */
public class ListStruct {
	private Object[] list;
	private int size;
	private int index;
	/**无参数默认初始化长度*/
	private final int DEFAULT_SIZE = 5;
	/**扩容时暂存数据容器*/
	private Object[] temp_list;
	
	/**
	 * 有参初始化
	 * @param size
	 */
	public ListStruct(int size){
		this.size = size;
		this.list = new Object[size];
		this.index = 0;
	}
	
	/**
	 * 有值初始化
	 * @param list
	 */
	public ListStruct(Object[] list){
		this.size = list.length*2;
		this.index = list.length;
		this.list = new Object[this.size];
		for(int i=0;i<list.length;i++){
			this.list[i] = list[i];
		}
	}
	
	/**
	 * 无参初始化
	 */
	public ListStruct(){		
		this.list = new Object[DEFAULT_SIZE];
		this.size = this.DEFAULT_SIZE;
		this.index = 0;
	}
	
	/**
	 * 重写toString方法
	 */
	public String toString(){
		StringBuffer stringBuffer = new StringBuffer().append("[");
		for(int i=0;i<this.index;i++){
			stringBuffer.append(this.list[i].toString()).append(",");
		}
		stringBuffer.deleteCharAt(stringBuffer.length()-1).append("]");
		return stringBuffer.toString();
	}
	
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return this.index==0;
	}
	
	/**
	 * 计算数组长度
	 * @return
	 */
	public int size(){
		return this.size;
	}
	
	/**
	 * 计算数组最大索引
	 * @return
	 */
	public int max_index(){
		return this.index-1;
	}
	
	/**
	 * 判断是否已满
	 * @return
	 */
	public boolean isFull(){
		return this.index==this.size;
	}
	
	/**
	 * 扩容
	 */
	public void enlarge(){
		this.temp_list = this.list.clone();
		this.list = new Object[this.size*2];
		this.size*= 2;
		for(int i=0;i<this.temp_list.length;i++){
			this.list[i] = this.temp_list[i];
		}
		this.temp_list = null;
	}
	
	/**
	 * 清空
	 */
	public void clean(){
		for(int i=0;i<this.index;i++){
			this.list[i] = null;
		}
		this.index = 0;
	}
	
	/**
	 * 返回某个位置的元素
	 * @param index
	 * @return
	 */
	public Object getElem(int index){
		return this.list[index];
	}
	
	/**
	 * 索引元素赋值
	 * @param index
	 * @param obj
	 */
	public void setElem(int index,Object obj){
		this.list[index] = obj;
	}
	
	/**
	 * 查找与某元素相同的位置
	 * @param obj
	 * @return
	 */
	public int[] localElem(Object obj){
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<this.index;i++){
			if(this.list[i].equals(obj)){
				stringBuffer.append(i);
			}
		}
		String[] temp = stringBuffer.toString().split("");
		int[] answer = new int[temp.length];
		for(int i=0;i<temp.length;i++){
			answer[i] = Integer.parseInt(temp[i]);
		}
		return answer;
	}
	
	/**
	 * 数组添加
	 * @param obj
	 */
	public void listAdd(Object obj){
		if(this.isFull())this.enlarge();
		this.list[this.index] = obj;
		this.index++;
	}
	
	/**
	 * 数组插入
	 * @param obj
	 * @param index
	 */
	public void listInsert(Object obj,int index){
		if(index>this.size){
			try {
				throw new OutOfIndexException();
			} catch (OutOfIndexException e) {
				e.printStackTrace();
			}
		}else{			
			if(this.isFull())this.enlarge();
			for(int i=this.index;i>index;i--){
				this.list[i] = this.list[i-1];
			}
			this.list[index] = obj;
			this.index++;
		}
	}
	
	/**
	 * 数组索引删除
	 * @param index
	 */
	public void listIndexDelete(int index){
		if(index>this.index-1){
			try {
				throw new OutOfIndexException();
			} catch (OutOfIndexException e) {
				e.printStackTrace();
			}
		}else{
			for(int i=index;i<this.index-1;i++){
				this.list[i] = this.list[i+1];
			}
			this.list[this.index-1] = null;
			this.index--;
		}
	}
	
	/**
	 * 数组元素删除
	 * @param obj
	 */
	public void listObjectDelete(Object obj){
		boolean notfound = true;
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<this.index;i++){
			if(obj.equals(this.list[i])){
				notfound = false;
				stringBuffer.append(i).append(",");
			}
		}
		if(notfound){
			try {
				throw new ElemNotFoundException();
			} catch (ElemNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			stringBuffer.deleteCharAt(stringBuffer.length()-1);
			for(String index: stringBuffer.toString().split(",")){
				this.list[Integer.parseInt(index)] = null;
			}
			temp_list = new Object[this.size];
			this.index = 0;
			for(Object e : this.list){
				if(e!=null){
					temp_list[this.index] = e;
					this.index++;
				}
			}
			this.list = this.temp_list.clone();
		}
	}
}
