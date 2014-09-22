package com.luoshengsha.onegreen.test;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.Image;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 图片单元测试
 * @author luoshengsha
 * @date 2014年9月8日 上午11:08:04
 */
public class ImageTest {
	protected static PlatformService platformService;
	protected static ImageService imageService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			platformService = (PlatformService)cxt.getBean("platformServiceImpl");
			imageService = (ImageService)cxt.getBean("imageServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存图片
	 */
	@Test
	public void save() {
		for(int i=1;i<20;i++) {
			Image image = new Image();
			image.setUuid(IdGenerator.generateId());
			image.setTitle("测试图片"+i);
			image.setPath("http://pic.baidu.com/23432w4.jpg");
			image.setCreateTime(new Date());
			
			Platform platform = platformService.getByOriginalId("luo_shengsha");
			image.setPlatform(platform);
			
			imageService.save(image);
		}
	}
	
	/**
	 * 更新
	 */
	@Test
	public void update() {
		Image image = imageService.find("87B4C1B7685C47B09DA162F28247C011");
		image.setTitle("测试图片2");
		image.setPath("/images/b.jpg");
		imageService.update(image);
	}
	
	@Test
	public void delete() {
		imageService.delete("87B4C1B7685C47B09DA162F28247C011");
	}
	
	@Test
	public void find() {
		Image image = imageService.find("448B96984C76483F852559E0513DEBF5");
		System.out.println(image.getTitle() + " " + image.getUuid());
	}
	
	/**
	 * 查询
	 */
	@Test
	public void query() {
		PageView<Image> pageView = new PageView<Image>(2, 10);
		//条件
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		Platform platform = platformService.getByOriginalId("gh_3e7314baeab1");
		conditionMap.put("platform", platform);
		//排序
		LinkedHashMap<String,String> orderbyMap = new LinkedHashMap<String,String>();
		
		QueryResult<Image> qr = imageService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderbyMap);
		pageView.setQueryResult(qr);
		
		for(Image image : pageView.getRecords()) {
			System.out.println(image.getUuid() + " " + image.getTitle() + " " + image.getPath());
		}
	}
}
