package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.MusicianFactory;
import by.itstep.stpnbelko.javastages.stage20.model.entity.container.SceneDynamicArray;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;

import static by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.MusicianFactory.createRandomMusician;
import static by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.MusicianTypes.*;

public class Main {
    public static void main(String[] args) {
/*//        создаём музыкантов
        Musician musician = new Musician("Musician 1");
        Musician violin = new Violin("violin 1", 3, 20.2, 4);
        Musician musician1 = new Violin("violin 2", 2, 19, 4);
        Musician violin3 = new Violin("violin 3", 8, 25.2, 4);
        Percussion percussion = new Percussion("DrumKit", 10, 50, 12);
        Singer singer = new Singer("Voice1", 20, 40.0, "highest");
        Singer singer2 = new Singer("Voice2", 20, 350.0, "low");*/

        MusicianFactory musicianFactory = new MusicianFactory();

//        создаём сцену
        SceneDynamicArray scene = new SceneDynamicArray();
//        приглашаем музыкантов на сцену

        for (int i = 0; i < 10; i++) {
            scene.add(createRandomMusician());
        }

        System.out.println(scene);

//        некоторых выгоняем со сцены)
//        scene.remove(3);
//        System.out.println(scene);

//        считаем общий опыт музыкантов(считает дирижёр)
//        int totalExp = (int) Kapellmeister.calculateTotal(scene, new Experience());
//        System.out.println("Total musicians experience is " + totalExp + " year(s)");

//        считаем общую громкость оркестра(считает дирижёр)
//        double totalVolume = Kapellmeister.calculateTotal(scene, new Volume());
//        System.out.println("Total musicians volume is " + totalVolume + "dB");

//        запускаем у всех музыкантов на сцене метод "играть музыку"(запускает дирижёр)
//        Kapellmeister.playMusic(scene);

//        Считаем отдельно вокалистов, скрипачей, перкуссионистов и неизвестных музыкантов на сцене
//        Дополнено. Добавил интерфейс MusicianInstance для использования Strategy
//        System.out.println("How many singers? " + howManySomeInstance(scene, new InstanceOfSinger()));
//        System.out.println("How many violins? " + howManySomeInstance(scene, new InstanceOfViolin()));
//        System.out.println("How many percussionists? " + howManySomeInstance(scene, new InstanceOfPercussion()));
//        System.out.println("How many unknown musicians? " + howManySomeInstance(scene, new UnknownInstance()));

//        Сортировка музыкантов по уровню громкости
//        StageSorter.sort(scene, new SortByVolumeAsc());
//        System.out.println(scene);
//
//        StageSorter.sort(scene, new SortByVolumeDesc());
//        System.out.println(scene);

//        Сортировка по опыту
//        StageSorter.sort(scene, new SortByExperienceAsc());
//        System.out.println(scene);

//        StageSorter.sort(scene, new SortByExperienceDesc());
//        System.out.println(scene);

//        Kapellmeister.playMusic(scene);
        
//        SceneLinkedList sceneLinkedList = new SceneLinkedList();
//
//        sceneLinkedList.add(violin);
//        sceneLinkedList.add(singer);
//        sceneLinkedList.add(percussion);
//
//        Kapellmeister.playMusic(sceneLinkedList);
//
//        System.out.println(calculateTotal(sceneLinkedList, new Volume()));
//        System.out.println(calculateTotal(sceneLinkedList, new Experience()));
//
//        System.out.println("How many singers? " + howManySomeInstance(sceneLinkedList, new InstanceOfSinger()));
//        System.out.println("How many violins? " + howManySomeInstance(sceneLinkedList, new InstanceOfViolin()));
//        System.out.println("How many percussionists? " + howManySomeInstance(sceneLinkedList, new InstanceOfPercussion()));
//        System.out.println("How many unknown musicians? " + howManySomeInstance(sceneLinkedList, new UnknownInstance()));
//
//        sceneLinkedList.remove(1);
//        System.out.println(sceneLinkedList);
    }
}
