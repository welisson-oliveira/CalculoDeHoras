package br.com.welisson.calculoDeHoras.domain;

import br.com.welisson.calculoDeHoras.config.SpringContextTestConfiguration;
import br.com.welisson.calculoDeHoras.config.WebConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * {@link TimeTest}
 *
 * @author Welisson Oliveira
 * @version 1.0 12/10/2017
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringContextTestConfiguration.class, WebConfig.class})
public class TimeTest {

	@Test
	public void subtractTest() throws Exception {
		Time time = new Time(9, 04);

		Time result = time.subtractTime(new Time(9,3));
		new Time(00,01);
		Assert.assertEquals(result, new Time(00,1));
	}

	@Test(expected = Exception.class)
	public void subtractTestError() throws Exception {
		Time time = new Time(9, 04);

		Time result = time.subtractTime(new Time(9,5));
	}

	@Test
	public void sumTest(){
		Time time = new Time(9, 04);
		Time timeForSum = new Time(16,00);
		Assert.assertEquals(time.sumTime(timeForSum), new Time(1,4));
	}


}
