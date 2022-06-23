package by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts;

import java.io.IOException;
import java.io.Serializable;

public class Musician implements Playable, Serializable {
    static final long serialVersionUID = 1L;

    private String name;
    private int experience;
    private double volume;
    private double salary;
    private transient int musicianID = 123456789;

    public Musician(String name) {
        this.name = name;
        this.experience = 0;
        this.volume = 0;
        this.salary = 0;
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

    public Musician(String name, int experience, double volume, double salary) {
        this.name = name;
        if (experience >= 0) {
            this.experience = experience;
        }
        if (volume > 0) {
            this.volume = volume;
        }
        if (salary >= 0) {
            this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getMusicianID() {
        return musicianID;
    }

    public void setMusicianID(int musicianID) {
        this.musicianID = musicianID;
    }

    @Override
    public String toString() {
        return "Musician " +
                "\"" + name + "\"" +
                ", experience = " + experience + " years" +
                ", volume = " + String.format("%.2f", volume) + "dB" +
                ", salary = " + String.format("%.1f", salary) + "$/h" +
                " ID = " + musicianID;
    }

    @Override
    public void playMusic() {
        System.out.println(name + " play music now");
    }
}
