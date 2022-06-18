package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.MusicianCalculable;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.MusicianInstance;

import java.util.Iterator;

public class Kapellmeister {
    private Kapellmeister() {
    }

    public static double calculateTotal(Iterable<Musician> iterable, MusicianCalculable calculable) {
        double total = 0;

        for (Musician musician : iterable) {
            total += calculable.calculate(musician);
        }

        return total;
    }

    public static void playMusic(Iterable<Musician> iterable) {
        for (Musician musician : iterable) {
            musician.playMusic();
        }
    }

    public static int howManySomeInstance(Iterable scene, MusicianInstance musicianInstance) {
        int count = 0;
        for (Musician musician : (Iterable<Musician>) scene) {
            if (musicianInstance.isInstanceOfSpecial(musician)) {
                count++;
            }
        }
        return count;
    }
}
