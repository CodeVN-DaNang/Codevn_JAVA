package model.service;

import java.util.ArrayList;

import model.entity.Engineer;
import model.repository.EngineerRepo;

public class EngineerService {
    EngineerRepo engineerRepo = new EngineerRepo();

    public ArrayList<Engineer> getAllEngineers(){
        return engineerRepo.getAllEngineers();
    }

    public Engineer getEngineerById(int id){
        return engineerRepo.getEngineerById(id);
    }

    public void addEngineer(Engineer engineer){
        engineerRepo.addEngineer(engineer);
    }

    public void deleteEngineer(int id){
        engineerRepo.deleteEngineer(id);
    }

    public void updateEnginner(int index, Engineer engineer){
        engineerRepo.updateEnginner(index, engineer);
    }

}
