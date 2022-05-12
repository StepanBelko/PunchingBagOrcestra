package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Violin;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Kapellmeister;
import by.itstep.stpnbelko.javastages.stage20.model.logic.StageSorter;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.InstanceOfPercussion;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.InstanceOfSinger;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.InstanceOfViolin;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.UnknownInstance;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.SortByExperienceAsc;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.SortByExperienceDesc;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.SortByVolumeAsc;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.SortByVolumeDesc;

import static by.itstep.stpnbelko.javastages.stage20.model.logic.Kapellmeister.*;

public class Main {
    public static void main(String[] args) {
//        создаём музыкантов
        Musician musician = new Musician("Musician 1");
        Musician violin = new Violin("violin 1", 3, 20.2, 4);
        Musician musician1 = new Violin("violin 2", 2, 19, 4);
        Musician violin3 = new Violin("violin 3", 8, 25.2, 4);
        Percussion percussion = new Percussion("DrumKit", 10, 50, 12);
        Singer singer = new Singer("Voice1", 20, 40.0, "highest");
        Singer singer2 = new Singer("Voice2", 20, 350.0, "low");
//        создаём сцену
        Scene scene = new Scene();
//        приглашаем музыкантов на сцену
        scene.inviteMusician(musician);
        scene.inviteMusician(singer);
        scene.inviteMusician(singer2);
        scene.inviteMusician(violin);
        scene.inviteMusician(musician1);
        scene.inviteMusician(violin3);
        scene.inviteMusician(percussion);
        System.out.println(scene);

//        некоторых выгоняем со сцены)
        scene.expelMusician(3);
        System.out.println(scene);

//        считаем общий опыт музыкантов(считает дирижёр)
        int totalExp = Kapellmeister.calculateTotalExperience(scene);
        System.out.println("Total musicians experience is " + totalExp + " year(s)");

//        считаем общую громкость оркестра(считает дирижёр)
        double totalVolume = Kapellmeister.calculateTotalVolume(scene);
        System.out.println("Total musicians volume is " + totalVolume + "dB");

//        запускаем у всех музыкантов на сцене метод "играть музыку"(запускает дирижёр)
        Kapellmeister.playMusic(scene);

//        Считаем отдельно вокалистов, скрипачей, перкуссионистов и неизвестных музыкантов на сцене
//        Дополнено. Добавил интерфейс MusicianInstance для использования Strategy
        System.out.println("How many singers? " + howManySomeInstance(scene, new InstanceOfSinger()));
        System.out.println("How many violins? " + howManySomeInstance(scene, new InstanceOfViolin()));
        System.out.println("How many percussionists? " + howManySomeInstance(scene, new InstanceOfPercussion()));
        System.out.println("How many unknown musicians? " + howManySomeInstance(scene, new UnknownInstance()));

//        Сортировка музыкантов по уровню громкости
        StageSorter.sort(scene, new SortByVolumeAsc());
        System.out.println(scene);

        StageSorter.sort(scene, new SortByVolumeDesc());
        System.out.println(scene);

//        Сортировка по опыту
        StageSorter.sort(scene, new SortByExperienceAsc());
        System.out.println(scene);

        StageSorter.sort(scene, new SortByExperienceDesc());
        System.out.println(scene);
    }
}
