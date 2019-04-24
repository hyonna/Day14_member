package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.input.MemberInput;
import com.member.MemberDAO;
import com.member.MemberDTO;
import com.view.MemberView;

public class MemberController {

	public void start() throws Exception {

		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		MemberInput mi = new MemberInput();
		MemberView mv = new MemberView();
		ArrayList<MemberDTO> ar = null;
		Scanner sc = new Scanner(System.in);

		String result = null;
		
		//int result = 0;

		boolean check = true;

		while (check) {

			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 탈퇴");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 전체 조회");
			System.out.println("5. 종료");
			int select = sc.nextInt();

			switch (select) {

			case 1:

				memberDTO = mi.input();
				select = memberDAO.insert(memberDTO);
				String message = "추가 실패";
				
				if (select > 0) {

					message = "추가 성공";

				}

				mv.view(message);
				break;

			case 2:
				
				result = mi.setString("삭제");
				select = memberDAO.delete(result);
				
				String message2 = "삭제실패";
				
				if(select > 0) {
					
					message2 = "삭제 성공";
				}
				
				mv.view(message2);
				
				break;

			case 3:
				
				result = mi.setString("조회");
				memberDTO = memberDAO.selectOnt(result);
				
				if(result != null) {
					
					mv.view(memberDTO);
					
				} else {
					
					mv.view("없는 아이디");
					
				}
				
				break;

			case 4:
				
				ar = memberDAO.selectList();
				mv.view(ar);
				break;

			default:
				System.out.println("종료");
				check = !check;

			}

		}

	}

}
