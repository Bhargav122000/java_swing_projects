package concept.inheritance;

public class TestVehicle {

	public static void main(String[] args) {
		Vehicle vehicle = new Car();
		vehicle.applyBrakes();
		vehicle.attachTyres();
		vehicle.fillFuel();
		System.out.println(vehicle.getClass());
		System.out.println(vehicle.getTyres());
		System.out.println(vehicle.getFuel());
		
		System.out.println();
		
		vehicle = new Bike();
		vehicle.applyBrakes();
		vehicle.attachTyres();
		vehicle.fillFuel();
		System.out.println(vehicle.getClass());
		System.out.println(vehicle.getTyres());
		System.out.println(vehicle.getFuel());
	}

}
