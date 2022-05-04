package by.itstep.stpnbelko.javastages.stage20.model.entity;

public class Percussion {
    private String name;
    private int numberOfDrums;
    private int experience;
    private double volume;

    public Percussion() {
    }

    public Percussion(String name, int numberOfDrums, int experience, double volume) {
        this.name = name;
        this.numberOfDrums = numberOfDrums;
        this.experience = experience;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDrums() {
        return numberOfDrums;
    }

    public void setNumberOfDrums(int numberOfDrums) {
        this.numberOfDrums = numberOfDrums;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Percussion {" +
                "name = '" + name + '\'' +
                ", numberOfDrums = " + numberOfDrums + " drums" +
                ", experience = " + experience +
                ", volume = " + volume +
                '}';
    }
}
