package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Catalyst {
    public static int counter = 0;
    public static void main(String[] args) {
        System.out.println("Zahl eingeben!");
        Scanner scan = new Scanner(System.in);
        primesteps(scan.next());
        System.out.println(counter);
    }

    public static void primesteps(String number){
        BigInteger bigInt = new BigInteger(number);
        if(!bigInt.isProbablePrime(100)){
            return;
        }else if(number.length() == 1){
            counter++;
            return;
        }else{
            for(int index = 0; index < number.length(); index++){
                primesteps(number.substring(0, index) + number.substring(index + 1));
            }
        }
    }
}
