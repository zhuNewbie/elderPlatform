package cn.elderPlatform.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import net.sf.json.JSONObject;

@Controller
@RequestMapping("/device")

public class DeviceController {
	
	public class ResultBoolean{
		private boolean rs;

		public boolean isRs() {
			return rs;
		}

		public void setRs(boolean rs) {
			this.rs = rs;
		}
	}
	
	
	public class ResultData{
		
		private String message;
		
		private String type;
		
		private String account;
		
		private String deviceId;
		
		private int sid; 
		
		private String createtime;
		public ResultData(){
			sid = 0;
			message="爱儿德";
			type="爱儿德";
			account="爱儿德";
			deviceId="爱儿德";
			createtime="爱儿德";
		}
		public int getSid() {
			return sid;
		}

		public void setSid(int sid) {
			this.sid = sid;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		

		public String getCreatetime() {
			return createtime;
		}

		public void setCreatetime(String createtime) {
			this.createtime = createtime;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getAccount() {
			return account;
		}

		public void setAccount(String account) {
			this.account = account;
		}

		public String getDeviceId() {
			return deviceId;
		}

		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}

		
	}
	private static final Logger log =Logger.getLogger(DeviceController.class);
	
	@RequestMapping("/sendBeltMsg")
	public String beltRecv(HttpServletRequest request,
			HttpServletResponse response, 
			Model model) throws
	IOException{
		
		request.setCharacterEncoding("utf-8");
		String sid = request.getParameter("sid");
		String message = request.getParameter("message");
		String type = request.getParameter("type");
		String deviceId = request.getParameter("deviceid");
		String account = request.getParameter("account");
		String createtime = request.getParameter("createtime");
		//String basePath = request.getContextPath();
		log.info(sid+":"+message+":"+type+":deviecId#"+deviceId+
				";time:"+createtime);
		log.debug("hh");
		
		try{
			
			
			ResultData rd = new ResultData();
			rd.sid =  Integer.parseInt(sid);
			rd.message = message;
			rd.type = type;
			rd.deviceId = deviceId;
			rd.account = account;
			rd.createtime = createtime;
//			String rs = JSONObject.fromObject(rd).toString();
			
			ResultBoolean rb = new ResultBoolean();
			rb.rs = true;
			String rs = JSONObject.fromObject(rb).toString();
			
			response.getWriter().write(rs);
			
		}catch(Exception e){
			ResultBoolean rb = new ResultBoolean();
			rb.rs = false;
			String rs = JSONObject.fromObject(rb).toString();
			response.getWriter().write(rs);
		}
		
		return null;
	}
	
	
	@RequestMapping("/boundDevice")
	public String boundDevice(HttpServletRequest request,
			HttpServletResponse response, 
			Model model) throws IOException{
		
		request.setCharacterEncoding("utf-8");
		String deviceid = request.getParameter("device_id");
		String adminAccount = request.getParameter("admin_account");
		
		String result = "false";
		result = sendOut(deviceid,adminAccount);
			//result = "true";
		response.getWriter().write(result);	
		return null;
	}

//http://cloud.tpline.com.cn:8885/api/ZylhApi/Bundling
	private String sendOut(String deviceid, String adminAccount) throws HttpException, IOException {
		// TODO Auto-generated method stub
		String redirectUrl = "http://cloud.tpline.com.cn:8885/api/ZylhApi/Bundling";
		HttpClient client = new HttpClient();  
		PostMethod post = new PostMethod(redirectUrl);
		NameValuePair[] data = {
		          new NameValuePair("device_id", deviceid),
		          new NameValuePair("admin_account", adminAccount)
		        };
//		        Part[] parts = {  
//		                (Part) new StringPart("device_id", "aaa"),  
//		                (Part) new StringPart("admin_account", "bbb")  
//		                };  
		        //post.setRequestEntity(new MultipartRequestEntity((org.apache.commons.httpclient.methods.multipart.Part[]) parts, post.getParams()));  
		
		post.setRequestBody(data);
		client.executeMethod(post);  
		String result = post.getResponseBodyAsString(); 
		return result;
	}
	

}
