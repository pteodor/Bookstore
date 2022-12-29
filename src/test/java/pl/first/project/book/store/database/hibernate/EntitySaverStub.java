package pl.first.project.book.store.database.hibernate;

import pl.first.project.book.store.database.IEntitySever;
import pl.first.project.book.store.model.Writable;

public class EntitySaverStub implements IEntitySever {

    private int persistEntityCalls = 0;
    @Override
    public void persistEntity(Writable entity) {
        persistEntityCalls++;
    }

    @Override
    public void updateEntity(Writable entity) {

    }

    @Override
    public void deleteEntity(Writable entity) {

    }

    public int getPersistEntityCalls() {
        return persistEntityCalls;
    }
}
