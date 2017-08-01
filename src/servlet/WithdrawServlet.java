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
		System.out.println("�������ֽӿ�");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();   
		try{
            // ���տͻ��˱��ύ���û���������
			String token = request.getParameter("token");
            String pwd = request.getParameter("pwd");
            String money = request.getParameter("money");
            String way = request.getParameter("way");
		    System.out.println("���ַ�ʽ��"+way);
		   //System.out.println(date);
	        
		            //System.out.println("�����idΪ" + id + "\n�����passWordΪ" + pwd);
		             
		            WithdrawService service = new WithdrawService();  
		            BaseResult result = service.withdraw(token, pwd, money, way);  
		            Map<String, Object> map = new HashMap<>();  
		            map.put("status", result.getCode());  
		        //����ɹ�������Ҫ����token  
		            if (result.getStatus() == 0) {  
		            	//Map<String, Object> dataMap = new HashMap<>();  
		           
		            	}else{  
		                //û�л�����ݴ��� 
		            		map.put("err",result.getCode());
		            }
		            String json = JSON.toJSONString(map);  
		            printWriter.write(json);  
//		            printWriter.close();
//		            //printWriter.write("�����userNameΪ" + userName + "\n�����passWordΪ" + pwd);
		        }catch(Exception e){
		            e.printStackTrace();
		        }
		    	 
		        printWriter.close();  
			}

}
