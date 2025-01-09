package com.gn.homework.controller;

import com.gn.homework.model.dao.MusicDao;
import com.gn.homework.model.vo.Music;

public class Controller {
	
	
	
	
	public int createId(String id , String pw , String name) {
		Music mm = new Music(id , pw , name);
		int result = new MusicDao().createId(mm);
		return result;
		
		
	}

}
