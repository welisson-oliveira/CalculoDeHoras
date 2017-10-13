package br.com.welisson.calculoDeHoras.domain;

import br.com.welisson.calculoDeHoras.config.SpringContextTestConfiguration;
import br.com.welisson.calculoDeHoras.config.WebConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringContextTestConfiguration.class, WebConfig.class})
public class CalculatesTest {

	@Test
	public void test()  {
		Calculates calculates = new Calculates();

		Time saidaProvavel = calculates.likelyExit(new Time(9, 04));

		//System.out.println("Saída provável: " + saidaProvavel.getHour() + ":" + saidaProvavel.getMinute());
		Time time = new Time(18, 4);
		Assert.assertTrue(saidaProvavel.equals(time));

		calculates = new Calculates();
		Time saida = calculates.exitTime(
				new Time(9, 04),
				new Time(12, 13),
				new Time(13, 03));

		time = new Time(17, 54);
		Assert.assertTrue(saida.equals(time));

	}
}
