package by.itstep.stpnbelko.javastages.stage20.util;

import by.itstep.stpnbelko.javastages.stage20.control.FirstControllerByte;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.MusicianTypes;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Violin;
import by.itstep.stpnbelko.javastages.stage20.util.exceptions.SceneFileNotFoundException;

import java.io.*;

public class ByteStreamSceneBuilder extends FirstControllerByte {
    private String filePath;

    public ByteStreamSceneBuilder() {
        filePath = "ByteScene.txt";
    }

    public void save(Scene scene) throws SceneFileNotFoundException {
        if (filePath == null) {
            throw new SceneFileNotFoundException();
        }

        try (DataOutputStream stream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filePath)))) {

            for (Musician musician :
                    scene) {
                if (musician instanceof Guitar<?> guitar) {
                    stream.writeInt(MusicianTypes.GUITAR.ordinal());
                    stream.writeUTF(guitar.getName());
                    stream.writeInt(guitar.getExperience());
                    stream.writeDouble(guitar.getVolume());
                    stream.writeDouble(guitar.getSalary());
                    stream.writeInt(Guitar.GuitarTypes.valueOf
                            (guitar.getTypeOfGuitar().toString()).ordinal());
                } else if (musician instanceof Percussion percussion) {
                    stream.writeInt(MusicianTypes.PERCUSSION.ordinal());
                    stream.writeUTF(percussion.getName());
                    stream.writeInt(percussion.getExperience());
                    stream.writeDouble(percussion.getVolume());
                    stream.writeDouble(percussion.getSalary());
                    stream.writeInt(percussion.getNumberOfDrums());
                } else if (musician instanceof Singer<?> singer) {
                    stream.writeInt(MusicianTypes.SINGER.ordinal());
                    stream.writeUTF(singer.getName());
                    stream.writeInt(singer.getExperience());
                    stream.writeDouble(singer.getVolume());
                    stream.writeDouble(singer.getSalary());
                    stream.writeInt(Singer.SingerType.valueOf
                            (singer.getVoiceType().toString()).ordinal());
                } else if (musician instanceof Violin violin) {
                    stream.writeInt(MusicianTypes.VIOLIN.ordinal());
                    stream.writeUTF(violin.getName());
                    stream.writeInt(violin.getExperience());
                    stream.writeDouble(violin.getVolume());
                    stream.writeDouble(violin.getSalary());
                    stream.writeInt(violin.getNumberOfStrings());
                }
            }
            stream.flush();

        } catch (IOException exception) {
            System.err.println(exception);
        }
    }

    public Scene create() {
//        if (filePath == null) {
//            throw new SceneFileNotFoundException();
//        }
        Scene scene = new Scene();

        try (DataInputStream stream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filePath)))) {

            int index;

            while ((stream.available()) != 0) {
                Musician musician = null;
                index = stream.readInt();
                MusicianTypes type = MusicianTypes.values()[index];

                switch (type) {
                    case GUITAR -> {
                        String name = stream.readUTF();
                        int experience = stream.readInt();
                        double volume = stream.readDouble();
                        double salary = stream.readDouble();
                        Guitar.GuitarTypes guitarType = Guitar.GuitarTypes.values()[stream.readInt()];
                        musician = new Guitar<>(name, experience, volume, salary, guitarType);
                    }
                    case PERCUSSION -> {
                        String name = stream.readUTF();
                        int experience = stream.readInt();
                        double volume = stream.readDouble();
                        double salary = stream.readDouble();
                        int numberOfDrums = stream.readInt();
                        musician = new Percussion(name, experience, volume, salary, numberOfDrums);
                    }
                    case SINGER -> {
                        String name = stream.readUTF();
                        int experience = stream.readInt();
                        double volume = stream.readDouble();
                        double salary = stream.readDouble();
                        Singer.SingerType singerType = Singer.SingerType.values()[stream.readInt()];
                        musician = new Singer<>(name, experience,volume,salary,singerType);
                    }
                    case VIOLIN -> {
                        String name = stream.readUTF();
                        int experience = stream.readInt();
                        double volume = stream.readDouble();
                        double salary = stream.readDouble();
                        int numberOfStrings = stream.readInt();
                        musician = new Violin(name,experience,volume,numberOfStrings);
                    }
                }
                scene.add(musician);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return scene;
    }
}
