package com.xlent.meetingbingo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class TileTextGenerator {

	private ArrayList<String> texts;
	private String fileName;
	private Logger log = Logger.getLogger(TileTextGenerator.class.getName());
	
	
	public TileTextGenerator() {
		fileName = "resources/texts_sv.txt";
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
	 * Populates the list with the texts.
	 * 
	 * @throws IOException 
	 */
	private void populateList() {
		texts = new ArrayList<String>();
		
		try {
			Files.lines(Paths.get(fileName)).forEach(str -> texts.add(str));
		} catch (IOException e) {
			log.warning("Could not find the language file: " + fileName);
			try {
				Files.lines(Paths.get("resources/texts_en.txt")).forEach(str -> texts.add(str));
			} catch (IOException e1) {
				log.severe("Could not find the backup language file!" + e1.getMessage());
			}
	
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
	
	/**
	 * Sets the proper language file using the ISO 639-1 standard, and loads the
	 * new language. If no file with the code exists, the generator will default
	 *  to the English version.
	 * 
	 * @param lanCode The two letters for the wanted language
	 */
	public void setLanguage(String lanCode) {
		fileName = "resources/texts_" + lanCode + ".txt";
		populateList();
	}
	
}
