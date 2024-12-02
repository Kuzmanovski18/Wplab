package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventBookingRepository {
    public EventBookingRepository() {
    }

    public void addBooking(EventBooking booking) {
        DataHolder.MyBookings.add(booking);
    }

    public List<EventBooking> listMyBookings() {
        return DataHolder.MyBookings.stream().toList();
    }

    public List<EventBooking> searchEvents(String text) {
        return DataHolder.MyBookings.stream().filter(e -> e.getEventName().contains(text)).toList();
    }
}
