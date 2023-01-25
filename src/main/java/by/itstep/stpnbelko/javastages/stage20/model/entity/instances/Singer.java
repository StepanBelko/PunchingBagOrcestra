package by.itstep.stpnbelko.javastages.stage20.model.entity.instances;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

import java.util.Objects;

public class Singer<SingerEnum> extends Musician {

    private SingerEnum voicePower;

    public enum SingerType {
        UNKNOWN_VOICE_POWER("Неизвестно"),
        LOW("Слабый голос"),
        MID("Средний голос"),
        HIGH("Сильный голос");

        private String voicePower;

        SingerType(String voicePower) {
            this.voicePower = voicePower;
        }

        public String getVoicePowerRus() {
            return voicePower;
        }
    }

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

    public SingerEnum getVoiceType() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Singer<?> singer = (Singer<?>) o;
        return Objects.equals(voicePower, singer.voicePower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), voicePower);
    }
}



