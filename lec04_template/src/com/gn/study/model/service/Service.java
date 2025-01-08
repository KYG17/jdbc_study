package com.gn.study.model.service;

import static com.gn.study.common.JDBCTemplate.close;
import static com.gn.study.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.vo.Car;

//DB에 접속 -> Connection 객체 생성
public class Service {
	//1번 추가
	private Dao dao = new Dao();
	public int insertCarOne(Car car) {
		Connection conn = getConnection();
		int result = dao.insertCarOne(car, conn);
		close(conn);
		return result;				
//		Connection conn = null;
//		int result = 0;
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
//			String user = "scott";
//			String pw = "tiger";
//			conn = DriverManager.getConnection(url,user,pw); //DAO가 CONN이 필요함
//			result = dao.insertCarOne(car,conn);
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			try {
//				if(conn != null) conn.close();;
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			}
//		return result;
			}
	//2번 목록조회
	public List <Car> selectCarAll(){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarAll(conn);
		close(conn);
		return list;
	}
	
	//3번 단일조회
	public Car selectCar(String name) {
		Connection conn = getConnection();
		Car car = dao.selectCar(conn,name);
		close(conn);
		return car;
	}
	
// 3번 단일조회 list
//	public List <Car> selectCar(String name){
//	Connection conn = getConnection();
//	List<Car> list = dao.selectCar(name,conn);
//	close(conn);
//	return list;
//}
	
	//4번
	public int updateCar(int updateNo, String updateName) {
		Connection conn = getConnection();
		int result = dao.updateCar(updateNo,updateName,conn);
		close(conn);
		return result;
	}
	
	
	
	//5번 삭제
	public int deleteCarOne(int carNo) {
		Connection conn = getConnection();
		int result = dao.deleteCarOne(carNo , conn);
		close(conn);
		return result;
	}

	

}
