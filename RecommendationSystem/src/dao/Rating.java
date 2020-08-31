package dao;

public class Rating implements Comparable<Rating> {
    private String item;
    private double value;

    public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Rating(String item, double value) {
		this.item = item;
		this.value = value;
    }

    public String toString() {
        return "[" + getItem() + ", " + getValue() + "]";
    }

    public int compareTo(Rating other) {
        if (value < other.value) return -1;
        if (value > other.value) return 1;
        return 0;
    }
}
