package entity;

public class GetDataResult {
	private int code;
	private String name;
	private double myselfMoney;
	private double studentMoney;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public double getMyselfMoney(){
		return myselfMoney;
	}
	public void setMyselfMoney(double myselfMoney)
	{
		this.myselfMoney = myselfMoney;
	}
	
	public double getStudentMoney(){
		return this.studentMoney;
	}
	public void setStudentMoney(double studentMoney){
		this.studentMoney = studentMoney; 
	}
}
