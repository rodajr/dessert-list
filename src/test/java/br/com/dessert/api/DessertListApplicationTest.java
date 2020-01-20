package br.com.dessert.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) 
@SpringBootTest
@TestPropertySource(locations = "classpath:application-tests.properties")
class DessertListApplicationTest {

	@Test(expected = BeanCreationException.class) 
	void testMain() {
		String[] args = {"a", "b", "c"};
		DessertListApplication.main(args);
	}

}
