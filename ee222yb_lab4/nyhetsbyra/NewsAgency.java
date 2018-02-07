package ee222yb_lab4.nyhetsbyra;

import java.util.ArrayList;

public class NewsAgency {

	private static ArrayList<NewsAgency> allAgencies = new ArrayList<>();
	private ArrayList<Newspaper> newspapers = new ArrayList<>();
	private String agencyName;
	
	public NewsAgency(String name) {
		agencyName = name; 
		allAgencies.add(this);
	}
	
	public void addNewspaperToAgency(Newspaper paper) {
		newspapers.add(paper);
	}
	
	public void removeNewspaperFromAgency(Newspaper paper) {
		newspapers.remove(paper);
	}
	
	public String getAgencyName() {
		return agencyName;
	}
	
	public ArrayList<Newspaper> getAllRegisteredPapers() {
		return newspapers;
	}
	
	public static ArrayList<NewsAgency> getAllAgencies() {
		return allAgencies;
	}
	
	/**
	 * Gets all agencies the paper is registered to
	 * @param paper - Newspaper
	 * @return ArrayList<NewsAgency>
	 */
	public static ArrayList<NewsAgency> getAgenciesRegisteredToPaper(Newspaper paper) {
		ArrayList<NewsAgency> registeredAgencies = new ArrayList<>();
		for(NewsAgency agency : allAgencies) {
			if(agency.newspapers.contains(paper))
				registeredAgencies.add(agency);
		}
		return registeredAgencies;
	}
	
	/**
	 * Sends out a request to all of the newspapers belonging to the agency, apart from the sender
	 * @param item - News item
	 * @param sentBy - Newspaper sender
	 */
	public void sendNewsItem(NewsItem item, Newspaper sentBy) {
		for(Newspaper paper : newspapers) {
			if(paper.getID() != sentBy.getID())
				paper.addReceivedNewsItem(item);
		}
	}

}
