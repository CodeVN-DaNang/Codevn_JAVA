package model.repository;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.Person;


public class PersonRepo {

    ArrayList<Person> people = new ArrayList<>();

    public void read(){
        people.clear();
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn9/demo_bai2/data/dataPeople.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                String job = arr[2];
                String id = arr[3];
                String homeNumber = arr[4];
                Person person = new Person(name, age, job, id, homeNumber);
                people.add(person);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(){
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn9/demo_bai2/data/dataPeople.txt");
            String line = "";
            for (Person person : people) {
                line += person.getName() + "," + person.getAge() + "," + person.getJob() + "," + person.getId() + "," + person.getHomeNumber() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

   

    public ArrayList<Person> getAll(){
        read();
        return this.people;
    }

    public Person getById(String id){
        read();
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public void add(Person person) {
        read();
        people.add(person);
        write();
    }

    public void update(Person person) {
        read();
        int count = 0;
        for (Person person2 : people) {
            if (person2.getId().equals(person.getId())) {
                people.set(count, person);
                return;
            }
            count++;
        }
        write();
    }

    public void delete(String id) {
        read();
        for (Person person : people) {
            if (person.getId().equals(id)) {
                people.remove(person);
            }
        }
        write();
    }
}
