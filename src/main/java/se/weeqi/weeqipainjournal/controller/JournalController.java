package se.weeqi.weeqipainjournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.weeqi.weeqipainjournal.entity.Journal;
import se.weeqi.weeqipainjournal.repository.JournalRepository;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
public class JournalController {

    @Autowired
    private JournalRepository repository;

    @GetMapping("/journal/{id}")
    public ResponseEntity<Journal> getJournal(@PathVariable("id") Long id) {
        return repository.findById(id).map(journal -> ResponseEntity.ok().body(journal)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/journal")
    public Journal createJournal(@Valid @RequestBody Journal journal) {
        return repository.save(journal);
    }
}
