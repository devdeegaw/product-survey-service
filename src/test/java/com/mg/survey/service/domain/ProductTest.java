package com.mg.survey.service.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class ProductTest {


    private Product product;

    @Before
    public void setUp() {
        product = new Product();
    }

    @Test
    public void testAddQuestion() {
        Question question = new Question();
        product.addQuestion(question);
        assertThat(product.getQuestions(), hasItem(question));
        assertThat(question.getProduct(), equalTo(product));
    }

}