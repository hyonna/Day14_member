package com.view;

import java.util.ArrayList;

import com.member.MemberDTO;

public class MemberView {
	
	public void view(String message) {
		
		System.out.println(message);
	}

	
	public void view(MemberDTO memberDTO) {
		
		System.out.println("=============회원 정보===============");
		System.out.println("ID : " + memberDTO.getId());
		System.out.println("PW : " + memberDTO.getPw());
		System.out.println("NAME : " + memberDTO.getName());
		System.out.println("AGE : " + memberDTO.getAge());
		System.out.println("BIRTH : " + memberDTO.getBirth());
		System.out.println("==================================");
		
	}
	
	public void view(ArrayList<MemberDTO> ar) {
		
		
		for(MemberDTO memberDTO : ar) {
			
			this.view(memberDTO);
		}
		
	}
	
}
