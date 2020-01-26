package com.mg.survey.service.service;

import com.mg.survey.service.domain.Product;
import com.mg.survey.service.domain.Question;
import com.mg.survey.service.exception.ProductNotFoundException;
import com.mg.survey.service.service.port.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private Product product;
    @Mock
    private Question question;

    private ProductService productService;

    private static final int PRODUCT_ID = 1234;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void testAddQuestion() {
        givenProductAvailable();
        whenQuestionAddedToProduct();
        thenProductUpdatedWithQuestion();
    }

    @Test
    public void testGetQuestions() {
        givenProductAvailable();
        whenGetProductQuestions();
        thenReturnProductQuestions();
    }

    @Test(expected = ProductNotFoundException.class)
    public void testProductNotFound() {
        givenProductNotAvailable();
        whenGetProductQuestions();
    }

    private void whenGetProductQuestions() {
        productService.getQuestions(PRODUCT_ID);
    }

    private void thenReturnProductQuestions() {
        assertThat(product.getQuestions(), hasItem(question));
    }

    private void thenProductUpdatedWithQuestion() {
        verify(productRepository).save(product);
    }

    private void whenQuestionAddedToProduct() {
        productService.addQuestion(PRODUCT_ID, Collections.singletonList(question));
    }

    private void givenProductAvailable() {
        when(productRepository.findByProductId(PRODUCT_ID)).thenReturn(Optional.of(product));
        when(product.getQuestions()).thenReturn(Collections.singletonList(question));
    }

    private void givenProductNotAvailable() {
        when(productRepository.findByProductId(PRODUCT_ID)).thenReturn(Optional.empty());
    }
}