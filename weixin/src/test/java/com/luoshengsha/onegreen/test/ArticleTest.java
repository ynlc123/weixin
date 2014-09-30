package com.luoshengsha.onegreen.test;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoshengsha.onegreen.bean.Article;
import com.luoshengsha.onegreen.bean.Platform;
import com.luoshengsha.onegreen.service.ArticleService;
import com.luoshengsha.onegreen.service.ImageService;
import com.luoshengsha.onegreen.service.PlatformService;
import com.luoshengsha.onegreen.utils.IdGenerator;
import com.luoshengsha.onegreen.utils.page.PageView;
import com.luoshengsha.onegreen.utils.page.QueryResult;

/**
 * 文章单元测试
 * @author luoshengsha
 * @date 2014年9月10日 上午10:56:12
 */
public class ArticleTest {
	protected static PlatformService platformService;
	protected static ArticleService articleService;
	protected static ImageService imageService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			platformService = (PlatformService)cxt.getBean("platformServiceImpl");
			articleService = (ArticleService)cxt.getBean("articleServiceImpl");
			imageService = (ImageService)cxt.getBean("imageServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存
	 */
	@Test
	public void save() {
		//保存文本文章
		Article text_article = new Article();
		text_article.setUuid(IdGenerator.generateId());
		text_article.setTitle("这是第一篇文本文章");
		text_article.setContent("文本文章内容");
		text_article.setCreateTime(new Date());
		text_article.setEditTime(new Date());
		text_article.setPlatform(platformService.getByOriginalId("gh_3e7314baeab1"));
		
		articleService.save(text_article);
		
		//保存图文文章
		Article image_text_article = new Article();
		image_text_article.setUuid(IdGenerator.generateId());
		image_text_article.setTitle("这是第一篇图文文章");
		image_text_article.setContent("图文文章内容");
		image_text_article.setImage(imageService.find(3));
		image_text_article.setCreateTime(new Date());
		image_text_article.setEditTime(new Date());
		image_text_article.setPlatform(platformService.getByOriginalId("gh_3e7314baeab1"));
		
		articleService.save(image_text_article);
	}
	
	/**
	 * 更新
	 */
	@Test
	public void update() {
		//更新文本文章
		Article text_article = articleService.find("1");
		text_article.setTitle("这是第一篇文本文章2");
		text_article.setContent("文本文章内容2222");
		text_article.setEditTime(new Date());
		articleService.update(text_article);
		
		//更新图文文章
		Article image_text_article = articleService.getByUuid("BDFC342981174B659C6B16DED4392D66");
		image_text_article.setTitle("这是第一篇图文文章44444");
		image_text_article.setContent("图文文章内容44444");
		image_text_article.setImage(imageService.find(2));
		image_text_article.setEditTime(new Date());
		articleService.update(image_text_article);
	}
	
	/**
	 * 根据id获取文章
	 */
	@Test
	public void find() {
		Article text_article = articleService.find("1");
		System.out.println(text_article.getTitle() + "  " + text_article.getContent() + " " + text_article.getImage());
	}
	
	/**
	 * 根据uuid获取文章
	 */
	@Test
	public void getByUuid() {
		Article image_text_article = articleService.getByUuid("BDFC342981174B659C6B16DED4392D66");
		System.out.println(image_text_article.getTitle() + "  " + image_text_article.getContent() + " " + image_text_article.getImage());
	}
	
	/**
	 * 查询
	 */
	@Test
	public void query() {
		PageView<Article> pageView = new PageView<Article>(1, 10);
		//条件
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		Platform platform = platformService.getByOriginalId("gh_3e7314baeab1");
		conditionMap.put("platform", platform);
		//排序
		LinkedHashMap<String,String> orderBy = new LinkedHashMap<String,String>();
		
		QueryResult<Article> qr = articleService.query(pageView.getFirstResult(),pageView.getMaxresult(), conditionMap,orderBy);
		pageView.setQueryResult(qr);
		
		for(Article article : pageView.getRecords()) {
			System.out.println(article.getUuid() + " " + article.getTitle() + " " + article.getContent() + " " + article.getImage());
		}
	}
}
