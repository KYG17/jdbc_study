package com.gn.study.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Member {
	private int memberNo;
	private String memberId;
	private String memeberPw;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private String memberGender;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	public Member() {}
	
	public Member(String memberId, String memeberPw, String memberName, String memberEmail,
			String memberPhone, String memberGender) {
		this.memberId = memberId;
		this.memeberPw = memeberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberGender = memberGender;	
	}
	
	public Member(int memberNo, String memberId, String memeberPw, String memberName, String memberEmail,
			String memberPhone, String memberGender, LocalDateTime regDate, LocalDateTime modDate) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memeberPw = memeberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberGender = memberGender;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemeberPw() {
		return memeberPw;
	}

	public void setMemeberPw(String memeberPw) {
		this.memeberPw = memeberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-mm-dd");
		
		return "회원 [번호=" + memberNo + ", 아이디=" + memberId + ", 비빌번호=" + memeberPw + ", 이름="
				+ memberName + ", 이메일=" + memberEmail + ", 전화번호=" + memberPhone + ", 성별="
				+ memberGender + ", 가입일=" + dtf.format(regDate) + ", 수정일=" + dtf.format(modDate) + "]";
	}
	
	
	

}
