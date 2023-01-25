package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.model.logic.Finder;
import by.itstep.stpnbelko.javastages.stage20.model.logic.instanceStrategy.*;
import by.itstep.stpnbelko.javastages.stage20.model.logic.salaryFindStrategy.*;
import by.itstep.stpnbelko.javastages.stage20.view.Writer;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'Start' to start program");
        String startWord = scanner.nextLine();
        startWord = startWord.toLowerCase();
        if (!startWord.equals("start")) {
            finish();
        } else {
            //        Выбираем контроллер для создания сцены или чтения её из файла:
//        эти два способа создают:
            ControllerSimpleFactory.FactoryType type = ControllerSimpleFactory.FactoryType.RND;
//        ControllerSimpleFactory.FactoryType type = ControllerSimpleFactory.FactoryType.USER;

//        следующие три читают из файлов SceneSerializator.txt, ByteScene.txt и CharScene.txt соответственно
//        ControllerSimpleFactory.FactoryType type = ControllerSimpleFactory.FactoryType.SERIALIZATION;
//        ControllerSimpleFactory.FactoryType type = ControllerSimpleFactory.FactoryType.FROM_FILE_BYTE;
//        ControllerSimpleFactory.FactoryType type = ControllerSimpleFactory.FactoryType.FROM_FILE_CHAR;

            SceneController controller = ControllerSimpleFactory.getController(type);
//        И создаём при помощи этого контроллера текущую сцену
//        !!!! Самый главный метод:
            controller.createCurrentScene();

//        После того как сцена создана, можем выполнять с ней любые операции через controller
            controller.canMakePerform(120, 220);

            controller.calculateTotalPrice();
            controller.calculateTotalExperience();
            controller.calculateTotalVolume();
            controller.playMusic();

//        можем узнать сколько в оркестре барабанщиков, вокалистов итд

            controller.howManyPercussionists();
            controller.howManySingers();
            controller.howManyViolins();
            controller.howManyUnknownInstances();

//        можем отсортировать музыкантов по громкости, по опыту или по оплате в час

            controller.sortByVolumeAsc();
            controller.sortByVolumeDesc();
            controller.sortByExperienceAsc();
            controller.sortByExperienceDesc();
            controller.sortBySalary();

//        Добавлено. Механизм поиска с использованием паттерна Strategy.
//         Найти музыкантов определённого типа с зарплатой больше(меньше либо равной) заданной
//        Результаты поиска сохраняются в файл searchResult.txt. Просто для разнообразия.
            String msg = String.valueOf(Finder.find(controller.getCurrentScene(), new InstanceOfLeadGuitar()
                    , new SalaryMoreThan(), 50));
            Writer.writeToFile(msg, "searchResult.txt", false);

//        ...либо просто музыкантов с зарплатой больше(меньше либо равной) заданной
            msg = String.valueOf(Finder.find(controller.getCurrentScene(), new SalaryLessThan(), 10));
            Writer.writeToFile(msg, "searchResult.txt", true);

//        ...либо просто музыкантов определённого типа
            msg = String.valueOf(Finder.find(controller.getCurrentScene(), new InstanceOfBassGuitar()));
            Writer.writeToFile(msg, "searchResult.txt", true);


//        Так же мы можем сохранить текущую сцену во все виды файлов
            controller.saveCurrentScene();

//        Результаты работы программы сохраняются в log.txt и выводятся на консоль
            System.out.println("Successfully finished");
        }
    }

    private static void finish() {
        System.out.println("wrong word\n End program");
    }
}
