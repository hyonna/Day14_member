package com.input;

import java.sql.Date;
import java.util.Scanner;

import com.member.MemberDTO;

public class MemberInput {
	
	private Scanner sc;
	
	public MemberInput() {
		
		sc = new Scanner(System.in);
		
	}
	
	public MemberDTO input() {
		
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("ID를 입력 >>>>");
		memberDTO.setId(sc.next());
		
		System.out.println("PW를 입력 >>>>");
		memberDTO.setPw(sc.next());
		
		System.out.println("이름을 입력 >>>>");
		memberDTO.setName(sc.next());
		
		System.out.println("나이를 입력 >>>>");
		memberDTO.setAge(sc.nextInt());
		
		System.out.println("생년월일 입력 >>>>");
		String birth = sc.next();
		Date date = Date.valueOf(birth);
		memberDTO.setBirth(date);
		
		
		return memberDTO;
		
	}
	
	
	public String setString(String str) {
		
		System.out.println(str + " 아이디를 입력하세요");
		String id = sc.next();
		
		return id;
		
	}

}
