package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImplement;
import entity.BaseResult;
import entity.LoginResult;
import util.DBHelper;

public class UpdateMoneyService {
	  private UserDao mUserDao = new UserDaoImplement();  
      
	    private static final int RESULT_NULL_USERNAME = 1,RESULT_WRONG_PASSWORD = 2;  
	  
	    public BaseResult updateMoney(String token,String money) {  
	          
	        Connection connection = null;  
	        BaseResult result = new BaseResult();  
	          
	        try {
				connection = DBHelper.getConnection();
				System.out.println("获得connection成功");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          
	        try {  
	            //1、先判断是否有相应的token
	        	int status = mUserDao.updateMoney(connection, token, money);
	            result.setStatus(status);
              System.out.println("更新money完的结果是"+status);
              connection.close();
	            return result;  
	        } catch (SQLException e) {  
	              
	            e.printStackTrace();  
	              
	            result.setCode(1);
	            return result;  
	        }     
	    }  
}
