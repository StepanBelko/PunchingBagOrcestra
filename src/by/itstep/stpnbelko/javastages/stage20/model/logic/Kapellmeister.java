package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.MusicianInstance;

public class Kapellmeister {
    private Kapellmeister() {
    }

    public static int calculateTotalExperience(Scene scene) {
        int totalExperience = 0;
        for (Musician musician : scene.getMusicians()) {
            totalExperience += musician.getExperience();
        }
        return totalExperience;
    }

    public static double calculateTotalVolume(Scene scene) {
        double totalVolume = 0;
        for (Musician musician : scene.getMusicians()) {
            totalVolume += musician.getVolume();
        }
        return totalVolume;
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
