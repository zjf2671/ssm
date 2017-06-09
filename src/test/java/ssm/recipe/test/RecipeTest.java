package ssm.recipe.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.service.recipe.RecipeCountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context*.xml" })
public class RecipeTest {
	
	@Autowired
	private RecipeCountService recipeCountService;
	
	@Test
	public void testfindList() {
		
		System.out.println(recipeCountService.findList().get(0).getName());
		
	}
	

}
