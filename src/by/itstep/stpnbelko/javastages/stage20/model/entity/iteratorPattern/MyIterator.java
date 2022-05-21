package by.itstep.stpnbelko.javastages.stage20.model.entity.iteratorPattern;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public interface MyIterator {
    Musician next();
    boolean hasNext();
    void reset();
    String getName();
}
