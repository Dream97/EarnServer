package dao;

import java.sql.Connection;
import java.sql.SQLException;


import entity.User;

public interface UserDao {
    /** 
     * ��User���������ݿ��� 
     *  
     * @param connection 
     * @param user 
     */  
    public void save(Connection connection, User user) throws SQLException;  
  
    /** 
     * ��ѯ���ݿ����Ƿ��ж�Ӧ��UserName������У����ض�Ӧid��û�У�����0 
     *  
     * @param connection 
     * @param userName 
     * @return 
     */  
    public int queryUserName(Connection connection, String userName) throws SQLException;  
  
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
    public void updateToken(Connection connection, int userId, String token) throws SQLException;  
      
    /** 
     * ����token��ȡ���û���id�����û�У�����0 
     * @param connection 
     * @param token 
     * @throws SQLException 
     */  
    public int getUserId(Connection connection,  String token) throws SQLException;  
      
}  