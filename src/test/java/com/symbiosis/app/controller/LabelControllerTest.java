package com.symbiosis.app.controller;

import com.symbiosis.app.entity.Label;
import com.symbiosis.app.repository.LabelRepository;
import com.symbiosis.app.service.LabelService;
import com.symbiosis.app.service.impl.LabelServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = LabelController.class)
@WebMvcTest(LabelController.class)
@WithMockUser(username = "admin", roles = {"ADMIN"})
class LabelControllerTest {

    @MockBean
    LabelServiceImpl labelService;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        try (AutoCloseable a = MockitoAnnotations.openMocks(this)) {}
        doReturn(List.of(new Label()))
                .when(labelService).findAll(null, null);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllLabels() throws Exception {
        mockMvc.perform(get("/labels")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(equalTo(1))));
    }
}