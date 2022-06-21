package by.itstep.stpnbelko.javastages.stage20.model.entity.instances;

public enum MusicianTypes {
    PERCUSSION("Барабаны"),
    SINGER("Певец"),
    VIOLIN("Скрипка"),
    GUITAR("Какая-то гитара");

    private final String rusName;


    MusicianTypes(String rusName) {
        this.rusName = rusName;
    }

    public String getRusName() {
        return rusName;
    }
}