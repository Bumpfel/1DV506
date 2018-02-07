package ee222yb_lab4.nyhetsbyra;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class NewsItem {

	private String timeStamp;
	private Newspaper origin;
	private String title;
	private String content;
	private static ArrayList<NewsItem> allItems = new ArrayList<>();
	
	public NewsItem(Newspaper sender, String headline, String body) {
		origin = sender;
		title = headline;
		content = body;
		timeStamp = new SimpleDateFormat("yyyyMMd HH:mm:ss").format(Calendar.getInstance().getTime());
		allItems.add(this);
		
		// Adds this item to the papers own "database"
		sender.addNewsItem(this);
		
		// Sends this item to all of the agencies the paper is registered to
		ArrayList<NewsAgency> paperBelongsTo = NewsAgency.getAgenciesRegisteredToPaper(sender);
		for(NewsAgency agency : paperBelongsTo) {
			agency.sendNewsItem(this, sender);
		}
	}

	public static ArrayList<NewsItem> getAllItems() {
		return allItems;
	}
	public Newspaper getOrigin() {
		return origin;
	}
	
	public String toString() {
		return "-" + title + "\n\""+ content + "\"\nsent by " + origin.getName() + " on " + timeStamp;
	}
}
