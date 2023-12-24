package controller;

import view.index;

public class MainController {
    static index index = new index();
    static PersonController personController = new PersonController();
    static BillController billController = new BillController();

    public static void main(String[] args) {
        // while (true) {
            int key = index.display();
            switch (key) {
                case 1:
                    personController.personController();
                    break;
                case 2:
                    billController.billController();
                    break;
                default:
                    break;
            }
        // }

    }
}
