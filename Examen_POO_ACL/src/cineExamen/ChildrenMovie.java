package cineExamen;

public class ChildrenMovie extends Movie {

	private boolean isAnimated;
	private boolean suitableForAllAges;

	public ChildrenMovie(String title, String genre, int duration, int minimumAge, boolean isAnimated,
			boolean suitableForAllAges) throws IllegalArgumentException {
		super(title, genre, duration, minimumAge);
		this.isAnimated = isAnimated;
		this.suitableForAllAges = suitableForAllAges;
	}

	public boolean isAnimated() {
		return isAnimated;
	}

	public void setAnimated(boolean isAnimated) {
		this.isAnimated = isAnimated;
	}

	public boolean isSuitableForAllAges() {
		return suitableForAllAges;
	}

	public void setSuitableForAllAges(boolean suitableForAllAges) {
		this.suitableForAllAges = suitableForAllAges;
	}

}
