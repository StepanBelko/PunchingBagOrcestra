package by.itstep.stpnbelko.javastages.stage20.util;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.SingerEnum;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Violin;

import java.util.Random;

public class MusicianFactory {
    private static int singerCount = 0;
    private static int violinCount = 0;
    private static int percussionCount = 0;

    private static final MusicianFactory factory = new MusicianFactory();
    private static final Random random = new Random();

    public enum MusicianTypes {
        PERCUSSION("Барабаны"),
        SINGER("Певец"),
        VIOLIN("Скрипка");

        private final String rusName;


        MusicianTypes(String rusName) {
            this.rusName = rusName;
        }

        public String getRusName() {
            return rusName;
        }
    }

    public Musician createMusician(MusicianTypes type) {
        Musician musician = null;

        switch (type) {
            case SINGER -> musician = createRandomSinger();
            case VIOLIN -> musician = createRandomViolin();
            case PERCUSSION -> musician = createRandomPercussion();
        }
        return musician;
    }

    public static Musician createRandomMusician() {
        MusicianTypes[] types = MusicianTypes.values();
        int i = random.nextInt(types.length);

        return factory.createMusician(types[i]);
    }

    private Singer createRandomSinger() {
        int experience = random.nextInt(100);
        double volume = random.nextDouble() * 100;
        double salary = random.nextDouble() * (2000 - 1000) + 1000;

        return new Singer(MusicianTypes.SINGER.getRusName() + " "
                + ++singerCount, experience, volume, salary, SingerEnum.UNKNOWN_VOICE_POWER);
    }

    private Percussion createRandomPercussion() {
        int experience = random.nextInt(100);
        double volume = random.nextDouble() * 200;
        int numberOfDrums = random.nextInt(20);
        double salary = random.nextDouble() * (1000 - 100) + 100;

        return new Percussion(MusicianTypes.PERCUSSION.getRusName() + " "
                + ++percussionCount, experience, volume, salary, numberOfDrums);
    }

    private Violin createRandomViolin() {
        int experience = random.nextInt(100);
        double volume = random.nextDouble() * 120;
        int numberOfStrings = random.nextInt(20);
        double salary = random.nextDouble() * (800 - 200) + 200;

        return new Violin(MusicianTypes.VIOLIN.getRusName() + " "
                + ++violinCount, experience, volume, salary, numberOfStrings);
    }
}
