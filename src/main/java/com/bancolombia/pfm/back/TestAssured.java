package com.bancolombia.pfm.back;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.log4j.Logger;

public class TestAssured {
	
	private static final Logger logger = Logger.getLogger(TestAssured.class);

	@Test
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
	        
	    given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	    
	}
	
	@Test
	public void test_Md5CheckSumForTest_ShouldBe098f6bcd4621d373cade4e832627b4f6() {
	    
	    String originalText = "test";
	    String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6";
	        
	    given().
	        param("text",originalText).
	    when().
	        get("http://md5.jsontest.com").
	    then().
	        assertThat().
	        body("md5",equalTo(expectedMd5CheckSum));
	}
	
	
}
