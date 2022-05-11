package by.itstep.stpnbelko.javastages.stage20.model.abstracts;

public class Musician {
    private String name;
    private int experience;
    private double volume;

    public Musician() {
    }

    public Musician(String name) {
        this.name = name;
    }

    public Musician(String name, int experience, double volume) {
        this.name = name;
        this.experience = experience;
        this.volume = volume;
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
        return "Musician " +
                "name = \"" + name + "\"" +
                ", experience = " + experience + " years" +
                ", volume = " + volume;
    }

    public void playMusic() {
        System.out.println(this.getName() + " plays music now");
    }
}
