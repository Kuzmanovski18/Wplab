package mk.ukim.finki.wp.lab.service.impl;


import mk.ukim.finki.wp.lab.model.Category;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import mk.ukim.finki.wp.lab.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.wp.lab.model.exceptions.LocationNotFoundException;
import mk.ukim.finki.wp.lab.repository.CategoryRepository;
import mk.ukim.finki.wp.lab.repository.EventRepository;
import mk.ukim.finki.wp.lab.repository.LocationRepository;
import mk.ukim.finki.wp.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository, CategoryRepository categoryRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Optional<Event> findByName(String name) {
        return eventRepository.findByName(name);
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository. searchEventByName(text);
    }

    @Override
    public List<Event> searchByCategory(String category) {
        return eventRepository.findEventByCategory(category);
    }

    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Long categoryId, Long locationId) {
        // Валидација на Category
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        // Валидација на Location
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));

        Event event = new Event(name, description, popularityScore, category, location);
        // Чување на настан
        return Optional.of(this.eventRepository.save(event));
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}

