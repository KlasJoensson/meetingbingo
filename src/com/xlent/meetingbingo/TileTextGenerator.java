package com.xlent.meetingbingo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class TileTextGenerator {

	private ArrayList<String> texts;
	
	public TileTextGenerator() {
			populateList();
	}
	
	
	/**
	 * To get the texts.
	 * 
	 * @return An array with the texts
	 */
	public ArrayList<String> getTexts() {
		return texts;
	}
	
	/**
	 * Just to get some output.
	 * //TODO Make it read the real texts from a file... 
	 * 
	 * @throws IOException 
	 */
	private void populateList() {
		texts = new ArrayList<String>();
		
		try {
			Files.lines(Paths.get("resources/texts_eng.txt")).forEach(str -> texts.add(str));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	
	/**
	 * Returns the strings in an random order.
	 * 
	 * @return An array with the texts
	 */
	public ArrayList<String> getRandomizeList() {
		ArrayList<String> randTexts = new ArrayList<String>();
		Random random = new Random();
		
		while (texts.size() > 1) {
			randTexts.add(texts.remove(random.nextInt(texts.size()-1)));
		}
		
		randTexts.add(texts.get(0));
		
		populateList();
		
		return randTexts;
	}
	
	
}
