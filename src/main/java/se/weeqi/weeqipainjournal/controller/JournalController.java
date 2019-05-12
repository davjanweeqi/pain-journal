package se.weeqi.weeqipainjournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.weeqi.weeqipainjournal.entity.Journal;
import se.weeqi.weeqipainjournal.repository.JournalRepository;

import java.util.List;
import java.util.Optional;

@RestController

public class JournalController {

    @Autowired
    private JournalRepository repository;

    @GetMapping("/getJournals")
    @ResponseStatus(HttpStatus.OK)
    public List<Journal> getJournals() {
        return repository.findAll();
    }

    @GetMapping("/getJournal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Journal> putJournal(@PathVariable("id") int id) {
        return repository.findById(id);
    }

    @PutMapping("/createJournal/{id}/{pain}/{owner}/{notes}")
    @ResponseStatus(HttpStatus.CREATED)
    public Journal putCompleteJournal(
            @PathVariable("id") int id,
            @PathVariable("pain") int pain,
            @PathVariable("owner") String owner,
            @PathVariable("notes") String notes) {

        return repository.save(createJournal(id, pain, owner, notes));
    }

    @PutMapping("/createJournal/{id}/{pain}/{owner}")
    @ResponseStatus(HttpStatus.OK)
    public Journal putJournal(
            @PathVariable("id") int id,
            @PathVariable("pain") int pain,
            @PathVariable("owner") String owner) {

        return repository.save(createJournal(id, pain, owner, ""));
    }

    @DeleteMapping("/deleteJournal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteJournal(@PathVariable("id") int id) {
        Journal journal = repository.findById(id).get();

        if(journal != null) {
            repository.delete(journal);
        }
    }

    private Journal createJournal(int id, int pain, String owner, String notes) {

        Journal journal = new Journal();
        journal.setId(id);
        journal.setPain(pain);
        journal.setOwner(owner);
        journal.setNotes(notes);

        return journal;
    }
}
