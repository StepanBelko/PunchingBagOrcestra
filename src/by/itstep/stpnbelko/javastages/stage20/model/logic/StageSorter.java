package by.itstep.stpnbelko.javastages.stage20.model.logic;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.SceneDynamicArray;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.MusiciansSortable;

import java.util.Collections;

public class StageSorter {

    public static void sort(SceneDynamicArray scene, MusiciansSortable sortable) {
        for (int i = 0; i < scene.size() - 1; i++) {
            for (int j = 0; j < scene.size() - 1 - i; j++) {
                if (sortable.compare(scene.getMusicianToIndex(j), scene.getMusicianToIndex(j + 1))) {
                    swap(scene, j);
                }
            }
        }
    }

    private static void swap(SceneDynamicArray scene, int index) {
        Musician temp = scene.getMusicianToIndex(index);
        scene.setMusicianToIndex(scene.getMusicianToIndex(index + 1), index);
        scene.setMusicianToIndex(temp, index + 1);
    }
}
