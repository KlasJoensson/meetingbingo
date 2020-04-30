package com.xlent.meetingbingo;

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
	 */
	private void populateList() {
		texts = new ArrayList<String>();
		
		for(int i=1;i<6;i++) {
			for(int j=1;j<6;j++) {
				texts.add("[" + i + "," + j + "]");
			}
		}
		
		
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
