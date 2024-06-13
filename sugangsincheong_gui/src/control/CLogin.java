package control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import Constants.Constant.LoginDialog;
import model.DAOStudent;
import model.MStudent;

public class CLogin {

	private DAOStudent daoStudent;
	private MStudent mStudent;
	private String usesrName;
	private String studentNumber;

	public CLogin() {
	}

	public boolean checkLogin(String inputID, String inputPW) {
		this.daoStudent = new DAOStudent();

		Vector<MStudent> mStudentList = this.daoStudent.getList();
		System.out.println(mStudentList.size());
		for (int i = 0; i < mStudentList.size(); i++) {
			mStudent = mStudentList.get(i);
			String database_id = mStudent.getStudentNumber();
            String database_pw = mStudent.getPassword();
            String user_name = mStudent.getName();

            if(database_id.equals(inputID)) {
                System.out.printf("id 일치 : %s(%s)", database_id, inputID);
                if(database_pw.equals(inputPW)) {
                    System.out.printf("pw 일치 : %s(%s)", database_pw, inputPW);
                    this.studentNumber = database_id;
                    this.usesrName = user_name;
                    return true;
                }
            }
//			if (inputID.equals(mStudent.getStudentNumber()) && inputPW.equals(mStudent.getPassword())) {
//				return true;
//			}
		}
		return false;
	}

	public String getUserName() {
		return this.usesrName;
	}
	public String getStudentNumber() {
		return this.studentNumber;
	}

	public boolean checkTime() {	
		try {
			SimpleDateFormat hourMinuteFormat = new SimpleDateFormat("HH:mm");
			String currentTimeString = hourMinuteFormat.format(new Date());
			Date currentTime = hourMinuteFormat.parse(currentTimeString);
			Date sugangTime = hourMinuteFormat.parse(LoginDialog.SugangsincheongTIME);

			System.out.println("currentTime: " + currentTimeString);
			System.out.println("sugangTime: " + hourMinuteFormat.format(sugangTime));
			return currentTime.compareTo(sugangTime) >= 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false; // 예외 발생 시 기본적으로 false 반환
		}
	}
	
	public boolean checkDate() {    
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String currentDateString = dateFormat.format(new Date());
	        Date currentDate = dateFormat.parse(currentDateString);
	        Date sugangDate = dateFormat.parse(LoginDialog.SugangsincheongDATE);

	        System.out.println("currentDate: " + currentDateString);
	        System.out.println("sugangDate: " + dateFormat.format(sugangDate));
	        return currentDate.compareTo(sugangDate) >= 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; // 예외 발생 시 기본적으로 false 반환
	    }
	}
}
