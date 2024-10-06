import vehicleType.Vehicle;
import vehicleType.VehicleType;

public class ParkingSpot {

    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;


    public ParkingSpot (int spotNumber, VehicleType vehicleType){
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailble(){
        return parkedVehicle == null;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        if(isAvailble() && vehicle.getType() == vehicleType){
            parkedVehicle = vehicle;
            return true;
        }
        else {
            throw new IllegalArgumentException("Wrong vehicle type or Parking not available!");
        }
    }

    public synchronized void unparkVehicle(){
        parkedVehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
