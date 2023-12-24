package model.service;

import java.util.ArrayList;

import model.entity.Person;
import model.repository.PersonRepository;

public class PersonService {
    PersonRepository personRepository = new PersonRepository();

    public ArrayList<Person> getAllPersons() {
        return this.personRepository.getAllPersons();
    }

    public Person getPersonById(int id){
        return this.personRepository.getByIndex(id);
    }

    public ArrayList<Person> findByName(String name) {
        ArrayList<Person> persons = getAllPersons();
        ArrayList<Person> finds = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().contains(name)) {
                finds.add(persons.get(i));
            }
        }
        return finds;
    }

    public boolean addNew(Person person) {
        return this.personRepository.addNew(0, person);
    }

    public void edit(int index, Person person) {
        this.personRepository.delete(index);
        this.personRepository.addNew(index, person);
    }

    public void delete(int index) {
        this.personRepository.delete(index);
    }

}
