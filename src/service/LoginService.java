package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImplement;
import entity.LoginResult;
import util.DBHelper;

public class LoginService {
	    private UserDao mUserDao = new UserDaoImplement();  
	      
	    private static final int RESULT_NULL_USERNAME = 1,RESULT_WRONG_PASSWORD = 2;  
	  
	    public LoginResult login(String id, String passWord) {  
	          
	        Connection connection = null;  
	        LoginResult result = new LoginResult();  
	          
	        try {
				connection = DBHelper.getConnection();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          
	        try {  
	            //1、先判断是否有相应的用户名  
	            int code = mUserDao.queryId(connection, id);
	            if (code == 0) {  
	                result.setCode(RESULT_NULL_USERNAME);  
	                System.out.println("没有该用户");
	                return result;  
	            }  
	              
	            //2、再判断密码是否正确  
	            int userId = mUserDao.queryPassWord(connection, id, passWord);  
	            if (userId == 0) {  
	                result.setCode(RESULT_WRONG_PASSWORD);
	                System.out.println("密码错误");
	                return result;  
	            }  
	              
	            //3、设置相应的token  
	            long currentTime  = System.currentTimeMillis();  
	            String token = id+"_"+currentTime;  
	            //String token = "_"+currentTime;  
	            
	           // mUserDao.updateToken(connection, userId, token);
	            result.setCode(0);  
	            result.setToken(token);  
	            mUserDao.updateToken(connection, id, token);
                System.out.println("密码正确,获取token");
	            return result;  
	        } catch (SQLException e) {  
	              
	            e.printStackTrace();  
	              
	            result.setCode(100);  
	            return result;  
	        }     
	    }  
}
