package problem2;

import java.util.Arrays;

public class MyPersoList {
	private final int INITIAL_LENGTH = 4;
	private Person[] strArray; 
	private int size;
	
	public MyPersoList() {
		strArray = new Person[INITIAL_LENGTH];
		size = 0;
	}
	// Add element in last
	public void add(Person s){
		if(size == strArray.length) resize();
		strArray[size++] = s;
	}
	
	public Person get(int i){
		if(i < 0 || i >= size){
			return null;
		}
		return strArray[i];
	}
	
	public boolean find(String lastName)
	{
		for(Person test : strArray)
		{
			if(test.getLast().equals(lastName)) 
			{
				return true;	
			}
		}
		return false;
	}
	
	/*public void insert(String s, int pos){
		if(pos > size) return;
		if(pos == strArray.length||size+1 > strArray.length) {
			resize();
		}
		String[] temp = new String[strArray.length+1];
		System.arraycopy(strArray,0,temp,0,pos);
		temp[pos] = s;
		
		System.arraycopy(strArray,pos,temp,pos+1, strArray.length - pos);
		strArray = temp;
		++size;
	}*/
	
	 public void insert(Person s, int pos)
	 {
	 if(pos<0 || pos > size) 
		 {
		 	return;
		 }
		if(pos == strArray.length||size+1 > strArray.length)
		{
			this.resize();
		}
		
		Person[] temp = new Person[strArray.length+1];
		
       for(int i = 0; i < pos; i++)
        {
    	   temp[i] = strArray[i];
        }
       
    temp[pos] = s;
    for(int i = pos + 1; i < strArray.length; i++)
    {
    	temp[i] =strArray[i - 1];
    }
    strArray = temp;
		++size;
}
	
	public boolean remove(Person s){
		if(size == 0) {
			return false;
		}
		int index = -1;
		for(int i = 0; i < size; ++i )
		{
			if(strArray[i].equals(s)){
				index = i;
				break;
			}
		}
		if(index==-1) {
			return false;
		}
		Person[] temp = new Person[strArray.length];
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
		Person[] temp = new Person[newlen];
		System.arraycopy(strArray,0,temp,0,len);
                // strArray = Arrays.copyOf(strArray, newlen);
		strArray = temp;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < size-1; ++i){
			sb.append(strArray[i]+", ");
		}
		sb.append(strArray[size-1]+"]\n");
		return sb.toString();
	}
	public int size() {
		return size;
	}
	public boolean isEmpty(){
		return(size==0);
	}
    public Object clone()
    {
    	Person[] temp = Arrays.copyOf(strArray, size);
    	return temp;
    	
    }
		public static void main(String[] args) {
			MyPersoList l = new MyPersoList();
			String last = "Mosquera";
			String person_to_find = "Torrijos";
			
			
			
			l.add(new Person(last, "Bob", 21));
			l.add(new Person(last, "Steve", 13) );
			l.add(new Person(last, "Susan", 19) );
			l.add(new Person(last, "Mark", 43) );
			l.insert(new Person("Torrijos", "Renuka", 11) , 4);
			System.out.println(l);
			l.add(new Person(last, "Dave", 15) );
			System.out.println("The list of size "+l.size()+" is "+l);
			l.remove(new Person(last, "Mark", 18) );
			l.remove(new Person(last, "Bob", 28)  );
			System.out.println("The list of size "+l.size()+" is "+l);
			l.insert(new Person(last, "Richard", 28) ,3);
			System.out.println("The list of size "+l.size()+" after inserting Richard into pos 3 is "+l);
			l.insert(new Person(last, "Tonya", 78) ,0);
			System.out.println("The list of size "+l.size()+" after inserting Tonya into pos 0 is "+l);		
			Person[] x = (Person[]) l.clone();
            System.out.println(Arrays.toString(x));
            
            /// well we now to find a person using method find 
            
            System.out.printf("Anybody with Last name %s is on our database %s  \n",person_to_find, ( l.find(person_to_find) ? "Yes" : "No") );
	}

}
