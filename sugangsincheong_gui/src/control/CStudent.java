package control;

import java.util.Vector;

import model.DAOEnrolment;
import model.DAOStudent;
import model.MStudent;

public class CStudent {

	private DAOStudent daoStudent;
	private MStudent mStudent;

	private String studentNumber;
	private String userPassword;

	public CStudent() {
		this.daoStudent = new DAOStudent();
	}

	public String getUserId() {
		return this.studentNumber;
	}
	public String getUserPassword() {
		return this.userPassword;
	}

	public boolean findUserId(String inputName, String inputEmail) {

		Vector<MStudent> mStudentList = this.daoStudent.getList();
		System.out.println(mStudentList.size());
		for (int i = 0; i < mStudentList.size(); i++) {
			mStudent = mStudentList.get(i);
			String database_name = mStudent.getName();
			String database_email = mStudent.getEmail();
			String database_student_number = mStudent.getStudentNumber();

			if (database_name.equals(inputName)) {
				System.out.printf("이름 정보 일치 : %s(%s)", database_name, inputName);
				if (database_email.equals(inputEmail)) {
					System.out.printf("이메일 정보 일치 : %s(%s)", database_email, inputEmail);
					this.studentNumber = database_student_number;
					return true;
				}
			}
		}
		return false;

	}

	public boolean findPassword(String inputStudentNumber, String inputEmail) {
		Vector<MStudent> mStudentList = this.daoStudent.getList();
		System.out.println(mStudentList.size());
		for (int i = 0; i < mStudentList.size(); i++) {
			mStudent = mStudentList.get(i);
			String database_email = mStudent.getEmail();
			String database_student_number = mStudent.getStudentNumber();
			String database_password = mStudent.getPassword();

			if (database_student_number.equals(inputStudentNumber)) {
				System.out.printf("이름 정보 일치 : %s(%s)", database_student_number, inputStudentNumber);
				if (database_email.equals(inputEmail)) {
					System.out.printf("이메일 정보 일치 : %s(%s)", database_email, inputEmail);
					this.userPassword = database_password;
					return true;
				}
			}
		}
		return false;
	}

}
