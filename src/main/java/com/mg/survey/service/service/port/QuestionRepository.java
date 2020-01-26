package com.mg.survey.service.service.port;

import com.mg.survey.service.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

    Question findByQuestionId(int questionId);
}
