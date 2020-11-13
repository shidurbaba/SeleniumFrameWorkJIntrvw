package tutorials;

import java.util.Arrays;
import java.util.List;

public class DemoStreams
{
    public static void main(String[] args) {

        String listOfClothes = "Pants;trousers;shirts;polos";

        List<String> collectionOfClothing= Arrays.asList(listOfClothes.split(";"));

        String output = collectionOfClothing.stream().filter(s ->
                s.contains("Pants")).findFirst().orElse( "Not found");


    }
}
