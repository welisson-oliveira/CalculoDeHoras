package br.com.welisson.calculoDeHoras.restapi;

import br.com.welisson.calculoDeHoras.config.SpringContextTestConfiguration;
import br.com.welisson.calculoDeHoras.config.WebConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * {@link CalculatesControllerTest}
 *
 * @author Welisson Oliveira
 * @version 1.0 13/10/2017
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringContextTestConfiguration.class, WebConfig.class})
public class CalculatesControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	//FIXME - descobrir a forma certa de realizar esse teste
	@Test
	public void getMissingTimeTest() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		final MvcResult result;
		try {
			result = mockMvc.perform(MockMvcRequestBuilders.post("/calculates/missingTime").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"hour\":9,\"minutes\":4}")).andReturn();
			final String jsonResult = result.getResponse().getContentAsString();
			System.out.println(jsonResult);

		} catch (Exception e) {
			Assert.assertEquals(e.getCause().getMessage(), "Horário de saída ja passou");
		}


	}

	@Test
	public void getLikelyExitTimeTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		final MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/calculates/likelyExit").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"hour\":9,\"minutes\":4}")).andReturn();
		final String jsonResult = result.getResponse().getContentAsString();
		System.out.println(jsonResult);
		JSONAssert.assertEquals("{\"hour\":18,\"minutes\":4}", jsonResult, true);
	}

	@Test
	public void getExitTimeTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		final MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/calculates/exitTime").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"entryTime\":{\"hour\":9,\"minutes\":4},\"lunchTimeInit\":{\"hour\":12,\"minutes\":13},\"lunchTimeEnd\":{\"hour\":13,\"minutes\":3}}")).andReturn();
		final String jsonResult = result.getResponse().getContentAsString();
		//System.out.println(jsonResult);
		JSONAssert.assertEquals("{\"hour\":17,\"minutes\":54}", jsonResult, true);
	}
}
