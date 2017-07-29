package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.GetDataResult;
import entity.User;
/**
 * 操作层+
 * @author asus
 *
 */

public class UserDaoImplement implements UserDao{

	    public int queryId(Connection connection, String id) throws SQLException {  
	  
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
		public void updateToken(Connection connection, String id, String token) throws SQLException {
			// TODO Auto-generated method stub
			String sql = "update user_table set token='"+token+"'where id='"+id+"'";
	    	int i = 0;
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            i = pstmt.executeUpdate( );
	            //int col = rs.getMetaData().getColumnCount();
	            System.out.println("插入token:"+i);
	            pstmt.close();
	           // connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}

		@Override
		public GetDataResult getData(Connection connection, String token) throws SQLException {
			// TODO Auto-generated method stub
			String sql = "select * from user_table where token='"+token+"'";
	    	GetDataResult result = new GetDataResult();
			
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
	                result.setCode(0);
	                result.setName(rs.getString(2));
	                result.setMyselfMoney(rs.getDouble(5));
	                result.setStudentMoney(rs.getDouble(6));
	                return result;
	            }
	            System.out.println("============================");
	            //System.out.println(Constants.name);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        result.setCode(1);
			return result;
		}

		@Override
		public int updateMoney(Connection connection, String token, String money) throws SQLException {
			// TODO Auto-generated method stub
						String sql = "update user_table set myself_money='"+money+"'where token='"+token+"'";
				    	int i = 0;
				    	PreparedStatement pstmt;
				        try {
				            pstmt = (PreparedStatement)connection.prepareStatement(sql);
				            i = pstmt.executeUpdate( );//1时，更新金额成功，0失败
				            //int col = rs.getMetaData().getColumnCount();
				            System.out.println("更新钱:"+i);
				            pstmt.close();
				            return 0;
				        } catch (SQLException e) {
				            e.printStackTrace();
				            return 1;
				        }
			
		}

		@Override
		public int updateStudentMoney(Connection connection, String token, String studentMoney) throws SQLException {
			// TODO Auto-generated method stub
			String sql = "update user_table set student_money='"+studentMoney+"'where token='"+token+"'";
	    	int i = 0;
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            i = pstmt.executeUpdate( );//1时，更新金额成功，0失败
	            //int col = rs.getMetaData().getColumnCount();
	            System.out.println("更新徒弟钱:"+i);
	            pstmt.close();
	            return 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return 1;
	        }
		}  
	  
}
