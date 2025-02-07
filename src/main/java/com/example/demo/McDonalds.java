package com.example.demo;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class McDonalds {
    Map<String, Item> menu = new HashMap<>();
    public McDonalds() {
        File file = new File("mcdonalds.txt");

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null){
                String[] tokens = line.split(",");
                Item item = new Item(
                        tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]));
                menu.put(item.id, item);
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("讀取menu失敗");
        }

    }

    public void printMenu(){
        for (Map.Entry<String, Item> itemEntry : menu.entrySet()) {
            System.out.println(itemEntry.getValue());
        }
    }


    public static void main(String[] args) {
        McDonalds mcDonalds = new McDonalds();
        mcDonalds.printMenu();
    }
}


class Item {
    String id;
    String name;
    int calories;
    int price;

    @Override
    public String toString() {
        return id + "," + name + "," + calories + "," + price ;
    }

    public Item(String id, String name, int calories, int price) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}