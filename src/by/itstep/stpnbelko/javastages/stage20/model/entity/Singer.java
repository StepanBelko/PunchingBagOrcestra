package by.itstep.stpnbelko.javastages.stage20.model.entity;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class Singer extends Musician {
    private String voicePower;

    public Singer(String voicePower) {
        super("Singer");
        this.voicePower = voicePower;
    }

    public Singer(String name, String voicePower) {
        super(name);
        this.voicePower = voicePower;
    }

    public Singer(String name, int experience, double volume, String voicePower) {
        super(name, experience, volume);
        this.voicePower = voicePower;
    }

    public Singer(String name, int experience, double volume, double salary, String voicePower) {
        super(name, experience, volume, salary);
        this.voicePower = voicePower;
    }

    public String getVoicePower() {
        return voicePower;
    }

    public void setVoicePower(String voicePower) {
        this.voicePower = voicePower;
    }

    @Override
    public String toString() {
        return super.toString() + " Singer " +
                "voicePower = " + voicePower;
    }
}

