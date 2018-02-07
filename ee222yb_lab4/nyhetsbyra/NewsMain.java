package ee222yb_lab4.nyhetsbyra;

public class NewsMain {

	public static void main(String[] args) {
		NewsAgency reuters = new NewsAgency("Reuters");
		NewsAgency tt = new NewsAgency("TT");
		new NewsAgency("An impopular news agency");
		
		// Creating some newspapers and adds them to agencies
		Newspaper svt = new Newspaper("SVT");
		reuters.addNewspaperToAgency(svt);
		tt.addNewspaperToAgency(svt);
		
		Newspaper dn = new Newspaper("Dagens nyheter");
		reuters.addNewspaperToAgency(dn);
		
		Newspaper aftonbladet = new Newspaper("Aftonbladet");
		reuters.addNewspaperToAgency(aftonbladet);
		
		Newspaper tv4 = new Newspaper("TV4");
		tt.addNewspaperToAgency(tv4);
		
		// Creates some news items
		new NewsItem(dn, "Nordkorea utfor karnvapentester", "text text text text \ntext text text text");
		new NewsItem(svt, "Svenska folket vill ha GW som julvard", "text text text text \ntext text text text");
		
		// Lists all of the sent news items
		System.out.println("---### Sent news ###---\n");
		for(NewsItem item : NewsItem.getAllItems()) {
				System.out.println(item.toString() + "\n");
		}
		System.out.println();
		
		// List all news agencies
		for(NewsAgency agency : NewsAgency.getAllAgencies()) {
			System.out.println("----#### NEWSAGENCY: " + agency.getAgencyName() + " ####----\n");
			
			if(agency.getAllRegisteredPapers().size() == 0) {
				System.out.println("No newspapers registered with the agency");
			}
			else {
				// Lists all newspapers in the agency and all of their received news items from the agency
				for(Newspaper paper : agency.getAllRegisteredPapers()) {
					System.out.println("==>> " + paper.getName() + "s received news from " + agency.getAgencyName() + " <<==");
					
					if(paper.getReceivedNewsItemsFromAgency(agency).size() == 0)
						System.out.println("No received news from " + agency.getAgencyName() + "\n");
					
					for(NewsItem item : paper.getReceivedNewsItemsFromAgency(agency)) {
						System.out.println(item.toString() + "\n");
					}
				}
				System.out.println();
			}
		}
	}

}
