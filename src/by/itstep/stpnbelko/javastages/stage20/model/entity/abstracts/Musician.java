package by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class Musician implements Playable {
    private String name;
    private int experience;
    private double volume;

    public Musician(String name) {
        this.name = name;
        this.experience = 0;
        this.volume = 0;
    }

    public Musician(String name, int experience, double volume) {
        this.name = name;
        if (experience >= 0) {
            this.experience = experience;
        }
        if (volume > 0) {
            this.volume = volume;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        if (experience >= 0) {
            this.experience = experience;
        }
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        if (volume > 0) {
            this.volume = volume;
        }
    }

    @Override
    public String toString() {
        return "Musician " +
                "name = \"" + name + "\"" +
                ", experience = " + experience + " years" +
                ", volume = " + volume;
    }

    @Override
    public void playMusic() {
        System.out.println(name + " play music now");
    }
}
