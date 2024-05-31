package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JTable;

public class DAOIndex {
	

	public DAOIndex() {
		// TODO Auto-generated constructor stub
	}

	public Vector<model.MIndex> getList(String fileName) {
		Vector<MIndex> mIndexList = new Vector<MIndex>(); //라인 하나가 mcampus 하나

		try {
			File file = new File("data/"+fileName+".txt");
			Scanner scr = new Scanner(file);
			while (scr.hasNextLine()) {
				//deserialize
				String line = scr.nextLine();
				String[] wordList = line.split(" ");
				
				MIndex mIndex = new MIndex();
				
				mIndex.setId(Integer.parseInt(wordList[0]));
				mIndex.setName(wordList[1]);
				mIndex.setLink(wordList[2]);
//				System.out.println(wordList[0]);
//				System.out.println(wordList[1]);
//				System.out.println(wordList[2]);
				
				mIndexList.add(mIndex);
				
			}
			scr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mIndexList;
		
	}


}
