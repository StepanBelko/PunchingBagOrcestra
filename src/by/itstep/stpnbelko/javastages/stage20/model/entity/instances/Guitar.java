package by.itstep.stpnbelko.javastages.stage20.model.entity.instances;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class Guitar<TypeOfGuitar> extends Musician {

    private GuitarTypes typeOfGuitar;

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
        this.typeOfGuitar = (GuitarTypes) typeOfGuitar;
    }

    @Override
    public String toString() {
        return super.toString() + " Guitar " + typeOfGuitar;
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
            return typeOfGuitarFullName;
        }
    }

}
