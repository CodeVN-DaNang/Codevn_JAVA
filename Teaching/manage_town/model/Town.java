package manage_town.model;

import java.util.ArrayList;

public class Town {
    private ArrayList<Family> town = new ArrayList<>();

    public Town(ArrayList<Family> town) {
        this.town = town;
    }

    public ArrayList<Family> getTown() {
        return town;
    }

    public void setTown(ArrayList<Family> town) {
        this.town = town;
    }

    @Override
    public String toString() {
        String allFam = "";
        for (int i = 0; i < town.size(); i++) {
            allFam += i + ". " + town.get(i).toString() + "\n";
        }
        return "Town [town=" + allFam + "]";
    }
}
