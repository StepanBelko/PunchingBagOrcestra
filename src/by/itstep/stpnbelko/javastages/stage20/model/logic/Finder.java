package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.MusicianInstance;
import by.itstep.stpnbelko.javastages.stage20.model.logic.salaryFindStrategy.MusicianSalary;

public class Finder {
    private static Scene musicianList;

    public static Scene find(Iterable<Musician> scene, MusicianInstance musicianInstance
            , MusicianSalary musicianSalary, int salary) {
        musicianList = new Scene();
        for (Musician musician : scene) {
            if (musicianInstance.isInstanceOfSpecial(musician)
                    && musicianSalary.compare(musician, salary)) {
                musicianList.add(musician);
            }
        }
        return musicianList;
    }

    public static Scene find(Iterable<Musician> scene
            , MusicianSalary musicianSalary, int salary) {
        musicianList = new Scene();
        for (Musician musician : scene) {
            if (musicianSalary.compare(musician, salary)) {
                musicianList.add(musician);
            }
        }
        return musicianList;
    }

    public static Scene find(Iterable<Musician> scene, MusicianInstance musicianInstance) {
        musicianList = new Scene();
        for (Musician musician : scene) {
            if (musicianInstance.isInstanceOfSpecial(musician)) {
                musicianList.add(musician);
            }
        }
        return musicianList;
    }
}
