package problem1;

public class MyStringList {
	private final int INITIAL_LENGTH = 4;
	private String[] strArray; 
	private int size;
	
	public void sort(){
		if(this.strArray == null || this.strArray.length <=1) {
			return;
		}
		int len = this.strArray.length;
		int temp = 0;
		for(int i = 0; i < len; ++i){
			int nextMinPos = minpos(i,len-1);
			swap(i,nextMinPos); 
		}
		
	}
	void swap(int i, int j)
	{
		String temp = this.strArray[i];
		this.strArray[i] = this.strArray[j];
		this.strArray[j] = temp;
		
	}
	//find minimum of arr between the indices bottom and top
	public int minpos(int bottom, int top)
	{		
		String m = this.strArray[bottom];
		int index = bottom;
		for(int i = bottom+1; i <= top; ++i)
		{
			
			if (this.strArray[i]!=null)
			{
				if(this.strArray[i].compareTo(m)<0)
				{ 
					m = this.strArray[i];
					index = i;
				}
			}
			
			
		}
		//return location of min, not the min itself
		return index;
	}
	
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(String s){
		if(size == strArray.length) resize();
		strArray[size++] = s;
	}
	
	public String get(int i){
		if(i < 0 || i >= size){
			return null;
		}
		return strArray[i];
	}
	
	public boolean find(String s){
		for(String test : this.strArray)
		{
			
			
			if (test  != null)
			
			{
				//System.out.printf("%s -- %s -- %s \n",test,s,test.equals(s));
				if(test.equals(s))
				{
					return true;
				}
			}
			
		}
		return false;
	}
	
	public void insert(String s, int pos){
		if(pos > size) return;
		if(pos >= strArray.length||size+1 > strArray.length) {
			resize();
		}
		String[] temp = new String[strArray.length+1];
		System.arraycopy(strArray,0,temp,0,pos);
		temp[pos] = s;
		
		System.arraycopy(strArray,pos,temp,pos+1, strArray.length - pos);
		strArray = temp;
		++size;
		
	}
	
	public boolean remove(String s){
		if(size == 0) return false;
		int index = -1;
		for(int i = 0; i < size; ++i ){
			if(strArray[i].equals(s)){
				index = i;
				break;
			}
		}
		if(index==-1) return false;
		String[] temp = new String[strArray.length];
		System.arraycopy(strArray,0,temp,0,index);
		System.arraycopy(strArray,index+1,temp,index,strArray.length-(index+1));
		strArray = temp;
		--size;
		return true;
	}
	
	
	private void resize(){
		System.out.println("resizing");
		int len = strArray.length;
		int newlen = 2*len;
		String[] temp = new String[newlen];
		System.arraycopy(strArray,0,temp,0,len);
		strArray = temp;
	}
	
	boolean recurse(int a, int b, String val) {
		int mid = (a+b)/2;
		
		if(this.strArray[mid].compareTo(val)==0) 
		{
			return true;
		}
		
		if(a > b) {
			return false;
		}
		
		if(this.strArray[mid].compareTo(val)>=1) 
		{
			return recurse(mid+1, b, val);
		}
		return recurse(a,mid-1,val);
	}
		//search a sorted array
		boolean search(String val) {
			boolean b = recurse(0,this.strArray.length-1, val);
			return b;
		}
		
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < size-1; ++i){
			sb.append(strArray[i]+", ");
		}
		sb.append(strArray[size-1]+"]");
		return sb.toString();
	}
	public int size() {
		return size;
	}

	public static void main(String[] args){
		String[] datainit= {"big", "small", "tall", "short", "round", "square",
		 "enormous", "tiny","gargantuan", "lilliputian",
		 "numberless", "none", "vast", "miniscule"};
				 
		MyStringList l = new MyStringList();
		for (String string : datainit) {
			l.add(string);
			
		}
		System.out.println("Solution point A");
		System.out.println(l);
		System.out.println("done");
		System.out.println("Solution point B");
		String[] databaseSearch= {"number","tiny"};
		
		l.sort();	
		for (String string : databaseSearch) {
			System.out.printf("Well we ask to database if '%s'  exits or not db , and result is %s \n",string , (l.find(string) ? "Yes" : "No"  ) );
			
		}
		System.out.println("Done");
		
		
				
	}

}
