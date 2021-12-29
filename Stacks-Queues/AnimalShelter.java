import java.util.*;

public class AnimalShelter {

    int count;
    Queue<Animal> dogs;
    Queue<Animal> cats;
    public AnimalShelter()
    {
        count = 0;
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }
    public void enqueue(String name)
    {
        if(name.equals("dog"))
        {
            Animal animal = new Animal(name, count);
            count++;
            dogs.add(animal);
        }
        else if(name.equals("cat"))
        {
            Animal animal = new Animal(name, count);
            count++;
            cats.add(animal);
        }
    }

    public void dequeueAny()
    {
        if(cats.size() == 0 && dogs.size() == 0)
        {
            return;
        }
        else if(dogs.size() == 0 || cats.peek().getAge() < dogs.peek().getAge())
        {
            cats.remove();
        }
        else
        {
            dogs.remove();
        }
    }
    public void dequeueDog()
    {
        if(dogs.size() == 0)
        {
            return;
        }
        else
        {
            dogs.remove();
        }
    }
    public void dequeueCat()
    {
        if(cats.size() == 0)
        {
            return;
        }
        else
        {
            cats.remove();
        }
    }
}

class Animal {
    String myName;
    int myAge;
    public Animal(String name, int age)
    {
        myName = name;
        myAge = age;
    }
    public int getAge(){return myAge;}
    public String getName(){return myName;}
}
