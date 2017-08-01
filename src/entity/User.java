package entity;

public class User {
	private String id;
	private String name;
	private String password;
	private String token;
	private String money;
	private String studentMoney;
	/*
	 * getºÍset·½·¨
	 */
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	
	public void setPassword(String password){
		this.password = password ;
	}
	public String getPassword(){
		return password;
	}
	
	public void setToken(String token){
		this.token = token;
	}
	public String getToken(){
		return token;
	}
	
	
	public void setMoney(String money){
		this.money = money;
	}
	public String getMoney(){	
		return money;
	}
	
	
	public void setStudentMoney(String studentMoney){
		this.studentMoney = studentMoney;
	}
	public String getStudentMoney(){
		return studentMoney;
	}
	
}
