package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Violin;

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
            musician.playMusic();
        }
    }

    public static int howManyUnknownMusicians(Scene scene) {
        int count = 0;
        for (Musician musician : scene.getMusicians()) {
            if (musician.getClass() == Musician.class) {
                count++;
            }
        }
        return count;
    }

    public static int howManySingers(Scene scene) {
        int singersCount = 0;
        for (Musician musician : scene.getMusicians()) {
            if (musician instanceof Singer) {
                singersCount++;
            }
        }
        return singersCount;
    }

    public static int howManyViolins(Scene scene) {
        int count = 0;
        for (Musician musician : scene.getMusicians()) {
            if (musician instanceof Violin) {
                count++;
            }
        }
        return count;
    }

    public static int howManyPercussionists(Scene scene) {
        int count = 0;
        for (Musician musician : scene.getMusicians()) {
            if (musician instanceof Percussion) {
                count++;
            }
        }
        return count;
    }
}
