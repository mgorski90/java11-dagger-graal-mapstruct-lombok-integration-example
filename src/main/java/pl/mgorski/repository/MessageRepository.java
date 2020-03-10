package pl.mgorski.repository;

import pl.mgorski.Message;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Singleton
public class MessageRepository {

    private final Set<Message> inMemoryDb = new CopyOnWriteArraySet<>();

    public List<Message> findAll() {
        return new ArrayList<>(inMemoryDb);
    }

    public void put(Message message) {
        inMemoryDb.add(message);
    }

}
