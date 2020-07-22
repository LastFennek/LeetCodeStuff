package com.fabiankranewitter.fasterlib.reader;

public interface FastReaderListener {
	
	void onLineRead(long pos,String line);
	
}
