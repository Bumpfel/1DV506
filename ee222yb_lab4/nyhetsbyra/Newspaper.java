package ee222yb_lab4.nyhetsbyra;

import java.util.ArrayList;

public class Newspaper {

	private static int nextID = 0;
	private int id;
	private String name;
	private ArrayList<NewsItem> ownNewsItems = new ArrayList<>();
	private ArrayList<NewsItem> receivedNewsItems = new ArrayList<>();
	private static ArrayList<Newspaper> allNewsPapers = new ArrayList<>();
	
	public Newspaper(String paperName) {
		name = paperName;
		id = nextID ++;
		allNewsPapers.add(this);
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Adds item to the newspapers own "database".
	 * @param item - News item
	 */
	public void addNewsItem(NewsItem item) {
		ownNewsItems.add(item);
	}
	
	/**
	 * Adds news item to the papers received news "database".
	 * @param item - The news item
	 */
	public void addReceivedNewsItem(NewsItem item) {
		receivedNewsItems.add(item);
	}
	
	public ArrayList<NewsItem> getOwnNewsItems() {
		return ownNewsItems;
	}

	/**
	 * Returns a list of news the paper received from the agency
	 * @param agency - The news agency
	 * @return ArrayList<NewsItem>
	 */
	public ArrayList<NewsItem> getReceivedNewsItemsFromAgency(NewsAgency agency) {
		ArrayList<NewsItem> newsFromAgency = new ArrayList<>();
		
		for(NewsItem item : receivedNewsItems) {
			Newspaper sender = item.getOrigin();
			if(agency.getAllRegisteredPapers().contains(sender))
				newsFromAgency.add(item);
		}
		return newsFromAgency;
	}
	
}
