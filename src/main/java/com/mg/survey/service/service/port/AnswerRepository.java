package com.mg.survey.service.service.port;

import com.mg.survey.service.domain.Answer;
import com.mg.survey.service.model.OfferedAnswer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    Answer findByOfferedAnswer(OfferedAnswer offeredAnswer);
}
