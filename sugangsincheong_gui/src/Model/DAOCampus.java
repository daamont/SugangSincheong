package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOCampus {
	private DefaultTableModel model;
	

	public DAOCampus() {
		// TODO Auto-generated constructor stub
	}

	public Vector<Model.MCampus> getList() {
		Vector<MCampus> mCampusList = new Vector<MCampus>(); //라인 하나가 mcampus 하나

		try {
			File file = new File("data/root.txt");
			Scanner scr = new Scanner(file);
			while (scr.hasNextLine()) {
				//deserialize
				String line = scr.nextLine();
				String[] wordList = line.split(" ");
				MCampus mCampus = new MCampus();
				mCampus.setId(Integer.parseInt(wordList[0]));
				mCampus.setName(wordList[1]);
				mCampus.setLink(wordList[2]);
				
				mCampusList.add(mCampus);
				
			}
			scr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mCampusList;
		
	}


}
