package ee222yb_lab4.sorter_orter;

public class Ort implements Comparable<Ort> {
	private String city;
	private int zipCode;
	
	public Ort(String stad, int zip) {
		if(zip <= 0 || stad.isEmpty())
			throw new IllegalArgumentException("Cannot create object Ort. Arguments out of range.");
		city = stad;
		zipCode = zip;
	}
	
	public String toString() {
		return zipCode + " " + city;
	}
	
	public int compareTo(Ort ort) {
		if(zipCode == ort.zipCode)
			return city.compareTo(ort.city);
		return zipCode - ort.zipCode;
	}
}
