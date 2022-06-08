package by.itstep.stpnbelko.javastages.stage20.model.entity;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

public class Singer<SingerEnum> extends Musician {
    private SingerEnum voicePower;

    public Singer(SingerEnum voicePower) {
        super("Singer");
        this.voicePower = voicePower;
    }

    public Singer(String name, SingerEnum voicePower) {
        super(name);
        this.voicePower = voicePower;
    }

    public Singer(String name, int experience, double volume, SingerEnum voicePower) {
        super(name, experience, volume);
        this.voicePower = voicePower;
    }

    public Singer(String name, int experience, double volume, double salary, SingerEnum voicePower) {
        super(name, experience, volume, salary);
        this.voicePower = voicePower;
    }

    public SingerEnum getVoicePower() {
        return voicePower;
    }

    public void setVoicePower(SingerEnum voicePower) {
        this.voicePower = voicePower;
    }

    @Override
    public String toString() {
        return super.toString() + " Singer " +
                "voicePower = " + voicePower;
    }
}



