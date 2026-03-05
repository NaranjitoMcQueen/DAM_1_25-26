public interface ConcessionariOperacions {

    // Mètodes de la interfície
    int totalVeh();
    
    boolean afegirVehicle(Vehicles veh);

    Vehicles cercarVehicle(String matricula);
    boolean treureVehicle(Vehicles veh);
    boolean treureVehicleMatricula(String mat);
    
    String llistaVehicles();
    
    double mitjanaKm();
}