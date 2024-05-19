package model;

import java.util.Scanner;

public class MLogin {
	private final String id = "123";
	private final String pw = "456";

	public MLogin() {

	}

	public void tryLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("로그인을 하십시오.");
		while (true) {
			System.out.print("아이디 입력: ");
			String enterId = sc.nextLine();
			System.out.print("비밀번호 입력: ");
			String enterPw = sc.nextLine();

			if (enterId.equals(id) && enterPw.equals(pw)) {
				System.out.println("로그인 성공");
				break;
			} else {
				System.out.println("다시 입력하세요.");
			}
		}

	}

}
