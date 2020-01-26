package com.mg.survey.service.api;

import com.mg.survey.service.model.SurveyQuestionAnswer;

import java.util.List;

public interface SurveyResource {

    void submitSurvey(String user, int productId, List<SurveyQuestionAnswer> questionAnswers);
}
