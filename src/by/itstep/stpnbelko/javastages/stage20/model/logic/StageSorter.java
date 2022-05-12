package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;

public class StageSorter {

    public static void sortByVolumeAsc(Scene scene) {
        for (int i = 0; i < scene.getMusiciansCount() - 1; i++) {
            for (int j = 0; j < scene.getMusiciansCount() - 1 - i; j++) {
                if (scene.getMusicianToIndex(j).getVolume() > scene.getMusicianToIndex(j + 1).getVolume()) {
                    swap(scene, j);
                }
            }
        }
    }

    private static void swap(Scene scene, int index) {
        Musician temp = scene.getMusicianToIndex(index);
        scene.setMusicianToIndex(scene.getMusicianToIndex(index + 1), index);
        scene.setMusicianToIndex(temp, index + 1);
    }
}
