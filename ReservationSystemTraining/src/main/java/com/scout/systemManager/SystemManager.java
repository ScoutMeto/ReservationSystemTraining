package com.scout.systemManager;


import org.yaml.snakeyaml.Yaml;

import java.io.*;

import java.util.*;
import java.lang.System;


public class SystemManager {
    Scanner sc = new Scanner(System.in);


    Yaml yaml = new Yaml();

    public void reserveStay() { //method providing reservation

        InputStream inputStream;

        {
            try {
                inputStream = new FileInputStream("src/main/resources/data.yaml");  //path
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        Map<String, Map<String, Integer>> data = yaml.load(inputStream); //loading data from data.yaml - next upgrade them and save back
        //saving method: Directories/Maps (https://www.youtube.com/watch?v=0fbnyS_lHW4)

        System.out.println("How much people need accommodation?");  //customer counter question

        int customer = sc.nextInt();    //customer counter variable

        List<String> availableRooms = new ArrayList<>();    //list variable for recording available room(s)
        List<String> priceNight = new ArrayList<>();    //list variable for recording available room(s)

        for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {  //foreach loop
            String roomName = entry.getKey();   //getting key of items room_001, room_002, ...;
            Map<String, Integer> roomDetails = entry.getValue(); //getting value of each item (for example room_001); the key is people_amount / price/ breakfast / etc.; the value is the price (60,-)

            int peopleAmount = (int) roomDetails.get("people_amount");  //getting value of key "people_amount" from .yaml and save it in the int peopleAmount variable
            int priceForNight = (int) roomDetails.get("price_night");
            if (customer <= peopleAmount) { //comparison customer answer and available beds in each room
                availableRooms.add(roomName);   //add name of room (001, ...) to the list
                priceNight.add(String.valueOf(priceForNight)); //add price for room
            } else {
                System.out.println("For " + customer + " we have no enough capacity in " + roomName + ". If you want this room, we can accommodate here " + peopleAmount + " of your group. You must split up your group among more rooms.");
            }

        }

        System.out.println("You can use room(s) " + availableRooms);  //control statement
        System.out.println("Price for a night for room(s) is  " + priceNight);
        System.out.println("Which room do you prefer? Type whole marking. For example: room_001. If you use invalid marks, your room could not be reserved.");

        String room = sc.next(); //customer choosing concrete room


        boolean reserved = false; //variable in basic set-up. Need for verify, if customer choice (room number) is on list of accessible rooms

        for (String checking : availableRooms) {    //process of verification variables "room" and "availableRooms"
            if (checking.equals(room)) {
                reserved = true;
                break; //if reserved is approved, stop verify
            }
        }


        if (reserved) { //if OK
            System.out.println("Your room is now reserved. You can choose number of nights and food for guests in concrete room.");
            System.out.println("How long you stay in hotel?");

            int nightsNumber = sc.nextInt();

            System.out.println("Order your meal, now. Do you want breakfast, lunch or dinner? ('y' for yes / random char for 'no')");
                String mealOrder; //yes; everything else mean "no"
                mealOrder = sc.next(); //choice
                if (mealOrder.equals("y")) {    //choosing number of meals
                    System.out.println("Choose number of meals:");
                    System.out.println("Breakfast (30,-/1 meal):");
                    int breakfast = 0;
                    breakfast = sc.nextInt();
                    System.out.println("Lunch: (40,-/1 meal)");
                    int lunch = 0;
                    lunch = sc.nextInt();
                    System.out.println("Dinner (25,-/1 meal):");
                    int dinner = 0;
                    dinner = sc.nextInt();

                    Map<String, Integer> mealData = new HashMap<>();
                    mealData.put("breakfast", breakfast);
                    mealData.put("lunch", lunch);
                    mealData.put("dinner", dinner);

                    data.put("mealData", mealData);

                    //writing new data to the data.yaml, exception included
                    try(FileWriter writer = new FileWriter("data.yaml")) {
                        yaml.dump(data, writer);
                        System.out.println("Meal order saved.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }




                } else {
                        System.out.println("No meal ordered.");
                    }

            //final summary and cost of order
            System.out.println("--- Final summary ---");

            Map<String, Integer> mealData = data.get("mealData"); //meals data loading
            int breakfast = mealData.get("breakfast");
            int lunch = mealData.get("lunch");
            int dinner = mealData.get("dinner");


            Map<String, Integer> roomDetails = data.get(room); //room price loading by name of room
            Integer pricePerNight = roomDetails.get("price_night");

            System.out.println("You ordered " + room + " for " + nightsNumber + " nights(" + pricePerNight*nightsNumber + ",-), with number of breakfast(s): " + breakfast + "(" + breakfast*30 + ",-), number of lunch(es): " + lunch + "(" + lunch*40 + ",-), and number of dinner(s): " + dinner + "(" + dinner*25 + "),-.");


        } else {    //if room is not accessible or not exist
            System.out.println("This room is not at offer list. Think about your needs and repeat reservation process.");
        }





    }

}
