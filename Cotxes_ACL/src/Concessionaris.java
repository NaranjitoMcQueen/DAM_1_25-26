import java.util.TreeSet;

public class Concessionaris implements ConcessionariOperacions {

    private String adreça;
    private TreeSet<Vehicles> vehicles = new TreeSet<>();
    private static final int MaxVehicles = 10;

    public Concessionaris(String adreça, TreeSet<Vehicles> vehicles) {
        this.adreça = adreça;
        this.vehicles = vehicles;
    }

    // Implementació dels mètodes de la interfície

    // Adreça
    public String getAdreça() {
        return adreça;
    }


    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    // Vehicles
    public TreeSet<Vehicles> getVehicles() {
        return vehicles;
    }


    public void setVehicles(TreeSet<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public int totalVeh() {
        return vehicles.size();
    }

    // Afegir vehicle
    public boolean afegirVehicle(Vehicles veh) {
        try {
            if (totalVeh() >= MaxVehicles) return false;
            this.vehicles.add(veh);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // Treure vehicle, vehicle
    public boolean treureVehicle(Vehicles veh) {
        return vehicles.remove(veh);
    }


    public Vehicles cercarVehicle(String matricula) {
        for (Vehicles veh : vehicles) {
            if (veh.getMatricula().equals(matricula)) {
                return veh;
            }
        }
        return null;
    }


    public boolean treureVehicleMatricula(String mat) {
        Vehicles veh = cercarVehicle(mat);
        if (veh == null) {
            return false;
        }
        return vehicles.remove(veh);
    }

    // Llista amb instanceof
    public String llistaVehicles() {
        String LlistaCotxes = "Cotxes: ";
        String LlistaMotos = "Motos: ";

        for (Vehicles v : vehicles) {
            if (v instanceof Cotxes) {
                LlistaCotxes = LlistaCotxes + "\nCotxes: " + v.toString();
            } else if (v instanceof Motos) {
                LlistaMotos = LlistaMotos + "\nMotos: " + v.toString();
            }
        }
        return "Llista:\n" + LlistaCotxes + "\n" + LlistaMotos;
    }

    @Override
    public double mitjanaKm() {
        double totalKM = 0;
        for (Vehicles veh : vehicles) {
            totalKM += veh.getKm();
        }
        return totalKM / vehicles.size();
    }

    @Override
    public String toString() {
        return "\nConcessionari:" +
                " Adreça   = " + adreça + vehicles;
    }
}