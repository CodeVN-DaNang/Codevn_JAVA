import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal2 = new Dog();
        Animal animal3 = new Cat();
        List<Animal> animalList = new ArrayList<>();
        animalList.add(animal);
        animalList.add(animal2);
        animalList.add(animal3);
        for (Animal animal4 : animalList) {
            System.out.println(animal4.voice());
        }
    }
}
