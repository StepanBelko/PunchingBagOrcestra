package by.itstep.stpnbelko.javastages.stage20.model.entity;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class Percussion extends Musician {
    private int numberOfDrums;

    public Percussion(int numberOfDrums) {
        this.numberOfDrums = numberOfDrums;
    }

    public Percussion(String name, int numberOfDrums) {
        super(name);
        this.numberOfDrums = numberOfDrums;
    }

    public Percussion(String name, int experience, double volume, int numberOfDrums) {
        super(name, experience, volume);
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
