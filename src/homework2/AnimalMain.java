package homework2;

import homework2.animals.AbsAnimal;
import homework2.connector.MySqlConnector;
import homework2.dao.AnimalTable;
import homework2.data.AnimalTypeData;
import homework2.data.ColorData;
import homework2.data.MenuData;
import homework2.factory.AnimalFactory;
import homework2.tools.IntegerValidator;

import java.sql.SQLException;
import java.util.*;

public class AnimalMain {
    private static Scanner scanner = new Scanner(System.in);
    private static IntegerValidator integerValidator = new IntegerValidator();

    public static void main(String... args) {
        List<AbsAnimal> animal = new ArrayList<>();
        //AbsAnimal newAnimal = null;
        //подключка к БД и загрузка данных в лист
        AnimalTable animalTable = new AnimalTable();
        //animal = animalTable.findAll();

        List<String> menuNames = new ArrayList<>();
        for (MenuData menuData: MenuData.values()) {
            menuNames.add(menuData.name().toLowerCase());
        }

        MenuData menuCommand = null;
        do {
            System.out.println(String.format("Введите одну из команд - %s:",
                                             String.join("/", menuNames)));
            String consoleCommand = scanner.next().trim().toLowerCase();
            if (!menuNames.contains(consoleCommand)) {
                System.out.println("Нет такой команды!");
            } else {
                menuCommand = MenuData.valueOf(consoleCommand.toUpperCase());

                List<String> animalTypeNames = new ArrayList<>();
                for (AnimalTypeData animalTypeData: AnimalTypeData.values()) {
                    animalTypeNames.add(animalTypeData.name().toLowerCase());
                }

                //String consoleAnimal = "";
                //AnimalTypeData animalTypeCommand = null;
                if (menuCommand.equals(MenuData.ADD)) {
                    String consoleAnimal = inputConsoleAnimal(animalTypeNames);
                    AnimalTypeData animalTypeCommand = AnimalTypeData.valueOf(consoleAnimal.toUpperCase());

                    String consoleName = inputConsoleName();

                    int consoleAge = getAnimalWeightAge("Введите возраст животного в годах:",
                            "Возраст должен быть положительным целым числом!");

                    int consoleWeight = getAnimalWeightAge("Введите вес животного в кг.:",
                            "Вес должен быть положительным целым числом!");

                    ColorData colorData = inputColorData();

                    AbsAnimal newAnimal = new AnimalFactory(-1, consoleName, consoleAnimal,
                            consoleAge, consoleWeight, colorData).createAnimal(animalTypeCommand);
                    animalTable.addNewAnimal(newAnimal);
                    newAnimal.say();

                } else if (menuCommand.equals(MenuData.LIST)) {
                    animal = animalTable.findAll();
                    for (AbsAnimal any: animal) {
                        System.out.println(any.toString());
                    }
                    System.out.println();

                } else if (menuCommand.equals(MenuData.EDIT)) {
                    int consoleID = getAnimalWeightAge("Введите ID животного:",
                            "ID должен быть положительным целым числом!");
                    Long searchID = (long) consoleID;
                    AbsAnimal editAnimal = animalTable.findById(searchID);
                    if (editAnimal != null) {
                        System.out.println(editAnimal.toString());

                        //String consoleAnimal = inputConsoleAnimal(animalTypeNames);
                        //AnimalTypeData animalTypeCommand = AnimalTypeData.valueOf(consoleAnimal.toUpperCase());
                        editAnimal.setType(inputConsoleAnimal(animalTypeNames));

                        editAnimal.setName(inputConsoleName());

                        editAnimal.setAge(getAnimalWeightAge("Введите возраст животного в годах:",
                                "Возраст должен быть положительным целым числом!"));

                        editAnimal.setWeight(getAnimalWeightAge("Введите вес животного в кг.:",
                                "Вес должен быть положительным целым числом!"));

                        editAnimal.setColor(inputColorData());

                        animalTable.updateAnimal(editAnimal);

                    } else {
                        System.out.println("Нет животного с таким ID !");
                    }

                } else if (menuCommand.equals(MenuData.FILTER)) {
                    System.out.printf("Введите нужный тип животного для фильтра - %s:\n",
                            String.join("/", animalTypeNames));
                    String consoleAnimal = scanner.next().trim().toLowerCase();

                    if (!animalTypeNames.contains(consoleAnimal)) {
                        System.out.println("Нет такого типа животного.");
                    } else {
                        animal = animalTable.findFilter(consoleAnimal);
                        for (AbsAnimal any: animal) {
                            System.out.println(any.toString());
                        }
                        System.out.println();
                        //animalTypeCommand = AnimalTypeData.valueOf(consoleAnimal.toUpperCase());
                    }

                } else if (menuCommand.equals(MenuData.EXIT)) {
                    System.out.println("Пока");
                }
            }
        } while (menuCommand != MenuData.EXIT);

        try {
            MySqlConnector.getInstance().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getAnimalWeightAge(String promptMessage, String errorMessage) {
        String consoleAgeWeight = "";
        int animalAgeWeight = -1;

        do {
            System.out.println(promptMessage);
            consoleAgeWeight = scanner.next();
            if (!integerValidator.isInteger(consoleAgeWeight)) {
                System.out.println(errorMessage);
            } else {
                animalAgeWeight = Integer.parseInt(consoleAgeWeight);
            }
        } while (!integerValidator.isInteger(consoleAgeWeight));
        return animalAgeWeight;
    }

    private static String inputConsoleAnimal(List<String> animalTypeNames) {
        String consoleAnimal = null;
        do {
            System.out.printf("Введите нужный тип животного - %s:\n",
                    String.join("/", animalTypeNames));
            consoleAnimal = scanner.next().trim().toLowerCase();

            if (!animalTypeNames.contains(consoleAnimal)) {
                System.out.println("Нет такого типа животного.");
            } else {
                //animalTypeCommand = AnimalTypeData.valueOf(consoleAnimal.toUpperCase());
            }
        } while (!animalTypeNames.contains(consoleAnimal));
        return consoleAnimal;
    }

    private static String inputConsoleName() {
        String consoleName;
        do {
            System.out.println("Введите имя животного:");
            consoleName = scanner.next().trim();
            consoleName = consoleName.substring(0,1).toUpperCase()
                    + consoleName.substring(1).toLowerCase();

            if (consoleName.isEmpty()) {
                System.out.println("Имя животного не должно быть пустым!");
            }
        } while (consoleName.isEmpty());
        return consoleName;
    }

    private static ColorData inputColorData() {
        List<String> animalsColor = new ArrayList<>();
        for (ColorData colorData: ColorData.values()) {
            animalsColor.add(colorData.name().toLowerCase());
        }

        String consoleColor = "";
        ColorData colorData = null;
        do {
            System.out.printf("Введите цвет окраса животного: %s\n",
                    String.join("/", animalsColor));
            consoleColor = scanner.next().trim().toLowerCase();

            if (!animalsColor.contains(consoleColor)) {
                System.out.println("Нет такого цвета окраса животного.");
            } else {
                colorData = ColorData.valueOf(consoleColor.toUpperCase());
            }
        } while (!animalsColor.contains(consoleColor));
        return colorData;
    }

}
