package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

//View로부터 전달받은 데이터 가공 -> Service로 전달
public class Controller {
	
	private Service service = new Service();
	
	//1번 추가
	public int insertCarOne(String modelName , int price , String date) {
		Car car = new Car(modelName,price,date);
		int result = service.insertCarOne(car);
		return result;
		
	}
	//2번 목록조회
	public List<Car> selectCarAll(){
		return service.selectCarAll();
	}
	
	//3번 단일조회
	public Car selectCar(String name) {
		return service.selectCar(name);
	}
	//단일 조회 LIST
//	public List<Car> selectCar(String name){
//		List<Car> list = service.selectCar(name);
//		return list;
//	}
	
	//4번 수정 
	public int updateCar(int updateNo,String updateName) {
		return service.updateCar(updateNo,updateName);
	}
	
	
	
	//5번 삭제
	public int deleteCarOne(int carNo) {
		return service.deleteCarOne(carNo);
	}


}
