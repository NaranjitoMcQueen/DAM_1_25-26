package vehiclesBase;

import java.util.*;

public class MainProves {

    public static void main(String[] args) {

        System.out.println("===== INICI PROVES CONCESSIONARI =====\n");

        // Crear concessionari
        Concessionari concessionari = new Concessionari("Calle Mayor 123");

        // ==============================
        // PROVA VALIDACIÓ CONSTRUCTORS
        // ==============================
        try {
            Cotxe cInvalid = new Cotxe("1234","Tesla", "Model 3", "Blanco", 15200, 5, true);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en les dades: " + e.getMessage());
        }

        //Moto mInvalida = new Moto("1878-KRT", "Triumph", "Rocket 3 R", "Sapphire Black", -500, 2458, "Muscle Roadster");

        // ==============================
        // CREAR VEHICLES VÀLIDS
        // ==============================

        Cotxe cotxe1 = new Cotxe("1111FFF", "Toyota", "Corolla", "Rojo", 25000, 5, false);
        Cotxe cotxe2 = new Cotxe("2222BBB", "BMW", "Serie 3", "Negro", 80000, 3, true);
        Moto moto1 = new Moto("3333CCC", "Honda", "CB125", "Blanco", 10000, 125, "Urbana");
        Moto moto2 = new Moto("4444DDD", "Kawasaki", "Z900", "Verde", 60000, 900, "Deportiva");

        // ==============================
        // AFEGIR VEHICLES
        // ==============================

        System.out.println(concessionari.afegirVehicle(cotxe1));   //true
        System.out.println(concessionari.afegirVehicle(cotxe2));   //true
        System.out.println(concessionari.afegirVehicle(moto1));    //true
        System.out.println(concessionari.afegirVehicle(moto2));    //true

        System.out.println("Vehicles afegits correctament.");

        // Intentar afegir duplicat
        boolean duplicat = concessionari.afegirVehicle(cotxe1);
        if (!duplicat) {
            System.out.println("No es permeten matrícules repetides");
        }

        // ==============================
        // MOSTRAR VEHICLES
        // ==============================

        System.out.println("\n===== LLISTAT VEHICLES =====");
        concessionari.mostrarVehicles();
/*
        // ==============================
        // QUANTITAT DE VEHICLES
        // ==============================

        System.out.println("\nQuantitat total de vehicles: " + concessionari.nombreVehicles());

        // ==============================
        // CÀLCUL DE DESCOMPTES
        // ==============================

        System.out.println("\n===== DESCOMPTES =====");

        System.out.println("Descompte cotxe1 (manual 25.000 km): " + cotxe1.calcularDescompte() + "%");
        System.out.println("Descompte cotxe2 (automático 80.000 km): " + cotxe2.calcularDescompte() + "%");
        System.out.println("Descompte moto1 (125cc 10.000 km): " + moto1.calcularDescompte() + "%");
        System.out.println("Descompte moto2 (900cc 60.000 km): " + moto2.calcularDescompte() + "%");

        // ==============================
        // MITJANA DE KILOMETRATGE
        // ==============================

        System.out.println("\nMitjana de km del concessionari: " + concessionari.mitjanaKm()+"\n");

        // ==============================
        // ELIMINAR VEHICLE
        // ==============================

        boolean res = concessionari.eliminarVehicle(cotxe2);
        if (res) System.out.println("Eliminat cotxe2");
        else System.out.println("No s'ha pogut eliminar cotxe2");

        res = concessionari.eliminarVehicle(cotxe2);  // Ja no hi és, perquè s'ha eliminat abans
        if (res) System.out.println("Eliminat cotxe2");
        else System.out.println("No s'ha pogut eliminar cotxe2");
        
        System.out.println("Quantitat de vehicles: " + concessionari.nombreVehicles());

        System.out.println("\n===== LLISTAT VEHICLES =====");
        concessionari.mostrarVehicles();

        System.out.println();
        // Eliminar per matrícula
        res = concessionari.eliminarVehicle("3333CCC");
        if (res) System.out.println("Eliminat vehicle 3333CCC");
        else System.out.println("No s'ha pogut eliminar vehicle 3333CCC");
        
        res = concessionari.eliminarVehicle("7777CCC");
        if (res) System.out.println("Eliminat vehicle 7777CCC");
        else System.out.println("No s'ha pogut eliminar vehicle 7777CCC");
        
        System.out.println("\n===== LLISTAT FINAL =====");
        concessionari.mostrarVehicles();
        
        System.out.println("\n===== FI PROVES =====");*/
    }
}