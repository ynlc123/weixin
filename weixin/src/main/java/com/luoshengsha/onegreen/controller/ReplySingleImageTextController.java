package com.luoshengsha.onegreen.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.bean.ReplySingleImageText;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.service.ReplySingleImageTextService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.WebUtil;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 单图文回复控制器
 * @author luoshengsha
 * @date 2014年9月30日 下午4:10:19
 */
@Controller
public class ReplySingleImageTextController {
	/** 记录日志**/
    static Logger logger = Logger.getLogger(ReplySingleImageTextController.class);
    
    @Resource
    private PlatformService platformService;
    @Resource
    private ReplySingleImageTextService imageTextService;
    @Resource
    private ImageService imageService;
    
    /**
     * 图文回复列表
     * @return
     */
    @RequestMapping(value="/list.htm")
    public ModelAndView list(@RequestParam(value="pageNo",defaultValue="1") int pageNo) {
    	try {
    		Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
    		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
    		if(platform == null) {
    			return new ModelAndView("redirect:/center/platform.htm");
    		}
			//页码，每页显示10个多图文回复
			PageView<ReplySingleImageText> pageView = new PageView<ReplySingleImageText>(pageNo, 10);
			
			//条件
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("platform", platform);
			
			//排序
			LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
			orderbyMap.put("editTime", "desc");
			
			QueryResult<ReplySingleImageText> qr = imageTextService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
			pageView.setQueryResult(qr);
			
			return new ModelAndView("center/singleImageText-list", "pageView", pageView);
		} catch (Exception e) {
			logger.error("显示单图文回复列表失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 添加单图文回复界面
     * @return
     */
    @RequestMapping(value="/new.htm")
    public String addui() {
    	Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
		//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
		if(platform == null) {
			return "redirect:/center/platform.htm";
		}
    	return "center/singleImageText-new";
    }
    
    /**
     * 保存
     * @param keywords
     * @param content
     * @param imageId
     */
    @RequestMapping(value="/save.htm")
    public void save(@RequestParam(value="keywords") String keywords, 
    				@RequestParam(value="content") String content, 
    				@RequestParam(value="imageId") String imageId) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			
			ReplySingleImageText imageText = new ReplySingleImageText();
			imageText.setUuid(IdGenerator.generateId());
			imageText.setImage(imageService.getByUuid(imageId));
			imageText.setContent(content);
			imageText.setCreateTime(new Date());
			imageText.setStatus(1);
			imageText.setPlatform(platform);
			
			imageTextService.save(imageText);
		} catch (Exception e) {
			logger.error("保存单条图文回复失败", e);
		}
    }
    
    /**
     * 编辑单条图文回复
     * @param uuid
     */
    @RequestMapping(value="/edit.htm")
    public ModelAndView edit(@RequestParam(value="uuid") String uuid) {
    	try {
			Platform platform = platformService.getByCustomer(WebUtil.getLoginCustomer());
			//当客户尚未填写公众号信息时，跳转到公众号编辑页面。
			if(platform == null) {
				return new ModelAndView("redirect:/center/platform.htm");
			}
			ReplySingleImageText imageText = imageTextService.getByUuid(uuid);
			if(imageText == null) {
				return new ModelAndView("404");
			}
			return new ModelAndView("center/singleImageText-edit", "imageText", imageText);
		} catch (Exception e) {
			logger.error("编辑单条图文回复失败", e);
			return new ModelAndView("500");
		}
    }
    
    /**
     * 
     * @param keywords
     * @param content
     * @param imageId
     * @param uuid
     */
    @RequestMapping(value="/update.htm")
    public void update(@RequestParam(value="keywords") String keywords, 
			@RequestParam(value="content") String content, 
			@RequestParam(value="imageId") String imageId,
			@RequestParam(value="uuid") String uuid) {
    	try {
			ReplySingleImageText imageText = imageTextService.getByUuid(uuid);
			imageText.setKeywords(keywords);
			imageText.setContent(content);
			imageText.setImage(imageService.getByUuid(imageId));
			imageText.setEditTime(new Date());
			
			imageTextService.update(imageText);
		} catch (Exception e) {
			logger.error("更新单条图文回复失败", e);
		}
    }
    
    /**
     * 根据uuid删除
     * @param uuid
     */
    public void delete(@RequestParam(value="uuid") String uuid) {
    	try {
			imageTextService.delete(uuid);
		} catch (Exception e) {
			logger.error("删除单条图文回复失败", e);
		}
    }
}
