package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.MusicianCalculable;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.MusicianInstance;

public class Kapellmeister {
    private Kapellmeister() {
    }

    public static double calculateTotal(Scene scene, MusicianCalculable calculable) {
        double total = 0;
        for (Musician musician : scene.getMusicians()) {
            total += calculable.calculate(musician);
        }
        return total;
    }

    public static void playMusic(Scene scene) {
        for (Musician musician : scene.getMusicians()) {
            musician.playMusic(musician); // Очень странно выглядит
//            Запуск метода на объекте, в который мы передаём его же. Так можно?
        }
    }

    public static int howManySomeInstance(Scene scene, MusicianInstance musicianInstance) {
        int count = 0;
        for (Musician musician : scene.getMusicians()) {
            if (musicianInstance.isInstanceOfSpecial(musician)) {
                count++;
            }
        }
        return count;
    }
}
