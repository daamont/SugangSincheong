package Constants;

public class Constant {

	public class MainFrame {
		final public static long VERSION_NUM = 1L;

		final public static String TITLE = "수강신청";
	}

	public class IndexTable {
		public enum EHeader {
			eId("아이디"),
			eTitle("이름"), 
			eLectureName("강의명"), 
			eProfessor("교수"), 
			eCredit("학점"), 
			eTime("시간");

			public String title;

			private EHeader(String title) {
				this.title = title;
			}

			public String getTitle() {
				return this.title;
			}
		}
	}

	public class LoginDialog {
		final public static String TITLE = "로그인";
		final public static String SugangsincheongTIME = "10:20";
		final public static String SugangsincheongDATE = "2024-06-10";
		
		public enum ELoginTitle {
			eID("ID"),
			ePassword("PASSWORD"), 
			eOKButton("OK"), 
			eCANCELButton("CANCEL"), 
			eFINDIDButton("아이디 찾기"),
			eFINDPWButton("비밀번호 찾기");

			public String title;

			private ELoginTitle(String title) {
				this.title = title;
			}

			public String getTitle() {
				return this.title;
			}
		}
		public enum ELoginMessage {
			eLoginFAILEDTitle("로그인 실패"),
			eLoginFAILEDMessage("아이디나 비밀번호가 일치하지 않습니다"),
		    eSugangsincheongAlarmTitle("알림"),
		    eTimeAlarmMessage(SugangsincheongTIME+"부터 수강신청 시간입니다 \n 아직 수강신청 시간이 아닙니다"),
			eDateAlarmMessage(SugangsincheongDATE+"부터 수강신청 날짜입니다 \n 아직 수강신청 날짜가 아닙니다");

		    public String message;

		    private ELoginMessage(String message) {
		        this.message = message;
		    }

		    public String getMessage() {
		        return message;
		    }
		}
		public enum ELoginSize{
			eButtonWidth(100),
			eButtonHeight(33),
			eTextFieldWidth(200),
			eTextFieldHeight(36);
			
			public int size;

		    private ELoginSize(int size) {
		        this.size = size;
		    }

		    public int getSize() {
		        return size;
		    }
		}
	}

	public class FindDialog {
		final public static String IDTITLE = "아이디 찾기";
		final public static String PWTITLE = "비밀번호 찾기";
		
		public enum EFindTitle {
			eFindInfoLabel("이름과 이메일을 입력하세요"),
			eIdInfoLabel("* 아이디는 학번입니다 *"),
			eNameLabel("이름: "), 
			eEmailLabel("이메일: "), 
			eFindIdButton("아이디 찾기"),
			ePwInfoLabel("아이디와 이메일을 입력하세요"),
			eStudentNumberLabel("학번: "), 
			eFindPwButton("비밀번호 찾기");

			public String title;

			private EFindTitle(String title) {
				this.title = title;
			}

			public String getTitle() {
				return this.title;
			}
		}
		
		public enum EMenuMessage {
			eFindIDSuccessTitle("아이디 찾기 성공"),
			eFindIDSuccessMessage("아이디: %s"),
			eFindIDFailureTitle("아이디 찾기 실패"),
			eFindIDFailureMessage("일치하는 사용자가 없습니다"),
			
			eFindPasswordSuccessTitle("비밀번호 찾기 성공"),
			eFindPasswordSuccessMessage("비밀번호: %s"),
			eFindPasswordFailureTitle("비밀번호 찾기 실패"),
			eFindpasswordFailureMessage("일치하는 사용자가 없습니다");

		    public String message;

		    private EMenuMessage(String message) {
		        this.message = message;
		    }

		    public String getMessage() {
		        return message;
		    }
		}	
		
		public enum EFindnSize{
			eButtonWidth(100),
			eButtonHeight(35),
			eTextFieldWidth(200),
			eTextFieldHeight(40);
			
			public int size;

		    private EFindnSize(int size) {
		        this.size = size;
		    }

		    public int getSize() {
		        return size;
		    }
		}

	}
	
	public class MenuPanel{
		public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
		public enum EMenuTitle{

			eUserIntroduce(" 님의 수강신청"),
			eCreditButton("수강학점 확인"),
			eLogoutButton("logout"),
			eTimeLabel("현재 시간: ");
			
			public String title;

			private EMenuTitle(String title) {
				this.title = title;
			}

			public String getTitle() {
				return this.title;
			}
		}
		public enum EMenuMessage {
		    eCreditMessageTitle("학점"),
		    eCurrentCreditMessage("현재 수강학점: %d \n 남은 학점: %d \n 최대 수강 학점: %d");

		    public String message;

		    private EMenuMessage(String message) {
		        this.message = message;
		    }

		    public String getMessage() {
		        return message;
		    }
		}	
	}
	
	public class ControlPanel{
		public static final int MaximumCredit = 17;
		
		public enum EControlMessage {
			eOverlapMessageTitle("오류"),
		    eOverlapMessage("중복된 강의입니다"),
		    eOverCreditTitle("신청 실패"),
		    eOverCreditMessage("수강학점을 초과하였습니다 \n 현재 담은 학점: %d \n 남은 학점: %d");

		    public String message;

		    private EControlMessage(String message) {
		        this.message = message;
		    }

		    public String getMessage() {
		        return message;
		    }
		}

		public enum EControlSize{
			eButtonWidth(55),
			eButtonHeight(55);
			
			public int size;

		    private EControlSize(int size) {
		        this.size = size;
		    }

		    public int getSize() {
		        return size;
		    }
		}
	}
	
	public Constant() {
		// TODO Auto-generated constructor stub

	}
}
