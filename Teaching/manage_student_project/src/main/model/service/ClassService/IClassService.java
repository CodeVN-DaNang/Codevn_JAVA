package main.model.service.ClassService;

import java.util.ArrayList;

import main.model.entity.ClasS;

public interface IClassService {
    public ArrayList<ClasS> findAllClass();
    public ClasS findClassById(int idClass);
    public boolean addNewClass(ClasS newClass);
    public boolean deleteClass(int idClass);
    public boolean updateClass(ClasS newClass);
}
