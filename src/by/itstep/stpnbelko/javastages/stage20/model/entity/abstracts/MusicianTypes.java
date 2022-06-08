package by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts;

public enum MusicianTypes {
    PERCUSSION ("Барабаны"),
    SINGER("Певец"),
    VIOLIN("Скрипка");

    private final String rusName;


    MusicianTypes(String rusName) {
        this.rusName = rusName;
    }

    public String getRusName() {
        return rusName;
    }
}
