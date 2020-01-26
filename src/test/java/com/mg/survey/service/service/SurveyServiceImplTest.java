package com.mg.survey.service.service;

import com.mg.survey.service.domain.Answer;
import com.mg.survey.service.domain.Question;
import com.mg.survey.service.domain.SurveyResponse;
import com.mg.survey.service.model.OfferedAnswer;
import com.mg.survey.service.model.SurveyQuestionAnswer;
import com.mg.survey.service.service.port.AnswerRepository;
import com.mg.survey.service.service.port.QuestionRepository;
import com.mg.survey.service.service.port.SurveyResponseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SurveyServiceImplTest {

    private static final int QUESTION_ID = 333;
    private static final OfferedAnswer OFFERED_ANSWER = OfferedAnswer.ONE;
    private static final int PRODUCT_ID = 1234;
    private static final String USER_NAME = "USER_NAME";

    @Mock
    private SurveyResponseRepository surveyResponseRepository;
    @Mock
    private QuestionRepository questionRepository;
    @Mock
    private AnswerRepository answerRepository;
    @Mock
    private Question question;
    @Mock
    private Answer answer;
    @Mock
    private SurveyQuestionAnswer surveyQuestionAnswer;

    private SurveyService surveyService;

    @Before
    public void setUp() {
        surveyService = new SurveyServiceImpl(surveyResponseRepository,
                questionRepository, answerRepository);
    }

    @Test
    public void testSubmitSurvey() {
        givenExpectedQuestionAndAnswer();
        whenSurveySubmitted();
        thenSurveyResponseSaved();
    }

    private void whenSurveySubmitted() {
        surveyService.submitSurvey(USER_NAME, PRODUCT_ID, Collections.singletonList(surveyQuestionAnswer));
    }

    private void thenSurveyResponseSaved() {
        verify(surveyResponseRepository).save(any(SurveyResponse.class));
    }

    private void givenExpectedQuestionAndAnswer() {
        when(questionRepository.findByQuestionId(QUESTION_ID)).thenReturn(question);
        when(answerRepository.findByOfferedAnswer(OFFERED_ANSWER)).thenReturn(answer);
    }
}