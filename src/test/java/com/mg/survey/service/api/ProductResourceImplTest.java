package com.mg.survey.service.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mg.survey.service.domain.Question;
import com.mg.survey.service.service.ProductService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductResourceImplTest {

    private static final int PRODUCT_ID = 1234;
    private static final String PRODUCT_BASE_URL = "/api/product/";
    private static final String GET_PRODUCT_QUESTIONS_URL = PRODUCT_BASE_URL + PRODUCT_ID + "/questions";
    private static final String ADD_PRODUCT_QUESTIONS_URL = PRODUCT_BASE_URL + PRODUCT_ID + "/questions/add";

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    JacksonTester<List<Question>> questionJacksonTester;

    JacksonTester<List<QuestionDto>> questionDtoJacksonTester;

    @Before
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        when(productService.getQuestions(PRODUCT_ID)).thenReturn(getTestQuestion());
    }

    @Test
    public void testGetProductQuestions() throws Exception {
        MockHttpServletResponse response =
                mockMvc.perform(get(GET_PRODUCT_QUESTIONS_URL)).andReturn().getResponse();

        assertThat(response.getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), equalTo(questionJacksonTester.write(getTestQuestion()).getJson()));
    }

    @Test
    public void testAddProductQuestions() throws Exception {
        MockHttpServletResponse response =
                mockMvc.perform(post(ADD_PRODUCT_QUESTIONS_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(questionDtoJacksonTester.write(getTestQuestionDtos()).getJson())
                ).andReturn().getResponse();

        assertThat(response.getStatus(), equalTo(HttpStatus.OK.value()));
    }

    private List<Question> getTestQuestion(){
        Question question = new Question();
        question.setQuestionText("Text");
        question.setQuestionId(11);
        return Collections.singletonList(question);
    }

    private List<QuestionDto> getTestQuestionDtos(){
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionText("text");
        return Collections.singletonList(questionDto);
    }

}