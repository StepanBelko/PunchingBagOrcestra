package by.itstep.stpnbelko.javastages.stage20.util;

import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.MusicianTypes;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar.GuitarTypes;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Violin;
import by.itstep.stpnbelko.javastages.stage20.util.exceptions.SceneFileNotFoundException;

import java.io.*;

public class CharStreamSceneBuilder {


    private final String filePath;

    public CharStreamSceneBuilder(String filePath) {
        this.filePath = filePath;
    }

    public void save(Scene scene) throws SceneFileNotFoundException, IOException {
        if (filePath == null) {
            throw new SceneFileNotFoundException();
        }

        try (Writer stream = new BufferedWriter(new FileWriter(filePath))) {

            for (Musician musician : scene) {
                if (musician instanceof Guitar<?> guitar) {
                    stream.write(MusicianTypes.GUITAR.name() + ", ");
                    stream.write(guitar.getExperience() + ", ");
                    stream.write(guitar.getVolume() + ", ");
                    stream.write(guitar.getSalary() + ", ");
                    stream.write(Guitar.GuitarTypes.valueOf
                            (guitar.getTypeOfGuitar().toString()) + "\n");
                } else if (musician instanceof Percussion percussion) {
                    stream.write(MusicianTypes.PERCUSSION.name() + ", ");
                    stream.write(percussion.getExperience() + ", ");
                    stream.write(percussion.getVolume() + ", ");
                    stream.write(percussion.getSalary() + ", ");
                    stream.write(percussion.getNumberOfDrums() + "\n");
                } else if (musician instanceof Singer<?> singer) {
                    stream.write(MusicianTypes.SINGER.name() + ", ");
                    stream.write(singer.getExperience() + ", ");
                    stream.write(singer.getVolume() + ", ");
                    stream.write(singer.getSalary() + ", ");
                    stream.write(Singer.SingerType.valueOf
                            (singer.getVoiceType().toString()) + "\n");
                } else if (musician instanceof Violin violin) {
                    stream.write(MusicianTypes.VIOLIN.name() + ", ");
                    stream.write(violin.getExperience() + ", ");
                    stream.write(violin.getVolume() + ", ");
                    stream.write(violin.getSalary() + ", ");
                    stream.write(violin.getNumberOfStrings() + "\n");
                }
            }
            stream.flush();
        }

    }


    public Scene create() throws SceneFileNotFoundException {
        if (filePath == null) {
            throw new SceneFileNotFoundException();
        }
        Scene scene = new Scene();
        try (BufferedReader stream = new BufferedReader(new FileReader(filePath))) {
            Musician musician = null;
            String buffer;
            while ((buffer = stream.readLine()) != null) {
                String[] strings = buffer.split(", ");
                MusicianTypes type = MusicianTypes.valueOf(strings[0]);
                switch (type) {
                    case PERCUSSION -> {
                        String name = strings[0];
                        int experience = Integer.parseInt(strings[1]);
                        double volume = Double.parseDouble(strings[2]);
                        double salary = Double.parseDouble(strings[3]);
                        int numberOfDrums = Integer.parseInt(strings[4]);
                        musician = new Percussion(name, experience, volume, salary, numberOfDrums);
                    }
                    case VIOLIN -> {
                        String name = strings[0];
                        int experience = Integer.parseInt(strings[1]);
                        double volume = Double.parseDouble(strings[2]);
                        double salary = Double.parseDouble(strings[3]);
                        int numberOfStrings = Integer.parseInt(strings[4]);
                        musician = new Violin(name, experience, volume, salary, numberOfStrings);
                    }
                    case SINGER -> {
                        String name = strings[0];
                        int experience = Integer.parseInt(strings[1]);
                        double volume = Double.parseDouble(strings[2]);
                        double salary = Double.parseDouble(strings[3]);
                        Singer.SingerType singerType = Singer.SingerType.valueOf(strings[4]);
                        musician = new Singer<>(name, experience, volume, salary, singerType);
                    }
                    case GUITAR -> {
                        String name = strings[0];
                        int experience = Integer.parseInt(strings[1]);
                        double volume = Double.parseDouble(strings[2]);
                        double salary = Double.parseDouble(strings[3]);
                        GuitarTypes guitarType = GuitarTypes.valueOf(strings[4]);
                        musician = new Guitar<>(name, experience, volume, salary, guitarType);
                    }
                }
                scene.add(musician);
            }
        } catch (IOException exception) {
            System.err.println(exception);
        }
        return scene;
    }

}
