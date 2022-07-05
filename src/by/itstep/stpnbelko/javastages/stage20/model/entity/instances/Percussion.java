package by.itstep.stpnbelko.javastages.stage20.model.entity.instances;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Percussion that = (Percussion) o;
        return numberOfDrums == that.numberOfDrums;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfDrums);
    }
}
