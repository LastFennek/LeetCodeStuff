package com.fabiankranewitter.fasterlib.reader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		
		FastReader f = new FastReader("/home/fabiankranewitter/fabiankranewitter.pdf",new FastReaderListener() {
			
			@Override
			public void onLineRead(long pos, String line) {
				System.out.println(pos +"| "+line);
			}
		});
		f.start();
		
		
		
	}
	
}
