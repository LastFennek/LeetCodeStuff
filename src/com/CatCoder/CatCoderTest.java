package com.CatCoder;

import java.io.FileReader;

public class CatCoderTest {

    public static void main(String[] args) throws Exception
    {
        myFileReader mfr = new myFileReader("/home/taletale/IdeaProjects/LeetCodeStuff/src/com/CatCoder/level1_1.in");
        System.out.println(mfr.getInt(0));
        System.out.println(mfr.arrInt(1)[0]);
        System.out.println(mfr.getRow(0));
        System.out.println(mfr.arrDouble(3)[0]);
        for(int i = 5; i < 7500; i++){
            int x = mfr.getInt(i);
            //System.out.println(mfr.getInt(i));
        }
        System.out.println("finish");
    }
}
