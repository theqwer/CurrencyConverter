package com.currencyconverter.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.currencyconverter.application.ConverterApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConverterApplication.class)
@WebAppConfiguration
public class ConverterApplicationTests {

	@Test
	public void contextLoads() {
	}

}
