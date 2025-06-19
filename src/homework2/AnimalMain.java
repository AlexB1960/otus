package homework2;

import homework2.animals.AbsAnimal;
import homework2.data.AnimalTypeData;
import homework2.data.ColorData;
import homework2.data.MenuData;
import homework2.factory.AnimalFactory;
import homework2.tools.IntegerValidator;
import java.util.*;

public class AnimalMain {
    private static Scanner scanner = new Scanner(System.in);
    private static IntegerValidator integerValidator = new IntegerValidator();

    public static void main(String... args) {
        List<AbsAnimal> animal = new ArrayList<>();

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

                AnimalTypeData animalTypeCommand = null;
                String consoleAnimal = "";
                if (menuCommand.equals(MenuData.ADD)) {
                    do {
                        System.out.printf("Введите нужный тип животного - %s:\n",
                                          String.join("/", animalTypeNames));
                        consoleAnimal = scanner.next().trim().toLowerCase();

                        if (!animalTypeNames.contains(consoleAnimal)) {
                            System.out.println("Нет такого типа животного.");
                        } else {
                            animalTypeCommand = AnimalTypeData.valueOf(consoleAnimal.toUpperCase());
                        }

                    } while (!animalTypeNames.contains(consoleAnimal));

                    String consoleName = "";
                    do {
                        System.out.println("Введите имя животного:");
                        consoleName = scanner.next().trim();
                        consoleName = consoleName.substring(0,1).toUpperCase()
                                      + consoleName.substring(1).toLowerCase();

                        if (consoleName.isEmpty()) {
                            System.out.println("Имя животного не должно быть пустым!");
                        }

                    } while (consoleName.isEmpty());

                    int consoleAge = getAnimalWeightAge("Введите возраст животного в годах:",
                            "Возраст должен быть положительным целым числом!");

                    int consoleWeight = getAnimalWeightAge("Введите вес животного в кг.:",
                            "Вес должен быть положительным целым числом!");

                    List<String> animalsColor = new ArrayList<>();
                    for (ColorData colorData: ColorData.values()) {
                        animalsColor.add(colorData.name().toLowerCase());
                    }

                    ColorData colorData = null;
                    String consoleColor = "";
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

                    animal.add(new AnimalFactory(consoleName, consoleAge, consoleWeight,
                                                 colorData).createAnimal(animalTypeCommand));
                    animal.getLast().say();

                } else if (menuCommand.equals(MenuData.LIST)) {
                    for (AbsAnimal any: animal) {
                        System.out.println(any.toString());
                    }
                } else if (menuCommand.equals(MenuData.EXIT)) {
                    System.out.println("Пока");
                }
            }
        } while (menuCommand != MenuData.EXIT);
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

}
