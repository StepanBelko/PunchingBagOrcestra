package by.itstep.stpnbelko.javastages.stage20.control;

import by.itstep.stpnbelko.javastages.stage20.util.exceptions.tecnicalException.SceneFileNotFoundException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws SceneFileNotFoundException {
//        Выбираем контроллер для создания сцены или чтения её из файла:
//        эти два способа создают:
        ControllerSimpleFactory.FactoryType type = ControllerSimpleFactory.FactoryType.RND;
//        ControllerSimpleFactory.FactoryType type = ControllerSimpleFactory.FactoryType.USER;

//        следующие три читают из файла
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

//        так же можем отсортировать музыкантов по громкости, по опыту или по оплате в час
        controller.sortByVolumeAsc();
        controller.sortByVolumeDesc();
        controller.sortByExperienceAsc();
        controller.sortByExperienceDesc();
        controller.sortBySalary();


        //        Так же мы можем сохранить текущую сцену во все виды файлов
        try {
            controller.saveCurrentScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Результаты работы программы сохраняются в log.txt и выводятся на консоль
    }
}
