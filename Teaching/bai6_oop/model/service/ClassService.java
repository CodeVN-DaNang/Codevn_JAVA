package model.service;

import java.util.ArrayList;

import model.entity.ClasS;
import model.repository.ClassRepository;

public class ClassService {

    ClassRepository classRepository = new ClassRepository();

    public ArrayList<ClasS> getAlClasSs() {
        return classRepository.getAlClasSs();
    }

    public ClasS getClassById(int index) {
        return classRepository.getClassByIndex(index);
    }
}
