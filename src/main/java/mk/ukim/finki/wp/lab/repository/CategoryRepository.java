package mk.ukim.finki.wp.lab.repository;


import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Category;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    public List<Category> findAll() {
//        return DataHolder.categories.stream().toList();
//    }
//    public Optional<Category> findById(Long id){
//        return DataHolder.categories.stream().filter(category -> category.getId().equals(id)).findFirst();
//    }
}