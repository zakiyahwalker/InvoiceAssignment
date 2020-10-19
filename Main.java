package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> products = new ArrayList<String>();
        ArrayList<Double> prices = new ArrayList<Double>();
        products.add("Bison Sweater");
        prices.add(55.99);
        products.add("Bison Tee");
        prices.add(14.99);
        products.add("Bison Hoodie");
        prices.add(23.99);
        products.add("Bison Bumpersticker");
        prices.add(4.99);

        Scanner input = new Scanner(System.in);
        String answer = "";
        ArrayList<String> invProds = new ArrayList<String>();
        ArrayList<Double> invPrices = new ArrayList<Double>();

        do {
            System.out.println("What do you want to do?");
            System.out.println("1) Add purchase 2) Change purchase 3) Show purchases 4) Finish transaction");
            answer = input.nextLine();

            if (answer.equals("1")) {
                for (int i = 0; i < products.size(); i++) {
                    System.out.println(products.get(i) + " for $" + prices.get(i));
                }
                System.out.println();
                System.out.println("What item do you want to add?");
                String prod = input.nextLine();
                int index = -1;
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).equals(prod)) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Sorry, we don't sell that item");
                } else {
                    String purProd = products.get(index);
                    Double purPrice = prices.get(index);
                    invProds.add(purProd);
                    invPrices.add(purPrice);
                }

            } else if (answer.equals("2")) {
                System.out.println("Current items in purchase:");
                for (int i = 0; i < invProds.size(); i++) {
                    System.out.println(invProds.get(i) + " : $" + invPrices.get(i));
                }
                System.out.println("What item do you want to remove from purchase?");
                String prod = input.nextLine();
                int index = -1;
                for (int i = 0; i < invProds.size(); i++) {
                    if (invProds.get(i).equals(prod)) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Sorry, you never added that item to your purchase");
                } else {
                    invProds.remove(index);
                    invPrices.remove(index);
                }
            } else if (answer.equals("3")) {
                for (int i = 0; i < invProds.size(); i++) {
                    System.out.println(invProds.get(i) + " : $" + invPrices.get(i));
                }
            }

        } while (! answer.equals("4"));
        float total = 0f;
        for (int i = 0; i < invPrices.size(); i++) {
            double item = invPrices.get(i);
            total += item;
        }
        System.out.println("Your order total is: $" + total);
        System.out.println("Thank you for ordering!");
    }
}
