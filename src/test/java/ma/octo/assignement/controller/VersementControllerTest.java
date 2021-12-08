package ma.octo.assignement.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VersementControllerTest {
	@Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    
	@Test
    void createTransactionTest() throws Exception {
		  VersementDto versementDto = new VersementDto(0L,"user1","prenom","RIB1","","motif",new Date(), new BigDecimal(100));

		  mvc.perform(MockMvcRequestBuilders
				    .post("/versement/executerVersements", 10)
	                .contentType("application/json")
	                .content(objectMapper.writeValueAsString(versementDto)) //obj -> json  , shoulde remove @JsonProperty from Rib-versementDto (objectMapper cant use getRib)
	                .accept("application/json"))
	                .andExpect(status().isCreated());

	}
	@Test
	void loadOneTest()  throws Exception{

		mvc.perform(MockMvcRequestBuilders 
				.get("/versement/{id}",5)
				.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	@Test
	void loadAllTest()  throws Exception{

		mvc.perform(MockMvcRequestBuilders 
				.get("/versement/list")
				.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
