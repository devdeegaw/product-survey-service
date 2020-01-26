package com.mg.survey.service.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class SurveyResponseTest {

    private SurveyResponse surveyResponse;

    @Before
    public void setUp() {
        surveyResponse = new SurveyResponse();
    }

    @Test
    public void testAddSurveyAnswer() {
        SurveyAnswer surveyAnswer = new SurveyAnswer();
        surveyResponse.addSurveyAnswer(surveyAnswer);
        assertThat(surveyResponse.getSurveyAnswers(), hasItem(surveyAnswer));
        assertThat(surveyAnswer.getSurveyResponse(), equalTo(surveyResponse));
    }

}