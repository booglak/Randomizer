package com.example.igor.randomizer;


import java.util.ArrayList;
import java.util.Random;

public class InputRandom {

    int randomResult;
    String result;

    public String Result3 (ArrayList array){
        Random random = new Random();
        randomResult = random.nextInt(array.size());
        result = array.get(randomResult).toString();
        return result;
    }
}
