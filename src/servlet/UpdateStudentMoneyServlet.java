package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.BaseResult;
import service.UpdateMoneyService;
import service.UpdateStudentMoneyService;

/**
 * Servlet implementation class UpdateStudentMoneyServlet
 */
public class UpdateStudentMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 7245361420327420429L;  

    @Override
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
    	doPost(request,response);
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("这是更新studentMoney接口");
		response.setCharacterEncoding("UTF-8");
	    PrintWriter printWriter = response.getWriter();   
        
    	try{
            // 接收客户端表单提交的用户名和密码
            String token = request.getParameter("token");
            String money = request.getParameter("studentMoney");
            //System.out.println("请求的id为" + id + "\n请求的passWord为" + pwd);
             
            UpdateStudentMoneyService service = new UpdateStudentMoneyService();  
            BaseResult result = service.updateStudentMoney(token, money);  
            Map<String, Object> map = new HashMap<>();  
            map.put("status", result.getStatus());  
        //如果成功，还需要加上token  
            if (result.getStatus() == 0) {  
            	//Map<String, Object> dataMap = new HashMap<>();  
            	
           
            	}else{  
            		map.put("err", 201);
                //没有获得数据处理 
            }
            String json = JSON.toJSONString(map);  
            printWriter.write(json);  
            printWriter.close();
            //printWriter.write("请求的userName为" + userName + "\n请求的passWord为" + pwd);
        }catch(Exception e){
            e.printStackTrace();
        }
    	 
        printWriter.close();  
        }
	
}
