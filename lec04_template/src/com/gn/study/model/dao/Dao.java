package com.gn.study.model.dao;

import static com.gn.study.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Car;

public class Dao {
	public int insertCarOne(Car car,Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO car (car_model,car_price,car_date) "
					+ "VALUES(?,?,STR_TO_DATE(?,'%Y-%m-%d')) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getCarModel());
			pstmt.setInt(2, car.getCarPrice());
			pstmt.setString(3, car.getCarDate());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
//		}try {
//			if(pstmt != null) pstmt.close();
//		}catch(Exception e){
//			e.printStackTrace();
			close(pstmt);
		}
		return result;
	}
	
	public List<Car> selectCarAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try {
			String sql = "SELECT * FROM car";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {		
//				Car car = new Car(rs.getInt("car_no")
//						,rs.getString("car_model")
//						,rs.getInt("car_price")
//						,sdf.format(rs.getDate("car_date")));
				Car car = new Car ();
				car.setCarNo(rs.getInt("car_No"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				car.setCarNo(rs.getInt("car_no"));	
				if(rs.getDate("car_date")!= null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}
				
				list.add(car);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
		}
	//3.단일조회 List
//	public List <Car> selectCar(String name,Connection conn){
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Car> list = new ArrayList<Car>();
//		try {
//			String sql = "SELECT * FROM car WHERE car_model = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			while(rs.next()) {
//				Car car = new Car ();
//				car.setCarNo(rs.getInt("car_No"));
//				car.setCarModel(rs.getString("car_model"));
//				car.setCarPrice(rs.getInt("car_price"));
//				car.setCarNo(rs.getInt("car_no"));	
//				if(rs.getDate("car_date")!= null) {
//					car.setCarDate(sdf.format(rs.getDate("car_date")));
//				}else {
//					car.setCarDate("(-)");
//				}			
//				list.add(car);
//				
//				}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		return list;
//		}
//	
	//3. 단일 조회
	public Car selectCar(Connection conn , String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Car car = null; //if 문 안에 car = new Car();
		try {
			String sql = "SELECT * FROM car WHERE car_model = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(rs.next()) {
				car = new Car ();
				car.setCarNo(rs.getInt("car_No"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				car.setCarNo(rs.getInt("car_no"));	
				if(rs.getDate("car_date")!= null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}						
				}		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return car;
		}
	
	//3.단일조회 List
//	public List <Car> selectCar(String name,Connection conn){
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Car> list = new ArrayList<Car>();
//		try {
//			String sql = "SELECT * FROM car WHERE car_model = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			while(rs.next()) {
//				Car car = new Car ();
//				car.setCarNo(rs.getInt("car_No"));
//				car.setCarModel(rs.getString("car_model"));
//				car.setCarPrice(rs.getInt("car_price"));
//				car.setCarNo(rs.getInt("car_no"));	
//				if(rs.getDate("car_date")!= null) {
//					car.setCarDate(sdf.format(rs.getDate("car_date")));
//				}else {
//					car.setCarDate("(-)");
//				}			
//				list.add(car);
//				
//				}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		return list;
//		}
//	
	
	//4번 수정
	public int updateCar(int updateNo, String updateName , Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			String sql = "UPDATE car SET car_model = ? WHERE car_no = ?  ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateName);
			pstmt.setInt(2, updateNo);
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	//5번 삭제
	public int deleteCarOne(int carNo , Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "DELETE FROM car WHERE car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carNo);
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	

}
