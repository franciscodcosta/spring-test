package com.in28minutes.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	@Test
	public void learning() {
		String responseFromService = "[" + 
				"{\"id\":10000, \"name\": \"Lapis\", \"quantity\": 5}," + 
				"{\"id\":10001, \"name\": \"Caneta\", \"quantity\": 20}," + 
				"{\"id\":10002, \"name\": \"Borracha\", \"quantity\": 15}" + 
				"]";
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(10000,10001,10002);
		//context.read("$.[1]")
		//context.read("$.[0:2]")
		//context.read("$.[?(@.name=='Caneta']")
		//context.read("$.[?(@.quantity==15]")
		
	}

}
