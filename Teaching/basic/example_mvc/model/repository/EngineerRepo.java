package model.repository;

import java.util.ArrayList;

import model.entity.Engineer;

public class EngineerRepo {
    ArrayList<Engineer> engineerList = new ArrayList<>();

    public ArrayList<Engineer> getAllEngineers(){
        return engineerList;
    }

    public Engineer getEngineerById(int id){
        for (Engineer engineer : engineerList) {
            if (engineer.getId() == id) {
                return engineer;
            }
        }
        return null;
    }

    public void addEngineer(Engineer engineer){
        engineerList.add(engineer);
    }

    public void deleteEngineer(int id){
        engineerList.remove(id);
    }

    public void updateEnginner(int index, Engineer engineer){
        engineerList.set(index, engineer);
    }

}
