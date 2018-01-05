import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.firebase.client.Firebase;

public class Main {

	public static void main(String[] args) {
		Document page = null;
        Firebase fire = new Firebase("https://tales-of-courage.firebaseio.com");
        fire.setValue(2);
        List<Dog> dogList = new ArrayList<Dog>();
        String url = "https://fpm.petfinder.com/petlist/petlist.cgi?shelter=CT403&status=A&age=&limit=50&offset=0&animal=Dog&title=Currently%20looking%20for%20their%20furever%20home!&style=15&ref=i8X6W89Z3QyyxiI";
		try {
			page = Jsoup.connect(url).timeout(10*1000).userAgent("Mozilla").get();
		} catch (IOException e) {
			System.out.println("Cannot connect to website");
			e.printStackTrace();
		}
		ArrayList<String> urls = new ArrayList<String>();
		Elements picElements = page.select(".pic");
        Elements media = page.select("[src]");
		Elements nameElements = page.select(".name");
		Elements ageElements = page.select(".age");
		Elements breedElements = page.select(".breed");
		Elements sizeElements = page.select(".size");
		for(int i = 0; i < media.size(); ++i){
			if(media.get(i).toString().contains("img")){
				System.out.println(media.get(i).toString().substring(12, media.get(i).toString().indexOf("&")));
				urls.add(media.get(i).toString().substring(12, media.get(i).toString().indexOf("&")));
			}
		}
		for(int i = 0; i < picElements.size();++i){
			dogList.add(new Dog( urls.get(i) ,  nameElements.get(i).text()   ,  ageElements.get(i).text()  , breedElements.get(i).text(), sizeElements.get(i).text().substring(0, sizeElements.get(i).text().length() - 1)));
		}
		/*
		System.out.println(nameElements.get(0).text()); //works
		System.out.println(ageElements.get(0).text()); //works
		System.out.println(breedElements.get(0).text()); //works
		System.out.println(picElements.get(0).attr("src")); 
		*/
		fire.setValue(dogList);
		System.out.println("added to DB");
	}
}


