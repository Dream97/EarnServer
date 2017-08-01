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
import service.AlipayService;
import service.UpdateMoneyService;

/**
 * Servlet implementation class AlipayServlet
 */
@WebServlet("/AlipayServlet")
public class AlipayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlipayServlet() {
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
		System.out.println("������֧�����ӿ�");
		response.setCharacterEncoding("UTF-8");
	    PrintWriter printWriter = response.getWriter();   
    	try{
            // ���տͻ��˱��ύ���û���������
            String token = request.getParameter("token");
            String alipayId = request.getParameter("alipayId");
            String realName = request.getParameter("realName");
            
            System.out.println("���µ�֧�����˺���"+alipayId+" ��ʵ������"+realName);
            
            //System.out.println("�����idΪ" + id + "\n�����passWordΪ" + pwd);
             
            AlipayService service = new AlipayService();  
            BaseResult result = service.updateAlipay(token, alipayId,realName);  
            Map<String, Object> map = new HashMap<>();  
            map.put("status", result.getCode());  
        //����ɹ�������Ҫ����token  
            if (result.getStatus() == 0) {  
            	//Map<String, Object> dataMap = new HashMap<>();  
            	
           
            	}else{  
                //û�л�����ݴ��� 
            		map.put("err",201);
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
