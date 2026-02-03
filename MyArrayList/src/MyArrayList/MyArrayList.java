package MyArrayList;


public class MyArrayList {
	
	/*
	 * Fes una classe MyArrayList a Java. Crea la teva pròpia classe ArrayList, crea
	 * els mètodes add, get, remove, getPos, length, getSize, toString. El main de
	 * proves és el que hi ha adjunt a la tasca.
	 */
	
	private int length;
	private String[] array;
	private int pos;

	public MyArrayList() {
		this.length = 10;
		this.array = new String [length];
		this.pos = 0;
	}

	public MyArrayList(int i) {
		this.length = 10;
		this.array = new String [length];
		this.pos = 0;
	}

	// Add afegeix a l'útlima posició
	public boolean add(String st) {
		array[pos] = st;
		pos++;
		return true;
	}
	
	// Remove elimina l'última posició
	public boolean remove(String st) {
		array[pos] = st;
		pos--;
		return true;
	}
	
	// Length retorna el TOTAL del String
	public int length() {
		return N;
	}
	
	// Size retorna el tamany utilitzat
	public int getSize() {
		return pos;
	}

	// Setter i getter de la longitud
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	// Setter i getter del array
	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	// Setter i getter de posició
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
	

}