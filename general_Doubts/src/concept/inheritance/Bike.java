package concept.inheritance;

public class Bike extends Vehicle {

	@Override
	public void attachTyres() {
		setTyres(2);
		System.out.println("attaching tyres to bike..");
	}

	@Override
	public void fillFuel() {
		setFuel("petrol");
		System.out.println("filling fuel to bike..");
	}

}
