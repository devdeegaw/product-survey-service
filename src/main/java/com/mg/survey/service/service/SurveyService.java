package com.mg.survey.service.service;

import com.mg.survey.service.model.SurveyQuestionAnswer;

import java.util.List;

public interface SurveyService {

    void submitSurvey(String userName, int productId, List<SurveyQuestionAnswer> questionAnswers);

}
