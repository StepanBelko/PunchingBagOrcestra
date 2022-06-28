package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.entity.container.Scene;
import by.itstep.stpnbelko.javastages.stage20.util.exceptions.SceneFileNotFoundException;

import static by.itstep.stpnbelko.javastages.stage20.control.ControllerSimpleFactory.addController;


public class Main {
    public static void main(String[] args) throws SceneFileNotFoundException {
          addController(ControllerSimpleFactory.FactoryType.USER, new FourthControllerUserRockBand());
          addController(ControllerSimpleFactory.FactoryType.SERIALIZATION, new FifthControllerSerialization());

          ControllerSimpleFactory.FactoryType type = ControllerSimpleFactory.FactoryType.SERIALIZATION;

          SceneController controller = ControllerSimpleFactory.getController(type);

          controller.canMakePerform(120,500);


//        System.out.println(SceneSerializator.read());


//        System.out.println(Manager.canMakePerform(120,500,scene));

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
