package main.model.service.ClassService;

import java.util.ArrayList;

import main.model.entity.ClasS;
import main.model.repository.ClassRepository;

public class ClassService implements IClassService {

    ClassRepository classRepository = new ClassRepository();
    @Override
    public ArrayList<ClasS> findAllClass() {
        // TODO Auto-generated method stub
        return classRepository.findAllClass();
    }

    @Override
    public boolean addNewClass(ClasS newClass) {
        // TODO Auto-generated method stub
        if (classRepository.createClass(newClass) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteClass(int idClass) {
        // TODO Auto-generated method stub
        if (classRepository.deleteClass(idClass) > 0) {
            return true;
        } else {
            return false;
        }    }

    @Override
    public boolean updateClass(ClasS newClass) {
        // TODO Auto-generated method stub
        if (classRepository.updateClass(newClass) > 0) {
            return true;
        } else {
            return false;
        }    }

    @Override
    public ClasS findClassById(int idClass) {
        // TODO Auto-generated method stub
        return classRepository.findClassById(idClass);
    }
    
}
