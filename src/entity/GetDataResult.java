package entity;

public class GetDataResult {
	private int status;
	private int code;
	private String name;
	private String myselfMoney;
	private String studentMoney;
	private String alipayId;
	private String realName;
	private String wechat;
	
	public int getStatus(){
		return status;
	}
	public void setStatus(int status){
		this.status = status;
	}
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
	
	public String getMyselfMoney(){
		return myselfMoney;
	}
	public void setMyselfMoney(String myselfMoney)
	{
		this.myselfMoney = myselfMoney;
	}
	
	public String getStudentMoney(){
		return this.studentMoney;
	}
	public void setStudentMoney(String studentMoney){
		this.studentMoney = studentMoney; 
	}
	
	
	public String getAlipayId(){
		return alipayId;
	}
	public void setAlipayId(String alipayId){
		this.alipayId = alipayId;
	}
	public String getRealName(){
		return realName;
	}
	public void setRealName(String realName){
		this.realName = realName;
	}
	public String getWechat(){
		return wechat;
	}
	public void setWechat(String wechat){
		this.wechat = wechat;
	}
}
