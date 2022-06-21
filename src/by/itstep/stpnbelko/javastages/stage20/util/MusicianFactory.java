package by.itstep.stpnbelko.javastages.stage20.util;

import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.MusicianTypes;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Violin;

import java.util.Random;

import static by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar.GuitarTypes.*;
import static by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Singer.SingerType.*;

public class MusicianFactory {
    private static int singerCount = 0;
    private static int violinCount = 0;
    private static int percussionCount = 0;
    private static int guitarCount = 0;

    private static final int MUSICIAN_MIN_SALARY = 0;  //  50$/h
    private static final int MUSICIAN_MAX_SALARY = 50;

    private static final MusicianFactory factory = new MusicianFactory();
    private static final Random random = new Random();

    public Musician createMusician(MusicianTypes type) {
        Musician musician = null;

        switch (type) {
            case SINGER -> musician = createRandomSinger();
            case VIOLIN -> musician = createRandomViolin();
            case PERCUSSION -> musician = createRandomPercussion();
            case GUITAR -> musician = createRandomGuitar();
        }
        return musician;
    }

    public static Musician createRandomMusician() {
        MusicianTypes[] types = MusicianTypes.values();
        int i = random.nextInt(types.length);

        return factory.createMusician(types[i]);
    }

    public static Singer<Singer.SingerType> createRandomSinger() {
        int experience = random.nextInt(100);
        double volume = random.nextDouble() * 100;
        double salary = countRandomSalary(MUSICIAN_MAX_SALARY, MUSICIAN_MIN_SALARY);
        return new Singer<>(MusicianTypes.SINGER.getRusName() + " "
                + ++singerCount, experience, volume, salary, generateRandomVoicePower());
    }


    public static Percussion createRandomPercussion() {
        int experience = random.nextInt(100);
        double volume = random.nextDouble() * 500;
        int numberOfDrums = random.nextInt(20);
        double salary = countRandomSalary(MUSICIAN_MAX_SALARY, MUSICIAN_MIN_SALARY);

        return new Percussion(MusicianTypes.PERCUSSION.getRusName() + " "
                + ++percussionCount, experience, volume, salary, numberOfDrums);
    }

    private Violin createRandomViolin() {
        int experience = random.nextInt(100);
        double volume = random.nextDouble() * 120;
        int numberOfStrings = random.nextInt(20);
        double salary = countRandomSalary(MUSICIAN_MAX_SALARY, MUSICIAN_MIN_SALARY);

        return new Violin(MusicianTypes.VIOLIN.getRusName() + " "
                + ++violinCount, experience, volume, salary, numberOfStrings);
    }

    public static Guitar createRandomGuitar() {
        Guitar.GuitarTypes randomType = generateRandomGuitarType();
        String name = randomType.getTypeOfGuitarFullName();
        int experience = random.nextInt(100);
        double volume = random.nextDouble() * 150;
        double salary = countRandomSalary(MUSICIAN_MAX_SALARY, MUSICIAN_MIN_SALARY);
        return new Guitar<>(name + " " + ++guitarCount, experience, volume, salary, randomType);
    }

    public static Guitar createRhythmGuitar() {
        String name = RHYTHM_GUITAR.getTypeOfGuitarFullName();
        int experience = random.nextInt(50);
        double volume = random.nextDouble() * 150;
        double salary = countRandomSalary(MUSICIAN_MAX_SALARY, MUSICIAN_MIN_SALARY);
        Musician guitarist = new Guitar<>(name + " " + ++guitarCount, experience, volume, salary, RHYTHM_GUITAR);
        return (Guitar) guitarist;
    }

    public static Guitar createLeadGuitar() {
        String name = LEAD_GUITAR.getTypeOfGuitarFullName();
        int experience = random.nextInt(50);
        double volume = random.nextDouble() * 150;
        double salary = countRandomSalary(MUSICIAN_MAX_SALARY, MUSICIAN_MIN_SALARY);
        Musician guitarist = new Guitar<>(name + " " + ++guitarCount, experience, volume, salary, LEAD_GUITAR);
        return (Guitar) guitarist;
    }

    public static Guitar createBassGuitar() {
        String name = BASS.getTypeOfGuitarFullName();
        int experience = random.nextInt(50);
        double volume = random.nextDouble() * 350;
        double salary = countRandomSalary(MUSICIAN_MAX_SALARY, MUSICIAN_MIN_SALARY);
        Musician guitarist = new Guitar<>(name + " " + ++guitarCount, experience, volume, salary, BASS);
        return (Guitar) guitarist;
    }

    private static Guitar.GuitarTypes generateRandomGuitarType() {
        int temp = random.nextInt(3);
        if (temp == 0) {
            return RHYTHM_GUITAR;
        }
        if (temp == 1) {
            return Guitar.GuitarTypes.LEAD_GUITAR;
        } else {
            return Guitar.GuitarTypes.BASS;
        }
    }

    private static Singer.SingerType generateRandomVoicePower() {
        int temp = random.nextInt(4);
        if (temp == 0) {
            return LOW;
        }
        if (temp == 1) {
            return MID;
        } else if (temp == 2) {
            return HIGH;
        } else {
            return UNKNOWN_VOICE_POWER;
        }
    }

    private static double countRandomSalary(int maxVal, int minVal) {
        maxVal *= 10;
        minVal *= 10;
        maxVal -= minVal;
        int rand = (int) (Math.random() * ++maxVal) + minVal;
        return (double) rand / 10;
    }
}
