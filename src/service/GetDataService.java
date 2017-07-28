package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImplement;
import entity.GetDataResult;
import entity.LoginResult;
import util.DBHelper;

public class GetDataService {
	 private UserDao mUserDao = new UserDaoImplement();  
     
	    private static final int RESULT_NULL_USERNAME = 1,RESULT_WRONG_PASSWORD = 2;  
	  
	    public GetDataResult getData(String token) {  
	          
	        Connection connection = null;  
	        GetDataResult result = new GetDataResult();  
	          
	        try {
				connection = DBHelper.getConnection();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          
	        try {  
	         
	        	//通过token查询信息
	        	result = mUserDao.getData(connection, token);
             System.out.println("服务获取信息中");
	            return result;  
	        } catch (SQLException e) {  
	              
	            e.printStackTrace();
	            return result;  
	        }     
	    }  
}
