package com.isb.conciliator.test;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import java.util.UUID;

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

import com.isb.conciliator.entity.ConciliatorEntity;
import com.isb.conciliator.repository.RepositoryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ApiGlobalMovementsConciliatorApplicationTests {

	@Autowired
    protected RepositoryDTO conciliatorRepo;
	
	@Autowired
    protected WebApplicationContext webApplicationContext;
 
    private MockMvc mockMvc;
 
    private static final UUID idConciliator = UUID.fromString("a57f02b0-304a-4d40-a75a-ad594a40bb62");
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
	    
	@Test
	public void ensureGetId() {
		
    	Optional<ConciliatorEntity> conciliator = conciliatorRepo.findById(idConciliator);
    	
		assertNotNull(conciliator);
		
	}
	
	@Test
    public void getInfo_ShouldReturnCorrectInfo() throws Exception {
        
		String jsonExpected = 
			"{\"movementId\":\"77bbc47e-29ed-42bd-b5f6-90ef4a9ee489\","
			+ "\"journalOperationId\":\"12345678\","
			+ "\"bundle\":\"650e8400-e29b\","
			+ "\"serviceId\":\"00491699669001\","
			+ "\"contract\":{"
			+ "\"contractId\":\"0049165530\","
			+ "\"contractType\":\"BBAN\""
			+ "},"
			+ "\"balancePosition\":\"000\","
			+ "\"operationType\":\"Credit\","
			+ "\"movementAmount\":{"
			+ "\"amount\":1234.0,"
			+ "\"currency\":\"EUR\","
			+ "\"journalOperationType\":\"004916991\""
			+ "},"
			+ "\"movementCode\":\"3\","
			+ "\"certificationMsgList\":"
			+ "[{"
			+ "\"certificationMsg\":\"Credit executed correctly\""
			+ "}]"
			+ "}";
        
		mockMvc.perform(get("/movements_conciliator/{journalOperationId}", UUID.fromString("77bbc47e-29ed-42bd-b5f6-90ef4a9ee489"))
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
                .andExpect(content().string(jsonExpected.trim()));
    }
 
    @Test
    public void postInfo_ShouldReturnCreatedStatusAndCorrectInfo() throws Exception {
    	
    	HttpHeaders httpHeaders = new HttpHeaders();
    	
    	httpHeaders.add("X-IBM-Client-Id", "a1b30a84-7bf3-442e-84a0-e935d8163b5a");
    	httpHeaders.add("X-Santander-Global-Id", "a315bt3v0a84");
    	httpHeaders.add("Authorization", "Bearer 923ioh89r23ohwedh823ohdn9hite89yyugfsdf");
    	
    	String jsonEntrada = 
    			"{\"journalOperationId\":\"12345678\","
    			+ "\"bundle\":\"650e8400-e29b\","
    			+ "\"serviceId\":\"00491699669001\","
    			+ "\"contract\":{"
    			+ "\"contractId\":\"0049165530\","
    			+ "\"contractType\":\"BBAN\""
    			+ "},"
    			+ "\"balancePosition\":\"000\","
    			+ "\"operationType\":\"Credit\","
    			+ "\"movementAmount\":{"
    			+ "\"amount\":1234.0,"
    			+ "\"currency\":\"EUR\","
    			+ "\"journalOperationType\":\"004916991\""
    			+ "},"
    			+ "\"movementCode\":\"3\","
    			+ "\"certificationMsgList\":"
    			+ "[{"
    			+ "\"certificationMsg\":\"Credit executed correctly\""
    			+ "}]"
    			+ "}";

    	
        mockMvc.perform(post("/movements_conciliator/create_movement")
        		.content(jsonEntrada.trim())
        		.headers(httpHeaders)
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isCreated());
    }

    @Test
    public void deleteInfo_ShouldReturnCorrectInfo() throws Exception {
        
    	HttpHeaders httpHeaders = new HttpHeaders();
    	
    	httpHeaders.add("X-IBM-Client-Id", "a1b30a84-7bf3-442e-84a0-e935d8163b5a");
    	httpHeaders.add("X-Santander-Global-Id", "a315bt3v0a84");
    	httpHeaders.add("Authorization", "Bearer 923ioh89r23ohwedh823ohdn9hite89yyugfsdf");
 
        mockMvc.perform(delete("/movements_conciliator/{journalOperationId}", UUID.fromString("5079d996-2c55-4030-beb9-780842181158"))
        		.headers(httpHeaders)
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}