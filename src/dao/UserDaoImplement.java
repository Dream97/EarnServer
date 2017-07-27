package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import entity.User;
/**
 * ²Ù×÷²ã+
 * @author asus
 *
 */

public class UserDaoImplement implements UserDao{

	    public int queryUserName(Connection connection, String id) throws SQLException {  
	  
	    	String sql = "select * from user_table where id='"+id+"'";
	        String pwd ;
	    	
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            int col = rs.getMetaData().getColumnCount();
	            System.out.println("============================");
	            while (rs.next()) {
	                for (int i = 1; i <= col; i++) {
	                    System.out.print(rs.getString(i) + "\t");
	                }
	                return 1;
	            }
	            System.out.println("============================");
	            //System.out.println(Constants.name);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	  
	    }

		@Override
		public void save(Connection connection, User user) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int queryPassWord(Connection connection, String id, String password) throws SQLException {
			// TODO Auto-generated method stub

	    	String sql = "select * from user_table where id='"+id+"'and password='"+password+"'";
	        String pwd ;
	    	
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            int col = rs.getMetaData().getColumnCount();
	            System.out.println("============================");
	            while (rs.next()) {
	                for (int i = 1; i <= col; i++) {
	                    System.out.print(rs.getString(i) + "\t");
	                    pwd = rs.getString(3);
	                }
	                return 1;
	            }
	            System.out.println("============================");
	            //System.out.println(Constants.name);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return 0;
		}

		@Override
		public void updateToken(Connection connection, int userId, String token) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getUserId(Connection connection, String token) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}  
	  
}
