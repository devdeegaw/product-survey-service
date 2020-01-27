package com.mg.survey.service.api;

import com.mg.survey.service.domain.Question;

import java.util.List;
import java.util.Set;

public interface ProductResource {

    void addProductQuestion(int productId, Set<QuestionDto> questionDto);

    List<Question> getProductQuestions(int productId);

}
