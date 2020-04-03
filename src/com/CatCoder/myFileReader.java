package com.CatCoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class myFileReader {

    String filename = "";
    public myFileReader(String filename){
        this.filename = filename;
        setFile();
    }

    public void setFile(){
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getInt(int row){
        int ret = 0;
        try {
            Scanner scanner = new Scanner(new File(filename));
            for (int i = 0; i < row; i++) {
                scanner.nextLine();
            }
            ret = Integer.parseInt(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public int[] arrInt(int row){

        String test = "";
        try {
            Scanner scanner = new Scanner(new File(filename));
            for (int i = 0; i < row; i++) {
                scanner.nextLine();
            }
            test = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] integerStrings = test.split(" ");
        int[] integers = new int[integerStrings.length];

        for (int i = 0; i < integers.length; i++){
            integers[i] = Integer.parseInt(integerStrings[i]);

        }
        return integers;
    }

    public Double getDouble(int row){
        Double ret = 0.0;
        try {
            Scanner scanner = new Scanner(new File(filename));
            for (int i = 0; i < row; i++) {
                scanner.nextLine();
            }
            ret = Double.parseDouble(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Double[] arrDouble(int row){
        String test = "";
        try {
            Scanner scanner = new Scanner(new File(filename));
            for (int i = 0; i < row; i++) {
                scanner.nextLine();
            }
            test = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] integerStrings = test.split(" ");
        Double[] integers = new Double[integerStrings.length];

        for (int i = 0; i < integers.length; i++){
            integers[i] = Double.parseDouble(integerStrings[i]);

        }
        return integers;
    }

    public String getRow(int row){
        try {
            Scanner scanner = new Scanner(new File(filename));
            for (int i = 0; i < row; i++) {
                scanner.nextLine();
            }
            return scanner.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }


}
