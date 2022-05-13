package de.bredex.inventory.application.api;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class InventoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void GET_returns_inventory() throws Exception {
	mvc.perform(get("/api/v1/inventory").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.*", hasSize(10)));
    }
}
