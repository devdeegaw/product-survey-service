package com.mg.survey.service.service;

import com.mg.survey.service.domain.Question;

import java.util.List;

public interface ProductService {

    void addQuestion(int productId, List<Question> question);
    List<Question> getQuestions(int productId);

}
