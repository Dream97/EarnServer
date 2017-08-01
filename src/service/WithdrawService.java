package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import dao.UserDao;
import dao.UserDaoImplement;
import entity.BaseResult;
import entity.User;
import util.DBHelper;

public class WithdrawService {
	  private UserDao mUserDao = new UserDaoImplement();  
      
	   private static final int RESULT_NULL_USERNAME = 1,RESULT_WRONG_PASSWORD = 2;  
	  
	    public BaseResult withdraw(String token,String pwd,String money,String way) {     
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
	            
	        	//int code = mUserDao.updateStudentMoney(connection, token, studentMoney);
	        	User user = mUserDao.queryIdFromToken(connection, token);
	            Calendar now = Calendar.getInstance();  
	 			String date = now.get(Calendar.YEAR)+"."+(now.get(Calendar.MONTH) + 1)+"."+now.get(Calendar.DAY_OF_MONTH);
	 			String cop = "N";//订单是否完成
	        	//判断获取id是否成功
	        	if(user.getId().equals("0"))
	        	{
	        		result.setStatus(1);
	        		result.setCode(201); 
	        		return result;  
	        	}else{
	        		if(pwd.equals(user.getPassword()))
	        		{
	        			
	        			//判断是否存进去
	        			int status = mUserDao.saveWithdraw(connection, user.getId(), date, way, money, cop);
	        			if(status == 0){
	        				System.out.println("存入数据库失败");
	        				result.setStatus(1);
	        				result.setCode(308);
	        				return result;
	        			}else{
	        				System.out.println("存入数据库成功");
	        				result.setStatus(0);
	        			}
	        		}else{
	        			 System.out.println("密码错误");
	        			 result.setStatus(1);
		                 result.setCode(304);
	        		}
	        		
	        	}
	            return result;  
	        } catch (SQLException e) {  
	              
	            e.printStackTrace();  
	              
	            result.setCode(1);
	            return result;  
	        }     
	    }  
}
