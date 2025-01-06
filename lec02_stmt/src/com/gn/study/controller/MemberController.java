package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	
	public Member selectMemberOneByIdAndPw(String id, String pw) {
		return new MemberDao().selectMemberOneByIdAndPw(id,pw);
	}
	
	
	public List<Member> searchKeyWord(String key){	
		List<Member> list = new MemberDao().searchKeyWord(key);
		return list;
	}
	
	
	public Member selectMemberOneById(String memberId) {
//		Member m = new MemberDao().selectMemberOneById(memberId);
//		return m;
		return new MemberDao().selectMemberOneById(memberId);
	}
	
	
	public List<Member> selectMemberAll() {
		List<Member> list = new MemberDao().selectMemberAll();
		return list;
	}
	
	
	
	public int insertMember(String memberId,String memberPw,String memberName
			,String memberEmail,String memberPhone,String memberGender) {
		Member m = new Member(memberId,memberPw,memberName,memberEmail,memberPhone,memberGender);
		
		int result = new MemberDao().insertMember(m);
		return result;
//		if(result > 0) {
//			//성공
//		}else {
//			//실패
//		}
		
		
	}
	public int updateMemberInfo(String name , String phone , String email , String id , String pw) {
		Member m = new Member(name , phone , email );	
		int result = new MemberDao().updateMemberInfo(name,phone,email,id,pw);
		return result;
	}
	
	public int deleteAccount(String idd , String pww) {
		Member m = new Member(idd , pww);
		int result = new MemberDao().deleteAccountInfo(idd , pww);
		return result;
	}

	}



