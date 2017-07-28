package dao;

import java.sql.Connection;
import java.sql.SQLException;

import entity.GetDataResult;
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
      
}  