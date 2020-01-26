package com.mg.survey.service.service;

import com.mg.survey.service.domain.Product;
import com.mg.survey.service.domain.Question;
import com.mg.survey.service.exception.ProductNotFoundException;
import com.mg.survey.service.service.port.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addQuestion(int productId, List<Question> questions) {
        Product product = findProduct(productId);
        addQuestionToProduct(product, questions);
        productRepository.save(product);
    }

    @Override
    public List<Question> getQuestions(int productId) {
        Product product = findProduct(productId);
        return product.getQuestions();
    }

    private void addQuestionToProduct(Product product, List<Question> questions){
        for (Question question : questions) {
            product.addQuestion(question);
        }
    }

    private Product findProduct(int productId) {

        return productRepository.findByProductId(productId)
                .orElseThrow(()-> new ProductNotFoundException("Product not found for product id:" + productId));
    }
}
