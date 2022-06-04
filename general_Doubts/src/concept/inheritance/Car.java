package concept.inheritance;

public class Car extends Vehicle {

	@Override
	public void attachTyres() {
		setTyres(4);
		System.out.println("attaching tyres to car..");
	}

	@Override
	public void fillFuel() {
		setFuel("diesel");
		System.out.println("filling fuel to car..");
	}

}
