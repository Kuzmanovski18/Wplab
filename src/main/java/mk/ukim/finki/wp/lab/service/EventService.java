package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Category;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();

    Optional<Event> findById(Long id);

    Optional<Event> findByName(String name);

    List<Event> searchEvents(String text);

    List<Event> searchByCategory(String category);

    List<Event> searchByLocation(String address);

    Optional<Event> save(String name, String description, double popularityScore, Long categoryId, Long locationId);

    void deleteById(Long id);

}
