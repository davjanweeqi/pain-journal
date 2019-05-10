package se.weeqi.weeqipainjournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.weeqi.weeqipainjournal.entity.Journal;
import se.weeqi.weeqipainjournal.repository.JournalRepository;

import javax.validation.Valid;

@RestController
//@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class JournalController {

    @Autowired
    private JournalRepository repository;

    @GetMapping("/getJournal")
    public ResponseEntity<Journal> getJournal() {
        return repository.findById(Integer.toUnsignedLong(1)).map(journal -> ResponseEntity.ok().body(journal)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/putJournal")
    public Journal createJournal(@Valid @RequestBody Journal journal) {
        return repository.save(journal);
    }
}
