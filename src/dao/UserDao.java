package dao;

import java.sql.Connection;
import java.sql.SQLException;

import entity.GetDataResult;
import entity.NewResult;
import entity.StudentData;
import entity.User;

public interface UserDao {
    /** 
     * ��User���������ݿ��� 
     *  
     * @param connection 
     * @param user 
     */  
    public int save(Connection connection, User user) throws SQLException;  
  
    /** 
     * ��ѯ���ݿ����Ƿ��ж�Ӧ��UserName������У����ض�Ӧid��û�У�����0 
     *  
     * @param connection 
     * @param userName 
     * @return 
     */  
    public int queryId(Connection connection, String userName) throws SQLException;  
  
    /** 
     * ����User��ѯ���ݿ�����Ӧ��id��password�Ƿ���ȷ�������ȷ�����ض�Ӧ��id�����򷵻�0 
     *  
     * @param connection 
     * @param user 
     * @return 
     * @throws SQLException 
     */  
    public int queryPassWord(Connection connection, String id, String password) throws SQLException;  
  
    /** 
     * ��ָ��Id��User�и���token 
     *  
     * @param connection 
     * @param userId 
     * @param token 
     * @throws SQLException 
     */  
    public void updateToken(Connection connection, String Id, String token) throws SQLException;  
      
    /** 
     * ����token��ȡ���û���id�����û�У�����0 
     * @param connection 
     * @param token 
     * @throws SQLException 
     */  
    public GetDataResult getData(Connection connection,  String token) throws SQLException;  
    
    /**
     * ����token�����û���money
     * @param connection
     * @param token
     * @return
     * @throws SQLException
     */
    public int updateMoney(Connection connection,String token,String money) throws SQLException;  
    /**
     * ����token�����û���studentMoney
     * @param connection
     * @param token
     * @param studentMoney
     * @return
     * @throws SQLException
     */
    public int updateStudentMoney(Connection connection,String token,String studentMoney) throws SQLException;
    
    /**
     * �����û���֧�����˺�
     * @param connection
     * @param token
     * @param alipayId
     * @param realName
     * @return
     * @throws SQLException
     */
    public int updateAlipay(Connection connection,String token,String alipayId,String realName) throws SQLException;  

    /**
     * 
     * @param connection
     * @param token
     * @param wechat
     * @return
     * @throws SQLException
     */
    public int updateWechat(Connection connection,String token,String wechat) throws SQLException;  

    /**
     * ͨ��token��ѯid
     * @param connection
     * @param token
     * @return
     * @throws SQLException
     */
    public User queryIdFromToken(Connection connection,String token) throws SQLException;  

    /**
     * ������������ȥ
     * @param connection
     * @param user
     * @throws SQLException
     */
    public int saveWithdraw(Connection connection, String id,String date,String way,String money,String cop) throws SQLException;  

    /**
     * ����token�����û�������
     * @param connection
     * @param token
     * @return
     * @throws SQLException
     */
    public int updateName(Connection connection,String token,String name) throws SQLException;  

    /**
     * ����token�����û�������
     * @param connection
     * @param token
     * @return
     * @throws SQLException
     */
    public int updatePWD(Connection connection,String token,String pwd) throws SQLException;  
    
    /** 
     * ����token��ȡ���û���ͽ�ܣ����û�У�����0 
     * @param connection 
     * @param token 
     * @throws SQLException 
     */  
    public StudentData getStudentData(Connection connection,  String dadid) throws SQLException;  
    

    /** 
     * ����category��ȡ���û���ͽ�ܣ����û�У�����0 
     * @param connection 
     * @param category 
     * @throws SQLException 
     */  
    public NewResult getNews(Connection connection,  String category) throws SQLException;  
    
}  