package MyArrayList;

public class MyArrayList {

	String[] array = new String[10];
	int pos = 0;
	
	public boolean add(String st) {
		array[pos] = st;
		pos++;
		return true;
	}
	
	
}