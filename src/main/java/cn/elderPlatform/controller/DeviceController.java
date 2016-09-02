package cn.elderPlatform.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/device")

public class DeviceController {
	
	public class ResultData{
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

		private String message;
		
		private String type;
		
		private String account;
		
		private String deviceId;
		
		private int sid; 
		
		private String createtime;
		

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
	private static final Logger logger = LogManager.getLogger(DeviceController.class.getName());
	
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
		logger.fatal(sid+":"+message);
		
		ResultData rd = new ResultData();
		rd.sid =  Integer.parseInt(sid);
		rd.message = message;
		rd.type = type;
		rd.deviceId = deviceId;
		rd.account = account;
		rd.createtime = createtime;
		String rs = JSONObject.fromObject(rd).toString();
		
		response.getWriter().write(rs);
		return null;
	}

}
