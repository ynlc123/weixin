package com.luoshengsha.onegreen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.CompanyProfile;
import com.luoshengsha.onegreen.bean.Image;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.CompanyProfileService;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;

/**
 * 公司简介控制器
 * @author luoshengsha
 * @date 2014年9月11日 上午11:27:47
 */
@Controller
public class CompanyProfileController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(CompanyProfileController.class);
    
    @Resource
    private CompanyProfileService profileService;
    @Resource
    private PlatformService platformService;
    @Resource
    private ImageService imageService;
    
    /**
     * 显示公司简介
     * @return
     */
    @RequestMapping(value="/center/companyProfile.htm")
    public ModelAndView companyProfile() {
    	try {
    		Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
    		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
    		if(platform == null) {
    			return new ModelAndView("redirect:/center/platform.htm");
    		}
    		
			CompanyProfile profile = profileService.getByPlatform(platform);
			
			return new ModelAndView("/center/companyProfile", "profile", profile);
		} catch (Exception e) {
			logger.error("显示公司简介失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 更新公司简介
     * @param companyName 公司名称
     * @param content 简介内容
     * @param imageIds 公司图片
     * @param response
     */
    @RequestMapping(value="/center/companyProfile/update.htm")
    public void update(@RequestParam(value="companyName") String companyName,
    		@RequestParam(value="content") String content,
    		@RequestParam(value="attachId",defaultValue="") String attachId,
    		HttpServletResponse response) {
    	
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			CompanyProfile profile = profileService.getByPlatform(platform);
			
			if(profile == null) {
				profile = new CompanyProfile();
				profile.setUuid(IdGenerator.generateId());
				profile.setPlatform(platform);
			}
			
			//公司简介图片
			/*List<Image> imageList = new ArrayList<Image>();
			if(!StringUtils.isEmpty(imageIds)) {
				String [] imageIdArrays = imageIds.split("#");
				for(int i=0,j=imageIdArrays.length;i<j;i++) {
					imageList.add(imageService.find(imageIdArrays[i]));
				}
			}*/
			//临时，往后待完善
			List<Image> imageList = new ArrayList<Image>();
			Image image = imageService.find(attachId);
			if(image != null) {
				imageList.add(image);
			}
			
			profile.setImages(imageList);
			profile.setCompanyName(companyName);
			profile.setContent(content);
			
			profileService.edit(profile);
			WebUtil.print2JsonMsg(response, true, "更新公司简介成功！");
		} catch (Exception e) {
			logger.error("更新公司简介失败", e);
			WebUtil.print2JsonMsg(response, false, "更新公司简介失败！");
		}
    }
    
    /**
     * 查看公司简介
     * @param originalId
     * @return
     */
    @RequestMapping(value="/view/profile.htm")
    public ModelAndView view(@RequestParam(value="originalId") String originalId, HttpServletRequest request) {
    	try {
			Platform platform = platformService.getByOriginalId(originalId);
			CompanyProfile profile = profileService.getByPlatform(platform);
			request.setAttribute("platform", platform);
			
			return new ModelAndView("view/profile", "profile", profile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
}
