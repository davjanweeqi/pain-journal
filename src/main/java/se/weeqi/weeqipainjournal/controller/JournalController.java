package se.weeqi.weeqipainjournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.weeqi.weeqipainjournal.repository.JournalRepository;

import java.util.Date;

@RestController
public class JournalController {

    @Autowired
    private JournalRepository repository;

    @GetMapping("/getJournal")
    public void getJournal(@RequestParam(value = "owner") String owner) {
        //repository.getJournal(owner);
        //repository.findById(owner);
    }

    @PutMapping("/postPainLevel")
    public void addDate(@RequestParam(value = "currentPainLevel", required = false) int painLevel, @RequestParam(value = "date", required = false) Date date) {
        //repository.addDate(painLevel, date);
    }
}
