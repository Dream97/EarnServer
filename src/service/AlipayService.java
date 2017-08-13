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
			System.out.println("���connection�ɹ�");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          
        try {  
            //1�����ж��Ƿ�����Ӧ��token
        	int status = mUserDao.updateAlipay(connection, token, alipayId,realName);
            result.setStatus(status);
          System.out.println("����alipay��Ľ����"+status);
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
			System.out.println("���connection�ɹ�");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          
        try {  
            //1�����ж��Ƿ�����Ӧ��token
        	int status = mUserDao.updateWechat(connection, token, wechat);
            result.setStatus(status);
          System.out.println("����wechat��Ľ����"+status);
          connection.close();
            return result;  
        } catch (SQLException e) {  
              
            e.printStackTrace();  
              
            result.setCode(1);
            
            return result;  
        }     
    }  
}
