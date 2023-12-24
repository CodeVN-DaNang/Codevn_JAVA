package controller;

import java.util.ArrayList;

import model.entity.Person;
import model.service.PersonService;
import view.PersonMenu;

public class PersonController {
    PersonMenu personMenu = new PersonMenu();
    PersonService personService = new PersonService();
    public void personController() {
        int key = personMenu.displayPersonMenu();
        switch (key) {
            case 1:
                addPerson();
                break;
        
            default:
                break;
        }
    }

    public ArrayList<Person> getAllPerson() {
        return personService.getAllPersons();
    }

    public Person findById(int id) {
        return personService.getPersonById(id);
    }

    public Person addPerson() {
        Person person = personMenu.addView();
        if (personService.addNew(person)) {
            System.out.println("Add Successful");
        }
        return person;
    }
}
