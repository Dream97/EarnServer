package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.BaseResult;
import service.AlipayService;
import service.WithdrawService;

/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("这是提现接口");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();   
		try{
            // 接收客户端表单提交的用户名和密码
			String token = request.getParameter("token");
            String pwd = request.getParameter("pwd");
            String money = request.getParameter("money");
            String way = request.getParameter("way");
		    System.out.println("提现方式是"+way);
		   //System.out.println(date);
	        
		            //System.out.println("请求的id为" + id + "\n请求的passWord为" + pwd);
		             
		            WithdrawService service = new WithdrawService();  
		            BaseResult result = service.withdraw(token, pwd, money, way);  
		            Map<String, Object> map = new HashMap<>();  
		            map.put("status", result.getCode());  
		        //如果成功，还需要加上token  
		            if (result.getStatus() == 0) {  
		            	//Map<String, Object> dataMap = new HashMap<>();  
		           
		            	}else{  
		                //没有获得数据处理 
		            		map.put("err",result.getCode());
		            }
		            String json = JSON.toJSONString(map);  
		            printWriter.write(json);  
//		            printWriter.close();
//		            //printWriter.write("请求的userName为" + userName + "\n请求的passWord为" + pwd);
		        }catch(Exception e){
		            e.printStackTrace();
		        }
		    	 
		        printWriter.close();  
			}

}
