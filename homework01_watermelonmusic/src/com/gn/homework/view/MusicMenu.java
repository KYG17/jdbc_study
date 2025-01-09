package com.gn.homework.view;

import java.util.Scanner;

import com.gn.homework.controller.Controller;

public class MusicMenu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	
	public void mainMenu() {
		System.out.println("환영합니다!!");
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 종료");
			System.out.print("번호를 입력해 주세요 : ");
			int no = sc.nextInt();
			sc.nextLine();
			switch(no) {
				case 1 : createId(); break;
				case 2 :	break;
				case 0 : System.out.println("프로그램을 종료하겠습니다"); return;
				default : System.out.println("잘못된 번호입니다!!!!!"); 
			}
		}
		
		}
	public void createId() {
		System.out.println("회원가입을 시작하겠습니다!");
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = sc.nextLine();
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		int result = controller.createId(id , pw , name);
		if(result > 0) {
			System.out.println("회원가입 성공!!!!");
		}else {
			System.out.println("회원가입에 실패하였습니다 ㅠㅡㅠ");
		}
		
		
	}

}
