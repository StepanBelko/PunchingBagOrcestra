package by.itstep.stpnbelko.javastages.stage20.model.entity.container;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public interface Scene {
    int size();
    Musician get(int index);
    void add(Musician musician);

}