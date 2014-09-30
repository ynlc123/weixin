package com.luoshengsha.onegreen.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.luoshengsha.onegreen.bean.Customer;
import com.luoshengsha.onegreen.bean.Image;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.CustomerService;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;

@Controller
public class UploadController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(UploadController.class);
    
    @Resource
    private CustomerService customerService;
    @Resource
    private ImageService imageService;
    @Resource
    private PlatformService platformService;
	
	@RequestMapping(value="/upload.htm")
	public String upload() {
		return "upload";
	}
	
	/**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile.htm", method = RequestMethod.POST)
    public @ResponseBody
    void uploadFileHandler(@RequestParam("upfile") MultipartFile file,
    		HttpServletResponse response,
    		HttpServletRequest request) {
    	System.out.println("jsessionid: " + request.getParameter("jsessionid"));
    	Customer loginCustomer = WebUtil.getLoginCustomer();
    	Platform platform = platformService.getByCustomer(loginCustomer);
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
 
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                
                Calendar cal = Calendar.getInstance(); 
                String directoryPath = "D:/server/apache-tomcat-7.0.54_1/webapps"+"/images/" + cal.get(Calendar.YEAR) + "/" + 
  					   fillupDecimal(cal.get(Calendar.MONTH)+1, "0", 2) + "/" 
  					   + fillupDecimal(cal.get(Calendar.DAY_OF_MONTH), "0", 2);
                /*String directoryPath = rootPath+"/images/" + cal.get(Calendar.YEAR) + "/" + 
 					   fillupDecimal(cal.get(Calendar.MONTH)+1, "0", 2) + "/" 
 					   + fillupDecimal(cal.get(Calendar.DAY_OF_MONTH), "0", 2);*/
                File dir = new File(directoryPath);
                
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                String fileName = UUID.randomUUID().toString().toLowerCase() + "." + getExt(file.getOriginalFilename());
                String filePath = dir.getAbsolutePath() + File.separator + fileName;
                File serverFile = new File(filePath);
                
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                
                String picPath = directoryPath.substring(directoryPath.indexOf("images"))+"/"+fileName;
                
                Image image = new Image();
                image.setUuid(IdGenerator.generateId());
                image.setTitle(file.getOriginalFilename());
                image.setPath(picPath);
                image.setCreateTime(new Date());
                image.setPlatform(platform);
                imageService.save(image);
                
                logger.info("Server File Location=" + serverFile.getAbsolutePath());
                //response.getWriter().print("{\"success\":"+true+",\"id\":\""+image.getUuid()+"\"}");
                //response.getWriter().print("{\"original\":\"1\",\"url\":\"http://localhost:8080/" + picPath+"\",\"title\":\"2\",\"state\":\"SUCCESS\"}");
                String rs = "{\"name\":\"13511411655689529.jpg\", \"originalName\": \"Hydrangeas.jpg\", \"size\": 595284, \"state\": \"SUCCESS\", \"type\": \".jpg\", \"url\": \"images/2014/09/25/2463b711-0a92-4719-a9bc-f6f58c2413b1.jpg\"}";
                response.getWriter().print(rs);
            } catch (Exception e) {
                //return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
//            return "You failed to upload " + name
//                    + " because the file was empty.";
        }
    }
    
    /**
     * Upload multiple file using Spring Controller
     */
    @RequestMapping(value = "/uploadMultipleFile.htm", method = RequestMethod.POST)
    public @ResponseBody
    String uploadMultipleFileHandler(@RequestParam("name") String[] names,
            @RequestParam("file") MultipartFile[] files) {
 
        if (files.length != names.length)
            return "Mandatory information missing";
 
        String message = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];
            try {
                byte[] bytes = file.getBytes();
 
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name + "." + getExt(file.getOriginalFilename()));
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());
 
                message = message + "You successfully uploaded file=" + name
                        + "<br />";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        return message;
    }
    
    /* 获取图片后缀名
	 * @param fileName 文件名
	 * @return 后缀名，如果传入的文件名非法，则返回空字符串。
	 */
	private static String getExt(String fileName) {
		//当文件名为空或传入的文件不符合时，返回空字符串
		if(fileName == null || fileName.split("\\.").length == 0) return "";
		return fileName.substring(fileName.lastIndexOf('.')+1).toLowerCase();
	}
	
	/**
	 * 数字补齐
	 * @param resource 原始数字
	 * @param sign 所要补充的符号
	 * @param length 长度
	 * @return 补零后的字符创
	 */
	private static String fillupDecimal(int resource,String sign,int length) {
		String str = String.valueOf(resource);
		while(str.length() < length) {
			str = sign + str;
		}
		return str;
	}
}
