package com.xlent.meetingbingo;

import java.util.ArrayList;

public class TileTexts {

	private ArrayList<String> texts;
	
	public TileTexts() {
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
	
	public ArrayList<String> getRandomizeList() {
		ArrayList<String> randTexts = new ArrayList<String>();
		// TODO implement!
		
		return randTexts;
	}
	
	
}
