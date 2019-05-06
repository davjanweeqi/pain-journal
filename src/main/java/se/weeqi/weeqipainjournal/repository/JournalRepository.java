package se.weeqi.weeqipainjournal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.weeqi.weeqipainjournal.entity.Journal;

@Repository
public interface JournalRepository extends MongoRepository<Journal, Long> {
}