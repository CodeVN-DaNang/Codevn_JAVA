package model.service;


import java.util.ArrayList;

import model.entities.Person;
import model.repository.PersonRepo;



public class PersonService {
    PersonRepo personRepo = new PersonRepo();

    public ArrayList<Person> getAll(){
        return personRepo.getAll();
    }

    public Person getById(String id){
        return personRepo.getById(id);
    }

    public void add(Person person) {
        personRepo.add(person);
    }

    public void update(Person person) {
        personRepo.update(person);
    }

    public void delete(String id) {
        personRepo.delete(id);
    }

}
