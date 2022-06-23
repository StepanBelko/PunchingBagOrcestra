package by.itstep.stpnbelko.javastages.stage20.model.entity.instances;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

import java.io.IOException;
import java.io.Serial;

import static by.itstep.stpnbelko.javastages.stage20.model.entity.instances.Guitar.GuitarTypes.*;

public class Guitar<GuitarTypes> extends Musician {

    private GuitarTypes typeOfGuitar;

    @Serial
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(getMusicianID());
    }

    @Serial
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        setMusicianID(in.readInt());
    }

    public Guitar(String name) {
        super(name);
    }

    public Guitar(String name, int experience, double volume) {
        super(name, experience, volume);
    }

    public Guitar(String name, int experience, double volume, double salary) {
        super(name, experience, volume, salary);
    }

    public Guitar(String name, int experience, double volume, double salary, GuitarTypes typeOfGuitar) {
        super(name, experience, volume, salary);
        this.typeOfGuitar = typeOfGuitar;
    }

    public GuitarTypes getTypeOfGuitar() {
        return typeOfGuitar;
    }

    public void setTypeOfGuitar(GuitarTypes typeOfGuitar) {
        this.typeOfGuitar = typeOfGuitar;
    }

    @Override
    public String toString() {
        String instrument = null;
        if (LEAD_GUITAR.equals(typeOfGuitar)) {
            instrument = LEAD_GUITAR.getTypeOfGuitarFullName();
        } else if (RHYTHM_GUITAR.equals(typeOfGuitar)) {
            instrument = RHYTHM_GUITAR.getTypeOfGuitarFullName();
        } else if (BASS.equals(typeOfGuitar)) {
            instrument = BASS.getTypeOfGuitarFullName();
        }
        return super.toString() + " " + instrument;
    }

    public enum GuitarTypes {
        BASS("Bass guitar"),
        RHYTHM_GUITAR("Rhythm guitar"),
        LEAD_GUITAR("Lead guitar");

        private final String typeOfGuitarFullName;

        GuitarTypes(String typeOfGuitarFullName) {
            this.typeOfGuitarFullName = typeOfGuitarFullName;
        }

        public String getTypeOfGuitarFullName() {
            return this.typeOfGuitarFullName;
        }
    }

}
