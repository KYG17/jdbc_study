package com.gn.homework.model.vo;

import java.time.LocalDateTime;

public class Music {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private LocalDateTime regDate;
	
	
	
	
	public Music() {}
	
	public Music(String userId) {
		this.userId = userId;
	}
	
	public Music(String userId , String userPw , String userName) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}
	

	public Music(int userNo, String userId, String userPw, String userName, LocalDateTime regDate) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.regDate = regDate;
	}
	
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "Music [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", regDate=" + regDate + "]";
	}
	

}
