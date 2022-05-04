package by.itstep.stpnbelko.javastages.stage20.model.entity;

public class Violin {
    private String name;
    private int numberOfStrings;
    private int experience;
    private double volume;

    public Violin() {
    }

    public Violin(String name, int numberOfStrings, int experience, double volume) {
        this.name = name;
        this.numberOfStrings = numberOfStrings;
        this.experience = experience;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
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
        return "Violin {" +
                "name = '" + name + '\'' +
                ", numberOfStrings = " + numberOfStrings +
                ", experience = " + experience + " years" +
                ", volume = " + volume +
                '}';
    }
}
