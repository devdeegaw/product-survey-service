package com.mg.survey.service.api;

import com.mg.survey.service.domain.Question;

import java.util.List;

public interface ProductResource {

    void addProductQuestion(int productId, List<QuestionDto> questionDto);

    List<Question> getProductQuestions(int productId);

}
