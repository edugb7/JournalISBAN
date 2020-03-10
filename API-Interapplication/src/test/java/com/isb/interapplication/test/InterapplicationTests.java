package com.isb.interapplication.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.isb.interapplication.repository.InterapplicationRepositoryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class InterapplicationTests {

	@Autowired
    protected InterapplicationRepositoryDTO interRepo;
	
	@Autowired
    protected WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void postInfo() throws Exception {
    	
    	HttpHeaders httpHeaders = new HttpHeaders();
    	
    	httpHeaders.add("X-IBM-Client-Id", "a1b30a84-7bf3-442e-84a0-e935d8163b5a");
    	httpHeaders.add("X-Santander-Global-Id", "a315bt3v0a84");
    	httpHeaders.add("Authorization", "Bearer 923ioh89r23ohwedh823ohdn9hite89yyugfsdf");
    	
    	String jsonEntrada = 
        		"{\"interapplicationOrderRequest\":{"
        		+ "\"sourceIntapp\":\"EH\","
        		+ "\"targetIntapp\":\"PL\","
        		+ "\"journalOperationId\":\"550e8400-e29b-41d4-a716-446655440000\","
        		+ "\"bundle\":\"650e8400-e29b-41d4-a716-446655440000\","
        		+ "\"targetCostCenter\":{"
        		+ "\"targetCompany\":\"0049\","
        		+ "\"targetCenter\":\"6999\""
        		+ "},"
        		+ "\"sourceCostCenter\":{"
        		+ "\"sourceCompany\":\"0049\","
        		+ "\"sourceCenter\":\"6999\""
        		+ "},"
        		+ "\"orderText\":\"Text asociated to an order\","
        		+ "\"movementText\":\"Text asociated to a movement\","
        		+ "\"operationAmount\":{"
        		+ "\"amount\":1.2345678901234512E16,"
        		+ "\"currency\":\"EUR\","
        		+ "\"journalOperationType\":\"004916991031234567001\""
        		+ "},"
        		+ "\"movementCode\":\"3\""
        		+ "}"
        		+ "}";
    	
        mockMvc.perform(post("/interapplication/create_order")
        		.content(jsonEntrada.trim())
        		.headers(httpHeaders)
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isCreated());
    }
}
