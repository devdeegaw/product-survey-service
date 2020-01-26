package com.mg.survey.service.service;

import com.mg.survey.service.domain.Answer;
import com.mg.survey.service.domain.Question;
import com.mg.survey.service.domain.SurveyAnswer;
import com.mg.survey.service.domain.SurveyResponse;
import com.mg.survey.service.model.OfferedAnswer;
import com.mg.survey.service.model.SurveyQuestionAnswer;
import com.mg.survey.service.service.port.AnswerRepository;
import com.mg.survey.service.service.port.QuestionRepository;
import com.mg.survey.service.service.port.SurveyResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyServiceImpl implements SurveyService {

    private SurveyResponseRepository surveyResponseRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    public SurveyServiceImpl(SurveyResponseRepository surveyResponseRepository,
                             QuestionRepository questionRepository,
                             AnswerRepository answerRepository) {
        this.surveyResponseRepository = surveyResponseRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public void submitSurvey(String userName, int productId,
                             List<SurveyQuestionAnswer> surveyQuestionAnswers) {

        SurveyResponse surveyResponse = new SurveyResponse();
        addSurveyAnswer(surveyResponse, surveyQuestionAnswers);
        surveyResponse.setProductId(productId);
        surveyResponse.setUserName(userName);
        surveyResponseRepository.save(surveyResponse);
    }


    private void addSurveyAnswer(SurveyResponse surveyResponse, List<SurveyQuestionAnswer> questionAnswers) {
        List<SurveyAnswer> surveyAnswers = questionAnswers.stream()
                .map(this::createSurveyAnswer).collect(Collectors.toList());

        for (SurveyAnswer surveyAnswer : surveyAnswers) {
            surveyResponse.addSurveyAnswer(surveyAnswer);
        }
    }

    private SurveyAnswer createSurveyAnswer(SurveyQuestionAnswer questionAnswer) {
        SurveyAnswer surveyAnswer = new SurveyAnswer();
        Question question = getQuestion(questionAnswer.getQuestionId());
        Answer answer = getAnswer(questionAnswer.getAnswerId());
        surveyAnswer.setQuestion(question);
        surveyAnswer.setAnswer(answer);
        return surveyAnswer;
    }

    private Question getQuestion(int questionId) {
        return questionRepository.findByQuestionId(questionId);
    }

    private Answer getAnswer(int selectedOption) {
        return answerRepository.findByOfferedAnswer(OfferedAnswer.getOfferedAnswerByCode(selectedOption));
    }

}
