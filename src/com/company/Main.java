package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;

class Simple{
    private String name;
    private String email;
    private int age;
    private boolean isDeveloper;

    public Simple(String name, String email, int age, boolean isDeveloper){
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper= isDeveloper;

    }
}










public class Main {

    public static void main(String[] args) {
        System.out.println("JSON with gson example");

        //serializeSimple();
        deserializeSimple();

    }

    static void serializeSimple(){
        Simple person = new Simple("me", "jacqueline@gmail.com", 16, true);
        Gson gson = new Gson();
        String json = gson.toJson(person);
        //dont need file writer 
        try {
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(person, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void deserializeSimple(){
        String person2Json = "{\"name\": \"Jackie\", \"email\": \"jacqueline@gmail.com\", \"age\": 16, \"isDeveloper\": true}";
        JsonParser parser = new JsonParser();
        //can delete these 3 lines
        JsonElement text = parser.parse(person2Json);
        System.out.println(text.isJsonObject());
        Gson gson = new Gson();

        Simple simple2 = gson.fromJson(person2Json,Simple.class);

        System.out.println(person2Json.getClass());

    }



}
