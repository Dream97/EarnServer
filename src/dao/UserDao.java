package dao;

import java.sql.Connection;
import java.sql.SQLException;

import entity.GetDataResult;
import entity.NewResult;
import entity.StudentData;
import entity.User;

public interface UserDao {
    /** 
     * 将User保存至数据库中 
     *  
     * @param connection 
     * @param user 
     */  
    public int save(Connection connection, User user) throws SQLException;  
  
    /** 
     * 查询数据库中是否有对应的UserName，如果有，返回对应id，没有，返回0 
     *  
     * @param connection 
     * @param userName 
     * @return 
     */  
    public int queryId(Connection connection, String userName) throws SQLException;  
  
    /** 
     * 根据User查询数据库中相应的id的password是否正确。如果正确，返回对应的id，否则返回0 
     *  
     * @param connection 
     * @param user 
     * @return 
     * @throws SQLException 
     */  
    public int queryPassWord(Connection connection, String id, String password) throws SQLException;  
  
    /** 
     * 向指定Id的User中更新token 
     *  
     * @param connection 
     * @param userId 
     * @param token 
     * @throws SQLException 
     */  
    public void updateToken(Connection connection, String Id, String token) throws SQLException;  
      
    /** 
     * 根据token获取到用户的id，如果没有，返回0 
     * @param connection 
     * @param token 
     * @throws SQLException 
     */  
    public GetDataResult getData(Connection connection,  String token) throws SQLException;  
    
    /**
     * 根据token更新用户的money
     * @param connection
     * @param token
     * @return
     * @throws SQLException
     */
    public int updateMoney(Connection connection,String token,String money) throws SQLException;  
    /**
     * 根据token更新用户的studentMoney
     * @param connection
     * @param token
     * @param studentMoney
     * @return
     * @throws SQLException
     */
    public int updateStudentMoney(Connection connection,String token,String studentMoney) throws SQLException;
    
    /**
     * 保存用户的支付宝账号
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
     * 通过token查询id
     * @param connection
     * @param token
     * @return
     * @throws SQLException
     */
    public User queryIdFromToken(Connection connection,String token) throws SQLException;  

    /**
     * 将提现请求存进去
     * @param connection
     * @param user
     * @throws SQLException
     */
    public int saveWithdraw(Connection connection, String id,String date,String way,String money,String cop) throws SQLException;  

    /**
     * 根据token更新用户的名字
     * @param connection
     * @param token
     * @return
     * @throws SQLException
     */
    public int updateName(Connection connection,String token,String name) throws SQLException;  

    /**
     * 根据token更新用户的密码
     * @param connection
     * @param token
     * @return
     * @throws SQLException
     */
    public int updatePWD(Connection connection,String token,String pwd) throws SQLException;  
    
    /** 
     * 根据token获取到用户的徒弟，如果没有，返回0 
     * @param connection 
     * @param token 
     * @throws SQLException 
     */  
    public StudentData getStudentData(Connection connection,  String dadid) throws SQLException;  
    

    /** 
     * 根据category获取到用户的徒弟，如果没有，返回0 
     * @param connection 
     * @param category 
     * @throws SQLException 
     */  
    public NewResult getNews(Connection connection,  String category) throws SQLException;  
    
}  