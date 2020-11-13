package tutorials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    String name;
    int age;
    String species;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    ListDemo(String n, int a, String sp)
    {
        this.name = n;
        this.age = a;
        this.species = sp;
    }


    public static void main(String[] args) {

        List<ListDemo> lstdemos = Arrays.asList(
                new ListDemo("JoJo",20,"Mongoloid"),
                new ListDemo("Thomas",21,"Humanoid"),
                new ListDemo("Vector",1000,"Android")
                );


      ListDemo anime=lstdemos.stream().filter(t -> "Thomas".equals(t.getName())).findFirst().orElseThrow(null);

        System.out.println(anime.getName() + " " + anime.getSpecies() + " " +anime.age);


    }





}
