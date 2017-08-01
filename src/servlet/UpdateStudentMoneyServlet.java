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

		System.out.println("���Ǹ���studentMoney�ӿ�");
		response.setCharacterEncoding("UTF-8");
	    PrintWriter printWriter = response.getWriter();   
        
    	try{
            // ���տͻ��˱��ύ���û���������
            String token = request.getParameter("token");
            String money = request.getParameter("studentMoney");
            //System.out.println("�����idΪ" + id + "\n�����passWordΪ" + pwd);
             
            UpdateStudentMoneyService service = new UpdateStudentMoneyService();  
            BaseResult result = service.updateStudentMoney(token, money);  
            Map<String, Object> map = new HashMap<>();  
            map.put("status", result.getStatus());  
        //����ɹ�������Ҫ����token  
            if (result.getStatus() == 0) {  
            	//Map<String, Object> dataMap = new HashMap<>();  
            	
           
            	}else{  
            		map.put("err", 201);
                //û�л�����ݴ��� 
            }
            String json = JSON.toJSONString(map);  
            printWriter.write(json);  
            printWriter.close();
            //printWriter.write("�����userNameΪ" + userName + "\n�����passWordΪ" + pwd);
        }catch(Exception e){
            e.printStackTrace();
        }
    	 
        printWriter.close();  
        }
	
}
