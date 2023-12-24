package model.repository;

import java.util.ArrayList;

import model.entity.ClasS;

public class ClassRepository {
    ArrayList<ClasS> clasSs = new ArrayList<>();

    public ArrayList<ClasS> getAlClasSs() {
        clasSs.clear();
        ClasS clasS = new ClasS("A1", "IT");
        clasSs.add(clasS);
        ClasS clasS1 = new ClasS("A2", "AI");
        clasSs.add(clasS1);
        return this.clasSs;
    }

    public ClasS getClassByIndex(int index) {
        return this.clasSs.get(index);
    }

    public void addClass(ClasS clasS) {
        this.clasSs.add(clasS);
    }

    public void deleteClass(int index) {
        this.clasSs.remove(index);
    }

    public void editClass(int index, ClasS clasS) {
        this.clasSs.remove(index);
        this.clasSs.add(index,clasS);
    }
}
