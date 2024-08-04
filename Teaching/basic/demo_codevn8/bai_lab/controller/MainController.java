package controller;

import view.Menu;

public class MainController extends Menu {

    Store store = new Store();

    public MainController(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                store.addNewStaff();
                break;
            case 2:
                store.displayAll();
                break;
            case 3:
                store.sort();
                break;
            case 4:
                store.search();
                store.delete();
                break;
            case 5:
                store.avgEachStaff();
                break;
            default:
                break;
        }
    }

}
