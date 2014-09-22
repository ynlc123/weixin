package com.luoshengsha.onegreen.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.CompanyProfile;
import com.luoshengsha.onegreen.bean.Image;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.CompanyProfileService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;

/**
 * 企业介绍单元测试
 * @author luoshengsha
 * @date 2014年9月8日 下午10:18:43
 */
public class CompanyProfileTest {
	protected static PlatformService platformService;
	protected static CompanyProfileService companyProfileService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			platformService = (PlatformService)cxt.getBean("platformServiceImpl");
			companyProfileService = (CompanyProfileService)cxt.getBean("companyProfileServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 编辑
	 */
	@Test
	public void edit() {
		Platform platform = platformService.getByOriginalId("luo_shengsha");
		CompanyProfile companyProfile = companyProfileService.getByPlatform(platform);
		if(companyProfile==null) {
			companyProfile = new CompanyProfile();
			companyProfile.setUuid(IdGenerator.generateId());
		}
		companyProfile.setCompanyName("云南禅客网络科技有限责任公司");
		companyProfile.setContent("云南禅客网络科技有限责任公司是一家网络公司，云南禅客网络科技有限责任公司是一家网络公司");
		companyProfile.setPlatform(platform);

		List<Image> imageList = new ArrayList<Image>();
		Image image1 = new Image();
		image1.setId(3);
		image1.setTitle("图片1");
		image1.setPath("a.jpg");
		image1.setUuid(IdGenerator.generateId());
		image1.setCreateTime(new Date());
		image1.setPlatform(platform);
		
		Image image2 = new Image();
		image2.setId(2);
		image2.setTitle("图片2");
		image2.setPath("b.jpg");
		image2.setUuid(IdGenerator.generateId());
		image2.setCreateTime(new Date());
		image2.setPlatform(platform);
		
		imageList.add(image1);
		imageList.add(image2);

		companyProfile.setImages(imageList);
		
		companyProfileService.edit(companyProfile);
	}
	
	@Test
	public void find() {
		CompanyProfile companyProfile = companyProfileService.find("2");
		System.out.println(companyProfile.getCompanyName() + " " + companyProfile.getContent() + " " + companyProfile.getUuid());
		if(companyProfile.getImages() != null) {
			for(Image image : companyProfile.getImages()) {
				System.out.println(image.getTitle() + " " + image.getPath());
			}
		}
	}
	
	@Test
	public void getByPlatform() {
		Platform platform = platformService.getByOriginalId("luo_shengsha");
		CompanyProfile companyProfile = companyProfileService.getByPlatform(platform);
		System.out.println(companyProfile.getCompanyName() + " " + companyProfile.getContent() + " " + companyProfile.getUuid());
		if(companyProfile.getImages() != null) {
			for(Image image : companyProfile.getImages()) {
				System.out.println(image.getTitle() + " " + image.getPath());
			}
		}
	}
	
	@Test
	public void getByUuid() {
		CompanyProfile companyProfile = companyProfileService.getByUuid("FE521C6E7A584276B668650F5DA89FE0");
		System.out.println(companyProfile.getCompanyName() + " " + companyProfile.getContent() + " " + companyProfile.getUuid());
		if(companyProfile.getImages() != null) {
			for(Image image : companyProfile.getImages()) {
				System.out.println(image.getTitle() + " " + image.getPath());
			}
		}
	}
}
