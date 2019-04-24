package com.main;

import com.controller.MemberController;

public class MemberMain {
	
	public static void main(String[] args) {
		
		
		MemberController mc = new MemberController();
		
		
		try {
			
			mc.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
