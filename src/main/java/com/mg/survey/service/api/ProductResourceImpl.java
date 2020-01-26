package com.mg.survey.service.api;

import com.mg.survey.service.api.transformer.QuestionTransformer;
import com.mg.survey.service.domain.Question;
import com.mg.survey.service.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
public class ProductResourceImpl implements ProductResource {

    private ProductService productService;
    private QuestionTransformer questionTransformer;

    public ProductResourceImpl(ProductService productService,
                               QuestionTransformer questionTransformer) {
        this.productService = productService;
        this.questionTransformer = questionTransformer;
    }

    @Override
    @PostMapping("/{productId}/questions/add")
    public void addProductQuestion(@PathVariable("productId") int productId,
                                   @RequestBody List<QuestionDto> questionDtos) {
        productService.addQuestion(productId,
                questionDtos.stream()
                        .map(questionTransformer::transformToQuestion).collect(Collectors.toList()));

    }

    @Override
    @GetMapping("/{productId}/questions")
    public List<Question> getProductQuestions(@PathVariable("productId") int productId) {
        return productService.getQuestions(productId);
    }

}
