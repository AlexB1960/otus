package homework2.dao;

import homework2.animals.AbsAnimal;

import java.util.List;

public interface IAnimalTable {
    List<AbsAnimal> findAll();
    AbsAnimal findById(Long searchId);
    void addNewAnimal(AbsAnimal absAnimal);
}
