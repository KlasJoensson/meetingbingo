package com.xlent.meetingbingo;

import java.util.ArrayList;

public class MeetingBingo {

	public static void main(String[] args) {
		writeTexts();
	}
	
	/**
	 * Just for testing...
	 */
	private static void writeTexts() {
		TileTexts tileTexts = new TileTexts();
		
		ArrayList<String> textStrList = tileTexts.getTexts();
		
		for(int r=0;r<25;r++) {
			if (r%5 == 0 && r != 0)
				System.out.println();
			
			System.out.print(textStrList.get(r) + " ");
			
		}
		
	}

}
