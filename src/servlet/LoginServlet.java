package servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Girl;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import entity.LoginResult;

import service.LoginService;



public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 7245361420327420429L;  

    @Override
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
    	doPost(request,response);
    }
    
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
    
    	PrintWriter printWriter = resp.getWriter();   
        
    	try{
            // ���տͻ��˱��ύ���û���������
            String id = req.getParameter("id");
            String pwd = req.getParameter("pwd");
            System.out.println("�����idΪ" + id + "\n�����passWordΪ" + pwd);
            //��֤
//            if(name.equals("root") && pwd.equals("123")){
//                // �Ϸ�
//            	printWriter.write("Success");
////                resp.sendRedirect("welcome");
//            }else{
//                // ���Ϸ�
//                //��ת
//                printWriter.write("fail");  // ����Ҫ��ת�� URL
//            }        
           
            LoginService service = new LoginService();  
            LoginResult loginResult = service.login(id, pwd);  
            Map<String, Object> map = new HashMap<>();  
            map.put("status", loginResult.getStatus());  
        //����ɹ�������Ҫ����token  
           
            if (loginResult.getStatus() == 0) {  
            	Map<String, Object> dataMap = new HashMap<>();  
            	dataMap.put("token", loginResult.getToken());  
            	map.put("data", dataMap);       
            }else{
            	map.put("err", loginResult.getCode());
            }
            
            String result = JSON.toJSONString(map);  
        	System.out.println("���Ϊ"+result);
        	printWriter.write(result);
            printWriter.close();  
            //printWriter.write("�����userNameΪ" + userName + "\n�����passWordΪ" + pwd);
        }catch(Exception e){
            e.printStackTrace();
        }  
        }
}