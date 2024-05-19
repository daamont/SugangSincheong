package model;

import java.util.Scanner;
import java.util.Vector;

import java.io.File;
import java.io.FileNotFoundException;

public class DAOLecture {

	public DAOLecture() {
		this.mDepartment = new MDepartment();
	}

	private MDepartment mDepartment;

	public Vector<model.MLecture> getList() {
		
		Vector<MLecture> mLectureList = new Vector<MLecture>();

		try {
			File file = new File("data/"+mDepartment.getLink());
			Scanner scr = new Scanner(file);
			while (scr.hasNextLine()) {
				// deserialize
				String line = scr.nextLine();
				String[] wordList = line.split(" ");

				MLecture mLecture = new MLecture();
				mLecture.setId(Integer.parseInt(wordList[0]));
				mLecture.setName(wordList[1]);
				mLecture.setProfessor(wordList[2]);
				mLecture.setCredit(Integer.parseInt(wordList[3]));
				mLecture.setTime(wordList[4]);

				mLectureList.add(mLecture);

			}
			scr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mLectureList;

	}

}
