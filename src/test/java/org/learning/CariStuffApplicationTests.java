package org.learning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.caristuff.CariStuffApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CariStuffApplication.class)
@WebAppConfiguration
public class CariStuffApplicationTests {

	@Test
	public void contextLoads() {
	}

}
