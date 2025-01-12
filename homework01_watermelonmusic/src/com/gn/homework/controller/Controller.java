package com.gn.homework.controller;

import com.gn.homework.model.dao.MusicDao;
import com.gn.homework.model.vo.Music;

public class Controller {
	
	public Music alreadyid(String id) {
		return new MusicDao().alreadyid(id);
	}
		
	public int createId(String id1 , String pw , String name) {
		Music mm = new Music(id1 , pw , name);
		int result = new MusicDao().createId(mm);
		return result;	
	}

}
