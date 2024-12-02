package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Category;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.EventBooking;
import mk.ukim.finki.wp.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class DataHolder {
    public static final List<Event> events = new ArrayList<>(10);
    public static final List<EventBooking> MyBookings = new ArrayList<>();
    public static final List<Category> categories = new ArrayList<>();
    public static final List<Location> locations = new ArrayList<>();

    public DataHolder() {
        //Categories
        categories.add(new Category((long) (Math.random() * 1000),"Gaming"));
        categories.add(new Category((long) (Math.random() * 1000),"Science"));
        categories.add(new Category((long) (Math.random() * 1000),"Literature"));
        categories.add(new Category((long) (Math.random() * 1000),"Food"));
        categories.add(new Category((long) (Math.random() * 1000),"Fashion"));
        categories.add(new Category((long) (Math.random() * 1000),"Travel"));

        //Locations
        locations.add(new Location("Times Square",(long) (Math.random() * 1000)));
        locations.add(new Location("Outdoor Park",(long) (Math.random() * 1000)));
        locations.add(new Location("Grand Canyon",(long) (Math.random() * 1000)));
        locations.add(new Location("Conference Hall A",(long) (Math.random() * 1000)));
        locations.add(new Location("Hollywood Boulevard",(long) (Math.random() * 1000)));
        locations.add(new Location("Santorini Island",(long) (Math.random() * 1000)));
        locations.add(new Location("Great Wall of China",(long) (Math.random() * 1000)));
        locations.add(new Location("City Theater",(long) (Math.random() * 1000)));
        locations.add(new Location("Hotel Ballroom",(long) (Math.random() * 1000)));
        locations.add(new Location("Beachfront Event Space",(long) (Math.random() * 1000)));

        //Events
        events.add(new Event((long) (Math.random() * 1000),"E3 Expo", "Video game exhibition", 9, categories.get(0), locations.get(0)));
        events.add(new Event((long) (Math.random() * 1000),"Science Fair", "Exhibition of science projects", 8, categories.get(1), locations.get(1)));
        events.add(new Event((long) (Math.random() * 1000),"Book Fair", "International book fair", 7, categories.get(2), locations.get(2)));
        events.add(new Event((long) (Math.random() * 1000),"Food Festival", "Gourmet food festival", 10, categories.get(3), locations.get(3)));
        events.add(new Event((long) (Math.random() * 1000),"Fashion Week", "Runway fashion show", 9, categories.get(4), locations.get(4)));
        events.add(new Event((long) (Math.random() * 1000),"Travel Expo", "Travel exhibition", 8, categories.get(5), locations.get(5)));
        events.add(new Event((long) (Math.random() * 1000),"Comic Gaming Fest", "Gaming and comic festival", 10, categories.get(0), locations.get(6)));
        events.add(new Event((long) (Math.random() * 1000),"Astronomy Night", "Stargazing and astronomy talks", 8, categories.get(1), locations.get(7)));
        events.add(new Event((long) (Math.random() * 1000),"Poetry Slam", "Live poetry competition", 7, categories.get(2), locations.get(8)));
        events.add(new Event((long) (Math.random() * 1000),"Wine & Dine", "Culinary and wine tasting event", 9, categories.get(3), locations.get(9)));

    }
}
