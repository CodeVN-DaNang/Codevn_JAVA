package model.repository;

import java.util.ArrayList;

import model.entity.Person;

public class PersonRepository {
    private ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getAllPersons() {
        return this.persons;
    }

    public Person getByIndex(int index) {
        return this.persons.get(index);
    }

    public boolean addNew(int index, Person person) {
        return this.persons.add(person);
    }

    public void edit(int index, Person person) {
        this.persons.remove(index);
        this.persons.add(index, person);
    }

    public void delete(int index) {
        this.persons.remove(index);
    }

}
