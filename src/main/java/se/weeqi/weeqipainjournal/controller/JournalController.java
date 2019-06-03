package se.weeqi.weeqipainjournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.weeqi.weeqipainjournal.entity.Journal;
import se.weeqi.weeqipainjournal.repository.JournalRepository;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class JournalController {

    private final JournalRepository repository;

    public JournalController(JournalRepository repository) {
        this.repository = repository;
    }

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

    @PutMapping("/createJournal/{id}/{pain}/{owner}/{notes}/{dateToJournal}")
    @ResponseStatus(HttpStatus.CREATED)
    public Journal putCompleteJournal(
            @PathVariable("id") int id,
            @PathVariable("pain") int pain,
            @PathVariable("owner") String owner,
            @PathVariable("notes") String notes,
            @PathVariable("dateToJournal") String dateToJournal) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateToJournal, format);

        return repository.save(createJournal(id, pain, owner, notes, date));
    }

    @DeleteMapping("/deleteJournal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteJournal(@PathVariable("id") int id) {

        if(repository.findById(id).isPresent()) {
            Journal journal = repository.findById(id).get();
            repository.delete(journal);
        }
    }

    private Journal createJournal(int id, int pain, String owner, String notes, LocalDate date) {

        Journal journal = new Journal();
        journal.setId(id);
        journal.setPain(pain);
        journal.setOwner(owner);
        journal.setNotes(notes);
        journal.setCreatedAt(date);

        return journal;
    }
}
