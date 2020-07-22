package com.fabiankranewitter.fasterlib.reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FastReader {
	
	private FastReaderListener fastReaderListener;
	private File file;
	private boolean run = false;
	private long skip = 0;
	
	
	public FastReader(String path) {
		this.file = new File(path);
	}
	
	public FastReader(File file) {
		this.file = file;
	}
	
	public FastReader(String path,FastReaderListener fastReaderListener) {
		this.file = new File(path);
		this.fastReaderListener = fastReaderListener;
	}
	
	public FastReader(File file,FastReaderListener fastReaderListener) {
		this.file = file;
		this.fastReaderListener = fastReaderListener;
	}
	
	public FastReaderListener getFastReaderListener() {
		return fastReaderListener;
	}
	
	
	public void setFastReaderListener(FastReaderListener fastReaderListener) {
		this.fastReaderListener = fastReaderListener;
	}
	
	
	public File getFile() {
		return file;
	}
	
	public void stop() {
		this.run = false;
	}
	
	public boolean isRunning() {
		return run;
	}
	
	
	public FastReader skip(long pos) {
		skip = pos;
		return this;
	}
	
	public long getSkipPos() {
		return skip;
	}
	
	public void start() throws FileNotFoundException,IOException {
		if(!(file.exists()&&file.isFile()&&!file.isDirectory()&&file.canRead())) {
			throw new FileNotFoundException();
		}
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		long pos = 0;
		bufferedReader.skip(skip);
		System.out.println("Start reading file: '"+file.getAbsolutePath()+"'");
		String line;
		this.run = true;
		while ((line = bufferedReader.readLine()) != null) {
		    if(fastReaderListener==null) {
		    	System.err.println("FastReadListerner is null");
		    	break;
		    }
		    if(!run) {
		    	System.err.println("Reading stop");
		    	break;
		    }
		    fastReaderListener.onLineRead(pos, line);
		    pos++;
		}
		run = false;
		if(bufferedReader!=null) {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
}
