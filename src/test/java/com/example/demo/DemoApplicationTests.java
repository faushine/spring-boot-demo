package com.example.demo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private CountryService countryService;

	@Test
	public void getCountCountrytest() {
		int count = countryService.getCountCountries();
		System.out.println(count);
	}

	@Test
	public void getCountryTest() throws IOException {
		List<CountryEntity> countryEntities = countryService.getListCountries(10,0);
		System.out.println(countryEntities);
	}

	@Test
	public void getCityTest() throws IOException{
		List<CityEntity> cityEntities = countryService.getListCities("BRA",10,0);
		System.out.println(cityEntities);
	}

	@Test
	public void getCountCity(){
		int count = countryService.getCountCities("BRA");
		System.out.println("==========");
		System.out.println(count);
		System.out.println("=========");
	}

}

