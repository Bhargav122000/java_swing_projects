package concept.inheritance;

public abstract class Vehicle {
	private int tyres;
	private String fuel;

	public int getTyres() {
		return tyres;
	}

	public void setTyres(int tyres) {
		this.tyres = tyres;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public void applyBrakes() {
		System.out.println("brakes applied..");
	}

	public abstract void attachTyres();

	public abstract void fillFuel();
}
