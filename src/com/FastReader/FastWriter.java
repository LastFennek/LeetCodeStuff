package com.fabiankranewitter.fasterlib.reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FastWriter {

	
	private String data = new String();
	
	public FastWriter() {
	}
	
	public void addData(String s) {
		data+=s;
	}
	
	public void addData(int i) {
		data+=i;
	}
	
	public void addData(float f) {
		data+=f;
	}
	
	public void addData(ArrayList<String> data,String splitdata) {
		for(String line:data) {
			this.data+=line;
			if(splitdata!=null) {
				this.data+=splitdata;
			}
		}
	}
	
	public void clear() {
		data = new String();
	}
	public String getData() {
		return data;
	}

	public void write(String file) throws IOException {
		write(new File(file));
	}
	
	public void write(File file) throws IOException {
		if(file.exists()) {
			System.out.println("File override");
			file.delete();
		}
		System.out.println("Write to "+file.getAbsolutePath());
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		bufferedWriter.write(this.data);
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
}
