package homework2.dao;

import homework2.ConnectionManager;
import homework2.animals.AbsAnimal;
import homework2.data.AnimalTypeData;
import homework2.data.ColorData;
import homework2.factory.AnimalFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnimalTable extends AbsTable implements IAnimalTable {
    public AnimalTable() {
        super("animals");
        columns.put("id", "bigint PRIMARY KEY AUTO_INCREMENT");
        columns.put("name", "varchar(15)");
        columns.put("type", "varchar(15)");
        columns.put("age", "int");
        columns.put("weight", "int");
        columns.put("color", "varchar(15)");
        create();
    }

    public List<AbsAnimal> findAll() {
        List<AbsAnimal> animals = new ArrayList<>();
        try (ResultSet rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM "
                                                                         + tableName)) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int age = rs.getInt("age");
                int weight = rs.getInt("weight");
                String color = rs.getString("color");

                ColorData colorData = ColorData.valueOf(color.toUpperCase());
                AnimalTypeData animalTypeCommand = AnimalTypeData.valueOf(type.toUpperCase());

                animals.add(new AnimalFactory(id, name, type, age, weight,
                        colorData).createAnimal(animalTypeCommand));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animals;
    }

    public AbsAnimal findById(Long searchId) {
        AbsAnimal animalFind = null;
        try (ResultSet rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM "
                            + tableName + " WHERE id=" + searchId)) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int age = rs.getInt("age");
                int weight = rs.getInt("weight");
                String color = rs.getString("color");

                ColorData colorData = ColorData.valueOf(color.toUpperCase());
                AnimalTypeData animalTypeCommand = AnimalTypeData.valueOf(type.toUpperCase());

                animalFind = new AnimalFactory(id, name, type, age, weight,
                        colorData).createAnimal(animalTypeCommand);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animalFind;
    }

    public void addNewAnimal(AbsAnimal absAnimal) {
        String sqlUpdate = "INSERT INTO " + tableName
                + " (name, type, age, weight, color) VALUES ('" + absAnimal.getName() + "', '"
                + absAnimal.getType() + "', " + absAnimal.getAge() + ", " + absAnimal.getWeight()
                + ", '" + absAnimal.getColor().name().toLowerCase() + "')";
        try {
            ConnectionManager.getInstance().executeUpdate(sqlUpdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAnimal(AbsAnimal absAnimal) {
        String sqlUpdate = "UPDATE " + tableName + " SET name='" + absAnimal.getName() + "',"
                + " type='" + absAnimal.getType() + "', age=" + absAnimal.getAge() + ", weight="
                + absAnimal.getWeight() + ", color='" + absAnimal.getColor().name().toLowerCase()
                + "' WHERE id=" + absAnimal.getId();
        try {
            ConnectionManager.getInstance().executeUpdate(sqlUpdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<AbsAnimal> findFilter(String filterType) {
        List<AbsAnimal> animals = new ArrayList<>();
        try (ResultSet rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM "
                            + tableName + " WHERE type='" + filterType + "'")) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int age = rs.getInt("age");
                int weight = rs.getInt("weight");
                String color = rs.getString("color");

                ColorData colorData = ColorData.valueOf(color.toUpperCase());
                AnimalTypeData animalTypeCommand = AnimalTypeData.valueOf(type.toUpperCase());

                animals.add(new AnimalFactory(id, name, type, age, weight,
                        colorData).createAnimal(animalTypeCommand));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animals;
    }

}
