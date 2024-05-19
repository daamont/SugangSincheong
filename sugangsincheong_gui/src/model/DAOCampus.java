package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JTable;

public class DAOCampus {
	

	public DAOCampus() {
		// TODO Auto-generated constructor stub
	}

	public Vector<model.MCampus> getList(String fileName) {
		Vector<MCampus> mCampusList = new Vector<MCampus>(); //라인 하나가 mcampus 하나

		try {
			File file = new File("data/"+fileName+".txt");
			Scanner scr = new Scanner(file);
			while (scr.hasNextLine()) {
				//deserialize
				String line = scr.nextLine();
				String[] wordList = line.split(" ");
				
				MCampus mCampus = new MCampus();
				
				mCampus.setId(Integer.parseInt(wordList[0]));
				mCampus.setName(wordList[1]);
				mCampus.setLink(wordList[2]);
//				System.out.println(wordList[0]);
//				System.out.println(wordList[1]);
//				System.out.println(wordList[2]);
				
				mCampusList.add(mCampus);
				
			}
			scr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mCampusList;
		
	}


}
