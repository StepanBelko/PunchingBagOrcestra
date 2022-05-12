package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.entity.abstracts.Musician;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Percussion;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Singer;
import by.itstep.stpnbelko.javastages.stage20.model.entity.Violin;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Kapellmeister;

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

//        считаем отдельно вокалистов, скрипачей, перкуссионистов и неизвестных музыкантов на сцене
        System.out.println("How many singers? " + howManySingers(scene));
        System.out.println("How many violins? " + howManyViolins(scene));
        System.out.println("How many percussionists? " + howManyPercussionists(scene));
        System.out.println("How many unknown musicians? " + howManyUnknownMusicians(scene));

    }
}
