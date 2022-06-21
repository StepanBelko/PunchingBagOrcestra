package by.itstep.stpnbelko.javastages.stage20.model.entity.instances;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class Percussion extends Musician {
    private int numberOfDrums;

    public Percussion(String name) {
        super(name);
    }

    public Percussion(String name, int experience, double volume, double salary, int numberOfDrums) {
        super(name, experience, volume, salary);
        this.numberOfDrums = numberOfDrums;
    }

    public int getNumberOfDrums() {
        return numberOfDrums;
    }

    public void setNumberOfDrums(int numberOfDrums) {
        this.numberOfDrums = numberOfDrums;
    }

    @Override
    public String toString() {
        return super.toString() + " Percussion " +
                "numberOfDrums = " + numberOfDrums;
    }
}
