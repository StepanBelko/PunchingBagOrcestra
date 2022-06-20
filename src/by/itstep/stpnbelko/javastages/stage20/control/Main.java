package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Kapellmeister;
import by.itstep.stpnbelko.javastages.stage20.model.logic.Manager;
import by.itstep.stpnbelko.javastages.stage20.model.logic.StageSorter;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.Experience;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.Price;
import by.itstep.stpnbelko.javastages.stage20.model.logic.calculateTotalStrategy.Volume;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.InstanceOfPercussion;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.InstanceOfSinger;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.InstanceOfViolin;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.UnknownInstance;
import by.itstep.stpnbelko.javastages.stage20.model.logic.sortStrategy.*;
import by.itstep.stpnbelko.javastages.stage20.util.BuilderSimpleFactory;
import by.itstep.stpnbelko.javastages.stage20.util.SceneBuilder;
import by.itstep.stpnbelko.javastages.stage20.view.Printer;

import static by.itstep.stpnbelko.javastages.stage20.model.logic.Kapellmeister.howManySomeInstance;


public class Main {
    public static void main(String[] args) {

        SceneBuilder builder = BuilderSimpleFactory.getBuilder(BuilderSimpleFactory.BuilderType.RND);
        Scene scene = builder.create(10);

        System.out.println(scene);

        boolean canWeMakePerform = (Manager.canMakePerform(120, 500, scene));

        String msg = canWeMakePerform ? "Yes. We can make show" : "No. It's impossible";

        Printer.printMsg(msg);
/*
//        считаем общий опыт музыкантов(считает дирижёр)
        int totalExp = (int) Kapellmeister.calculateTotal(scene, new Experience());
        System.out.println("Total musicians experience is " + totalExp + " year(s)");

//        считаем общую громкость оркестра(считает дирижёр)
        double totalVolume = Kapellmeister.calculateTotal(scene, new Volume());
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

        Kapellmeister.playMusic(scene);
        


        StageSorter.sort(scene, new SortBySalaryDesc());
        System.out.println(scene);
        */

    }
}
