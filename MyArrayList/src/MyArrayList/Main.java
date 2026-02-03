
public class Main {

	public static void main(String[] args) {
		MyArrayList l1 = new MyArrayList();
		MyArrayList l2 = new MyArrayList(10);

		System.out.println("Length l1: " + l1.length());
		System.out.println("Length l2: " + l2.length());
		/* length() devuelve el tamaño total del array */

		/* getSize() devuelve el tamaño utilizado */
		l1.add("Juan");
		l1.add("Maria");
		System.out.println(l1);
		System.out.println("Length l1 = " + l1.getSize());

		l2.add("rojo");
		l2.add("verde");
		l2.add("azul");
		l2.add("negro");
		l2.add("morado");
		l2.add(1, "amarillo");
		l2.set(1, "naranja");
		// l2.ordena();

		System.out.println(l2);
		System.out.println("Length l2 = " + l2.getSize());

		System.out.println("Pos 2: " + l2.get(2));
		System.out.println("verde: " + l2.getPos("verde"));

		// Borra el último
		String deletedElement = l2.remove();
		System.out.println("He borrado " + deletedElement);
		System.out.println(l2);

		// Borra el color verde
		int posDeleted = l2.remove("verde");
		System.out.println("He borrado el " + posDeleted);
		System.out.println(l2);

		// Borrar el color en la posición 2
		String st = l2.remove(2);
		System.out.println("He borrado " + st);

		// Buscar el elemento en la posición 9
		String elem = l2.get(9);
		if (elem == null)
			System.out.println("No encontrado");
		else
			System.out.println("Pos 9: " + elem);

		// Buscar el color gris
		if (l2.getPos("gris") == -1) {
			System.out.println("No encontrado");
		} else
			System.out.println("gris: " + l2.getPos("gris"));

		// Borrar el color gris
		posDeleted = l2.remove("gris");
		System.out.println(posDeleted);
		if (posDeleted == -1)
			System.out.println("No encontrado");
		else
			System.out.println("gris eliminado en pos " + posDeleted);

		// Borrar el color en la posición 9
		int pos = 9;
		st = l2.remove(pos);
		if (st == null)
			System.out.println("No encontrado");
		else
			System.out.println("He borrado " + st);

	}

}