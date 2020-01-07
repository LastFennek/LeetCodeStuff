package com.company;

import java.util.*;

public class Kattis {
    public static void main(String[] args) {

    }

    public static void taxing(){
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        TreeMap<Double, double[]> tb = new TreeMap<>();
        tb.put(0.0,new double[]{0,0});
        int i = scan.nextInt();

        if(i > 0){

            double brd = scan.nextDouble();
            double przt = scan.nextByte();
            tb.put(brd, new double[]{przt,przt});
            double lstBrd = brd;
            for(int x = 1; x < i; x++){
                brd = scan.nextDouble();
                przt = scan.nextByte();

                tb.put(brd,new double[]{przt,(lstBrd*(tb.get(lstBrd)[1]/100)+(brd-lstBrd)*przt)/(lstBrd+brd)});

                lstBrd = brd;
            }
            double x = scan.nextDouble();
            tb.put(1e6+1,new double[]{x,x});
        }
        scan.match();
        while(scan.hasNext()){

            double earnd = scan.nextDouble();
            double gft = scan.nextDouble();



            sb.append(4);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
