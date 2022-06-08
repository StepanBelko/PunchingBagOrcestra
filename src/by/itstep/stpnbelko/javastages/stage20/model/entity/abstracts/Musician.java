package by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts;

public class Musician implements Playable {
    private String name;
    private int experience;
    private double volume;
    private double salary;

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

    @Override
    public String toString() {
        return "Musician " +
                "\"" + name + "\"" +
                ", experience = " + experience + " years" +
                ", volume = " + String.format("%.2f", volume) +
                ", salary = " + String.format("%.2f",salary) + "$";
    }

    @Override
    public void playMusic() {
        System.out.println(name + " play music now");
    }
}
