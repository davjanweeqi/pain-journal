package se.weeqi.weeqipainjournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.weeqi.weeqipainjournal.entity.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}