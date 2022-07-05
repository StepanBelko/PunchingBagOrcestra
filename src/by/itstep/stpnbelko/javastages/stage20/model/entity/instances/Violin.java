package by.itstep.stpnbelko.javastages.stage20.model.entity.instances;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

import java.util.Objects;

public class Violin extends Musician {
    private int numberOfStrings;

    public Violin(int numberOfStrings) {
        super("Violin");
        this.numberOfStrings = numberOfStrings;
    }

    public Violin(String name, int numberOfStrings) {
        super(name);
        this.numberOfStrings = numberOfStrings;
    }

    public Violin(String name, int experience, double volume, int numberOfStrings) {
        super(name, experience, volume);
        this.numberOfStrings = numberOfStrings;
    }

    public Violin(String name, int experience, double volume, double salary, int numberOfStrings) {
        super(name, experience, volume, salary);
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public String toString() {
        return super.toString() + " Violin " +
                "numberOfStrings = " + numberOfStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Violin violin = (Violin) o;
        return numberOfStrings == violin.numberOfStrings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfStrings);
    }
}
