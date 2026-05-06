package cineExamen;

public class Movie3D extends Movie {

	private boolean immersiveSound;
	private double priceSupplement;

	public Movie3D(String title, String genre, int duration, int minimumAge, boolean immersiveSound,
			double priceSupplement) throws IllegalArgumentException {
		super(title, genre, duration, minimumAge);
		this.immersiveSound = immersiveSound;
		this.priceSupplement = priceSupplement;
	}

	public boolean isImmersiveSound() {
		return immersiveSound;
	}

	public void setImmersiveSound(boolean immersiveSound) {
		this.immersiveSound = immersiveSound;
	}

	public double getPriceSupplement() {
		return priceSupplement;
	}

	public void setPriceSupplement(double priceSupplement) {
		this.priceSupplement = priceSupplement;
	}

}
