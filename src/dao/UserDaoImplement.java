package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import entity.Constants;
import entity.GetDataResult;
import entity.New;
import entity.NewResult;
import entity.Student;
import entity.StudentData;
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
		public int save(Connection connection, User user) throws SQLException {
			// TODO Auto-generated method stub
			int i = 0;
			String sql = "insert into user_table (id,name,password) values(?,?,?)";
	        PreparedStatement pstmt;
	      	try {
	            pstmt = (PreparedStatement) connection.prepareStatement(sql);
	            
	            pstmt.setString(1, user.getId());
	            pstmt.setString(2, user.getName());
	            pstmt.setString(3, user.getPassword());
	            i = pstmt.executeUpdate();
	            pstmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return i; //存入成功是1，失败是0
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
	                result.setStatus(0);
	                result.setName(rs.getString(2));
	                result.setMyselfMoney(rs.getString(5));
	                result.setStudentMoney(rs.getString(6));
	                result.setAlipayId(rs.getString(7));
	                result.setWechat(rs.getString(8));
	                
	                return result;
	            }
	            System.out.println("============================");
	            //System.out.println(Constants.name);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        result.setStatus(1);
	        result.setCode(201);
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
				            if(i==0) return 1;
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
	            if(i==0) return 1;
	            pstmt.close();
	            return 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return 1;
	        }
		}
		
		@Override
		public int updateAlipay(Connection connection, String token, String alipayId,String realName) throws SQLException {
			// TODO Auto-generated method stub         
			String sql = "update user_table set alipay_id='"+alipayId+"',real_name='"+realName+"'where token='"+token+"'";
	    	int i = 0;
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            i = pstmt.executeUpdate( );//1时，更新金额成功，0失败
	            //int col = rs.getMetaData().getColumnCount();
	            System.out.println("更新支付宝账号:"+i);
	            if(i==0) return 1;
	            pstmt.close();
	            return 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return 1;
	        }
		}

		@Override
		public int updateWechat(Connection connection, String token, String wechat) throws SQLException {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub         
						String sql = "update user_table set wechat_id='"+wechat+"'where token='"+token+"'";
				    	int i = 0;
				    	PreparedStatement pstmt;
				        try {
				            pstmt = (PreparedStatement)connection.prepareStatement(sql);
				            i = pstmt.executeUpdate( );//1时，更新金额成功，0失败
				            //int col = rs.getMetaData().getColumnCount();
				            System.out.println("更新微信名:"+i);
				            if(i==0) return 1;
				            pstmt.close();
				            return 0;
				        } catch (SQLException e) {
				            e.printStackTrace();
				            return 1;
				        }
		}

		@Override
		public User queryIdFromToken(Connection connection, String token) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User();
			
	    	String sql = "select * from user_table where token='"+token+"'";
	    	
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            int col = rs.getMetaData().getColumnCount();
	            System.out.println("============================");
	            while (rs.next()) {
	            	
	            		System.out.println("查询到用户");
	                    user.setId(rs.getString(1));
	                    user.setPassword(rs.getString(3));
	                    user.setMoney(rs.getString(5));
	                    user.setStudentMoney(rs.getString(7));
	                    return user;
	            }
	            System.out.println("============================");
	            //System.out.println(Constants.name);
	            
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        user.setId("0");
			return user;
		}

		@Override
		public int saveWithdraw(Connection conn, String id,String date, String way, String money,String cop) throws SQLException {
			// TODO Auto-generated method stub
			int i = 0;
			String sql = "insert into withdraw_table (id,date,way,money,complete,note,etc) values(?,?,?,?,?,?,?) ";
	        PreparedStatement pstmt;
	        Calendar now = Calendar.getInstance();  
	       
	        String etc = now.get(Calendar.YEAR)+"/"+(now.get(Calendar.MONTH) + 1)+"/"+now.get(Calendar.DAY_OF_MONTH)+"_"+id;
	        
	        System.out.println(etc);
			try {
	            pstmt = (PreparedStatement) conn.prepareStatement(sql);
	            
	            pstmt.setString(1, id);
	            pstmt.setString(2, date);
	            pstmt.setString(3, way);
	            pstmt.setString(4, money);
	            pstmt.setString(5, cop);
	            pstmt.setString(6, "null");
	            pstmt.setString(7, etc);
	            i = pstmt.executeUpdate();
	            pstmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return i; //存入成功是1，失败是0
		}

		@Override
		public int updateName(Connection connection, String token, String name) throws SQLException {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub         
			String sql = "update user_table set name='"+name+"'where token='"+token+"'";
	    	int i = 0;
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            i = pstmt.executeUpdate( );//1时，更新金额成功，0失败
	            //int col = rs.getMetaData().getColumnCount();
	            System.out.println("更新name:"+i);
	            if(i==0) return 1;
	            pstmt.close();
	            return 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return 1;
	        }
		}
	  
		

		@Override
		public int updatePWD(Connection connection, String token, String pwd) throws SQLException {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub         
			String sql = "update user_table set password='"+pwd+"'where token='"+token+"'";
	    	int i = 0;
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            i = pstmt.executeUpdate( );//1时，更新金额成功，0失败
	            //int col = rs.getMetaData().getColumnCount();
	            System.out.println("更新pwd:"+i);
	            if(i==0) return 1;
	            pstmt.close();
	            return 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return 1;
	        }
		}

		@Override
		public StudentData getStudentData(Connection connection, String dadid) throws SQLException {
			// TODO Auto-generated method stub
			String sql = "select * from user_table where dadid='"+dadid+"'";
			StudentData result = new StudentData();
			result.setStatus(1);
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            int col = rs.getMetaData().getColumnCount();
	            System.out.println("============================");
	            ArrayList<Student> students = new ArrayList<>();
	            while (rs.next()) {
	            		Student student = new Student();
	                	student.setName(rs.getString(2));
	                	student.setMyselfMoney(rs.getString(5));
	                	students.add(student);
	                	result.setStatus(0);
	                	System.out.println("用户");
	            }
	            result.setStudent(students);
	            System.out.println("============================");
	            //System.out.println(Constants.name);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        if(result.getStatus() == 1){
	        	result.setCode(201);
	        }
	        
			return result;
		}

		@Override
		public NewResult getNews(Connection connection, String category) throws SQLException {
			// TODO Auto-generated method stub
			String sql = "select * from news_table where category='"+category+"'";
			NewResult result = new NewResult();
			result.setStatus(1);
	    	PreparedStatement pstmt;
	        try {
	            pstmt = (PreparedStatement)connection.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            int col = rs.getMetaData().getColumnCount();
	            System.out.println("============================");
	            ArrayList<New> news = new ArrayList<>();
	            while (rs.next()) {
	            		New new1 = new New();
	                	new1.setTitle(rs.getString(2));
	                	new1.setTimes(rs.getString(4));
	                	new1.setImgLinks(rs.getString(5));
	                	new1.setArtcle(rs.getString(6));
	                	news.add(new1);
	                	result.setStatus(0);
	                	System.out.println("用户");
	            }
	            result.setNew(news);
	            System.out.println("============================");
	            //System.out.println(Constants.name);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        if(result.getStatus() == 1){
	        	result.setCode(201);
	        }
	        
			return result;
		}
		
}
