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

import entity.GetDataResult;
import entity.LoginResult;
import service.GetDataService;
import service.LoginService;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet(name = "GetData", urlPatterns = { "/GetData" })
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataServlet() {
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

		System.out.println("这是获取信息接口");
		response.setCharacterEncoding("UTF-8");
	    PrintWriter printWriter = response.getWriter();   
        
    	try{
            // 接收客户端表单提交的用户名和密码
            String token = request.getParameter("token");
            //System.out.println("请求的id为" + id + "\n请求的passWord为" + pwd);
             
            GetDataService service = new GetDataService();  
            GetDataResult result = service.getData(token);  
            Map<String, Object> map = new HashMap<>();  
            map.put("status", result.getStatus());  
        //如果成功，还需要加上token  
            if (result.getStatus() == 0) {  
            	Map<String, Object> dataMap = new HashMap<>();  
            	dataMap.put("id", result.getId());
            	dataMap.put("name", result.getName());
            	dataMap.put("myselfMoney",result.getMyselfMoney());
            	dataMap.put("studentMolney", result.getStudentMoney());
            	dataMap.put("alipay", result.getAlipayId());
            	dataMap.put("wechat", result.getWechat());
            	map.put("data", dataMap);    
           
            	}else{  
                //没有获得数据处理 
            		map.put("err", result.getCode());
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
