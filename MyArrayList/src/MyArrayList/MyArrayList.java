package MyArrayList;

import java.util.Arrays;

public class MyArrayList {

	/*
	 * Fes una classe MyArrayList a Java. Crea la teva pròpia classe ArrayList, crea
	 * els mètodes add, get, remove, getPos, length, getSize, toString. El main de
	 * proves és el que hi ha adjunt a la tasca.
	 */

	private int length;
	private String[] array;
	private int pos;

	// CONSTRUCTORS
	public MyArrayList() {
		this.length = 10;
		this.array = new String[length];
		this.pos = 0;
	}

	public MyArrayList(int length) {
		this.length = length;
		this.array = new String[length];
		this.pos = 0;
	}

	// Add afegeix a l'útlima posició
	public boolean add(String st) {
		if (pos <= length - 1) {
			array[pos] = st;
			pos++;
		} else {
			length = length * 2;
			String[] nouArray = new String[length];
			String[] auxArray;
			auxArray = array;
			for (int i = 0; i < length / 2; i++) {
				nouArray[i] = auxArray[i];
			}
			this.array = nouArray;
		}
		return true;
	}

	public void add(int i, String string) {
		if (pos <= length - 1) {
			array[pos] = string;
			pos++;
		} else {
			length = length * 2;
			String[] nouArray = new String[length];
			String[] auxArray;
			auxArray = array;
			for (i = 0; i < length / 2; i++) {
				nouArray[i] = auxArray[i];
			}
			this.array = nouArray;
		}
	}

	// Remove elimina l'última posició
	public int remove(String st) {
		for (int i = 0; i < length; i++) {
			if (array[i] == st) {
				pos--;
				return i;
			}
		}
		return -1;
	}

	public String remove() {
		String aux = array[pos - 1];
		pos--;
		return aux;
	}

	public String remove(int index) {
		if (index > length) {
			return null;
		}
		for (int i = 0; i < length; i++) {
			if (i == index) {
				pos--;
				return array[i];
			}
		}
		return null;
	}

	// Setter i getter de la longitud
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	// Length retorna el TOTAL del String
	public int length() {
		return length;
	}

	// Setter i getter del array
	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	// Setter i getter de posició
	public int getPos(String posi) {
		for (int i = 0; i < this.getSize(); i++) {
			if (array[i] != null && array[i] == posi) {
				return i;
			}
		}
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String get(int index) {
		if (index < length && index >= 0) {
			return this.array[index];
		}
		return null;
	}
	
	public void set(int i, String string) {	
		
	}

	// Size retorna el tamany utilitzat
	public int getSize() {
		return pos;
	}

	@Override
	public String toString() {
		return "MyArrayList [length=" + length + ", array=" + Arrays.toString(array) + ", pos=" + pos + "]";
	}
}