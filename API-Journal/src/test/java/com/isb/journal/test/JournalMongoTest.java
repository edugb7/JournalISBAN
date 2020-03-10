package com.isb.journal.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
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

import com.isb.journal.entity.norelacional.JournalEntityMongo;
import com.isb.journal.repository.RepositoryMongoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class JournalMongoTest {

	@Autowired
    protected RepositoryMongoDTO journalRepo;
	
	@Autowired
    protected WebApplicationContext webApplicationContext;
 
    private MockMvc mockMvc;
 
    private static final UUID idJournal = UUID.fromString("cc725814-2615-4839-bb28-61898116c0be");
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
	    
	@Test
	public void ensureGetJournalId() {
		
    	Optional<JournalEntityMongo> journal = journalRepo.findById(idJournal);
    	
		assertNotNull(journal);
		
	}
 
	
	@Test
	public void ensureGetAll() {
		
		List<JournalEntityMongo> journals = journalRepo.findAll();
		
		assertNotNull(journals);
		
		assertTrue(journals.size() > 0);		
	}
	
	@Test
    public void getInfo_ShouldReturnCorrectInfo() throws Exception {
        
		String jsonExpected = 
        		"{\"journalOperationRequest\":{" + 
        		"\"journalOperationList\":[" + 
        		"{" + 
        		"\"companyCode\":\"0049\"," + 
        		"\"instanceCode\":\"Santander Spain\"," + 
        		"\"journalOperationType\":\"0049103001009004\"," + 
        		"\"externalReference\":\"1234567890123456789012345674890\"," + 
        		"\"mainContract\":\"123456789123456789123456789000\"" + 
        		"}" + 
        		"]," + 
        		"\"operationAmount\":{" + 
        		"\"amount\":4000.0," + 
        		"\"currency\":\"EUR\"" + 
        		"}," + 
        		"\"accountingCostCenter\":{" + 
        		"\"accountingCompany\":\"0049\"," + 
        		"\"accountingCenter\":\"1699\"" + 
        		"}," + 
        		"\"targetCostCenter\":{" + 
        		"\"targetCompany\":\"0049\"," + 
        		"\"targetCenter\":\"6999\"" + 
        		"}," + 
        		"\"userCostCenter\":{" + 
        		"\"userCompany\":\"0049\"," + 
        		"\"userCenter\":\"1500\"" + 
        		"}," + 
        		"\"postingType\":\"Direct\"" + 
        		"}" + 
        		"}";
 
        mockMvc.perform(get("/journal_operations/mongo/{journal_operation_id}", idJournal)
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
                .andExpect(content().string(jsonExpected.trim()));
    }
 
    @Test
    public void postInfo() throws Exception {
    	
    	HttpHeaders httpHeaders = new HttpHeaders();
    	
    	httpHeaders.add("X-IBM-Client-Id", "a1b30a84-7bf3-442e-84a0-e935d8163b5a");
    	httpHeaders.add("X-Santander-Global-Id", "a315bt3v0a84");
    	httpHeaders.add("Authorization", "Bearer 923ioh89r23ohwedh823ohdn9hite89yyugfsdf");
    	
    	String jsonEntrada = 
        		"{\"journalOperationRequest\":{" + 
        		"\"journalOperationList\":[" + 
        		"{" + 
        		"\"companyCode\":\"0049\"," + 
        		"\"instanceCode\":\"Santander Spain\"," + 
        		"\"journalOperationType\":\"0049103001009004\"," + 
        		"\"externalReference\":\"123456789012\"," + 
        		"\"mainContract\":\"123456789123\"" + 
        		"}]" + 
        		"}}";
    	
        mockMvc.perform(post("/journal_operations/mongo/create_journal_operation")
        		.content(jsonEntrada.trim())
        		.headers(httpHeaders)
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isCreated());
    }
    
    @Test
    public void putInfo() throws Exception {
    	
    	HttpHeaders httpHeaders = new HttpHeaders();
    	
    	httpHeaders.add("X-IBM-Client-Id", "a1b30a84-7bf3-442e-84a0-e935d8163b5a");
    	httpHeaders.add("X-Santander-Global-Id", "a315bt3v0a84");
    	httpHeaders.add("Authorization", "Bearer 923ioh89r23ohwedh823ohdn9hite89yyugfsdf");
    	
    	String jsonEntrada = 
    			"{\"journalOperationRequest\":{" + 
        		"\"journalOperationList\":[" + 
        		"{" + 
        		"\"companyCode\":\"0049\"," + 
        		"\"instanceCode\":\"Santander Spain\"," + 
        		"\"journalOperationType\":\"0049103001009004\"," + 
        		"\"externalReference\":\"1234567890123456789012345674890\"," + 
        		"\"mainContract\":\"123456789123456789123456789000\"" + 
        		"}" + 
        		"]," + 
        		"\"operationAmount\":{" + 
        		"\"amount\":4000.0," + 
        		"\"currency\":\"EUR\"" + 
        		"}," + 
        		"\"accountingCostCenter\":{" + 
        		"\"accountingCompany\":\"0049\"," + 
        		"\"accountingCenter\":\"1699\"" + 
        		"}," + 
        		"\"targetCostCenter\":{" + 
        		"\"targetCompany\":\"0049\"," + 
        		"\"targetCenter\":\"6999\"" + 
        		"}," + 
        		"\"userCostCenter\":{" + 
        		"\"userCompany\":\"0049\"," + 
        		"\"userCenter\":\"1500\"" + 
        		"}," + 
        		"\"postingType\":\"Direct\"" + 
        		"}" + 
        		"}";
    	
        mockMvc.perform(put("/journal_operations/mongo/{journal_operation_id}", idJournal)
        		.content(jsonEntrada.trim())
        		.headers(httpHeaders)
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk());
    }
}
