package com.mg.survey.service.api.transformer;

import com.mg.survey.service.api.QuestionDto;
import com.mg.survey.service.domain.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionTransformer {

    public Question transformToQuestion(QuestionDto questionDto) {
        Question question = new Question();
        question.setQuestionText(questionDto.getQuestionText());
        return question;
    }

}
