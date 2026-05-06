package cineExamen;

public class Movie implements Comparable<Movie> {

	protected String title;
	protected String genre;
	protected int duration;
	protected int minimumAge;

	public Movie(String title, String genre, int duration, int minimumAge) throws IllegalArgumentException {
		super();
		this.title = title;
		this.genre = genre;
		if (valDuracio(duration)) {
			this.duration = duration;
		} else
			throw new IllegalArgumentException("La duració es negativa o zero.");
		if (valEdatMin(minimumAge)) {
			this.minimumAge = minimumAge;
		} else
			throw new IllegalArgumentException("L'edat mínima no són vàlides o erroneas.");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public static boolean valDuracio(int duration) {
		if (duration <= 0) {
			return false;
		}
		return true;
	}

	public int getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(int minimumAge) {
		this.minimumAge = minimumAge;
	}

	public static boolean valEdatMin(int minimumAge) {
		if (minimumAge < 0) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", genre=" + genre + ", duration=" + duration + ", minimumAge=" + minimumAge
				+ "]";
	}

	@Override
	public int compareTo(Movie m) {
		return this.title.compareTo(m.title);
	}

}
