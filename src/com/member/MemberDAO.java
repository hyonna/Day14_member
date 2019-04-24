package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.util.DBConnector;

public class MemberDAO {
	
	
	
	
	
	
	

	// selectMember(String id)

	public void selectMember(String id) throws Exception {

		Connection con = DBConnector.getConnect();

		String sql = "select * from member where id like ?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, "%" + id + "%");
		ResultSet rs = st.executeQuery();

		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();

		while (rs.next()) {

		}

		

		DBConnector.disConnect(rs, st, con);


	

	}

	// insert - 회원가입

	public int insert(MemberDTO memberDTO) throws Exception {

		int result = 0;

		Connection con = DBConnector.getConnect();

		String sql = "insert into member values(?,?,?,?,?)";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setInt(4, memberDTO.getAge());
		st.setDate(5, memberDTO.getBirth());

		result = st.executeUpdate();

		DBConnector.disConnect(st, con);

		return result;

	}

	// delete - 회원탈퇴

	public int delete(String id) throws Exception {

		int result = 0;

		Connection con = DBConnector.getConnect();

		String sql = "delete member where id=?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, id);

		result = st.executeUpdate();

		DBConnector.disConnect(st, con);

		return result;

	}

	// selectOne - 회원정보조회

	public MemberDTO selectOnt(String id) throws Exception {

		Scanner sc = new Scanner(System.in);
		MemberDTO memberDTO = null;
		int result = 0;
		ResultSet rs = null;

		Connection con = DBConnector.getConnect();

		String sql = "select * from member where id=?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, id);

		rs = st.executeQuery();

		if (rs.next()) {

			memberDTO = new MemberDTO();

			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setAge(rs.getInt("age"));
			memberDTO.setBirth(rs.getDate("birth"));

		}

		DBConnector.disConnect(rs, st, con);

		return memberDTO;

	}

	// selectList - 회원 전체 정보 조회

	public ArrayList<MemberDTO> selectList() throws Exception {

		Connection con = DBConnector.getConnect();

		String sql = "select * from member";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		MemberDTO memberDTO = null;

		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();

		while (rs.next()) {

			memberDTO = new MemberDTO();

			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setAge(rs.getInt("age"));
			memberDTO.setBirth(rs.getDate("birth"));

			ar.add(memberDTO);
		}

		DBConnector.disConnect(rs, st, con);

		return ar;

	}

}
