package entity;

public class LoginResult {
	private int code;
	private int status;
	private String token;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getStatus(){
		return status;
	}
	public void setStatus(int status){
		this.status = status;
	}
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
