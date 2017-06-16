package com.ssm.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.BaseSpringController;
import com.ssm.common.util.RedisUtils;
import com.ssm.service.recipe.RecipeCountService;

@Controller
public class RedisController extends BaseSpringController {
	
    
    @Autowired
    private RedisUtils redisUtils;
    
    @Autowired
    private RecipeCountService recipeCountService;
	
    @RequestMapping("/setRedisValueForObject")
    public String setRedisValue(String key , String value){
    	
    	redisUtils.setCacheObject(key, value);
    	return "test/setRedisValue";
    	
    }
    
    @RequestMapping("/getRedisValueForObject")
    public String getRedisValue(Model model , String key){
    	Object value = redisUtils.getCacheObject(key);
    	model.addAttribute("value",value);
    	return "test/getRedisValue";
    }
    
    @RequestMapping("/setRedisValueForString")
    public String setRedisValueForString(String key , String value){
    	
    	redisUtils.set(key, value);
    	return "test/setRedisValue";
    	
    }
    
    @RequestMapping("/getRedisValueForString")
    public String getRedisValueForString(Model model , String key){
    	Object value = redisUtils.get(key);
    	model.addAttribute("value",value);
    	return "test/getRedisValue";
    }
    
    @RequestMapping("/del")
    public String del(String key){
	    redisUtils.del(key);
		return "test/setRedisValue";
    }
    
    /**
     * @Cacheable注解有三个参数，value是必须的，还有key和condition。第一个参数，也就是value指明了缓存将被存到什么地方。
     * spring默认使用被@Cacheable注解的方法的签名来作为key，当然你可以重写key，自定义key可以使用SpEL表达式
     * @param id
     * @return
     */
    @RequestMapping("/testCacheable")
    @ResponseBody
    @Cacheable(value = "testRedis", key="#root.methodName+'_id='+#id")
    public String testCacheable(String id){
    	recipeCountService.findList();
    	return "test";
    }
    
    /**
     * allEntries:是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存
     * @param id
     * @return
     */
    @RequestMapping("/testCacheEvict")
    @ResponseBody
    @CacheEvict(value = "testRedis", key="#root.methodName+'_id='+#id", allEntries=true)
    public String testCacheEvict(String id){
    	recipeCountService.findList();
    	return "test";
    }

}
