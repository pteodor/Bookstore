package pl.first.project.book.store.database;

import pl.first.project.book.store.model.Writable;

public interface IEntitySever {
    void persistEntity(Writable entity);
    void updateEntity(Writable entity);
    void deleteEntity(Writable entity);
}
