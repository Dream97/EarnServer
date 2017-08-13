package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImplement;
import entity.BaseResult;
import util.DBHelper;

public class AlipayService {
	private UserDao mUserDao = new UserDaoImplement();  
    
  
    public BaseResult updateAlipay(String token,String alipayId,String realName) {  
          
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
        	int status = mUserDao.updateAlipay(connection, token, alipayId,realName);
            result.setStatus(status);
          System.out.println("更新alipay完的结果是"+status);
            return result;  
        } catch (SQLException e) {  
              
            e.printStackTrace();  
              
            result.setCode(1);
            return result;  
        }     
    }  
    public BaseResult updateWechat(String token,String wechat) {  
        
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
        	int status = mUserDao.updateWechat(connection, token, wechat);
            result.setStatus(status);
          System.out.println("更新wechat完的结果是"+status);
          connection.close();
            return result;  
        } catch (SQLException e) {  
              
            e.printStackTrace();  
              
            result.setCode(1);
            
            return result;  
        }     
    }  
}
