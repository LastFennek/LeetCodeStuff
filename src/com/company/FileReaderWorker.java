package com.company;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileReaderTest {

    public static void main(String[] args) throws IOException {
        FileReaderWorker frw = new FileReaderWorker();
        frw.printContents(null);
    }

}

class FileReaderWorker{

    public void printContents(final String FILENAME) throws IOException {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(FILENAME));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (NullPointerException | IOException e) {
            System.out.println("Konnte Datei nicht lesen!");
            e.printStackTrace();

        } finally {



                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();


        }
    }
}