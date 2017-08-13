package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImplement;
import entity.BaseResult;
import util.DBHelper;

public class UpdateStudentMoneyService {
	  private UserDao mUserDao = new UserDaoImplement();  
      
	    private static final int RESULT_NULL_USERNAME = 1,RESULT_WRONG_PASSWORD = 2;  
	  
	    public BaseResult updateStudentMoney(String token,String studentMoney) {  
	          
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
	            //判断是否更新成功  
	        	//int code = mUserDao.updateStudentMoney(connection, token, studentMoney);
	        	int status = mUserDao.updateStudentMoney(connection, token, studentMoney);
	            result.setStatus(status);
            System.out.println("更新Studentmoney完的结果是"+status);
            connection.close();
	            return result;  
	        } catch (SQLException e) {  
	              
	            e.printStackTrace();  
	              
	            result.setCode(1);
	            return result;  
	        }     
	    }  
}
