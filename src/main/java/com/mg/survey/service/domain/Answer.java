package com.mg.survey.service.domain;

import com.mg.survey.service.model.OfferedAnswer;
import lombok.Data;

import javax.persistence.*;

;

@Data
@Entity
@Table(name = "ANSWER")
public class Answer {

    @Id
    @Column(name = "ANSWER_ID")
    private int answerId;

    @Column(name = "OFFERED_ANSWER")
    @Enumerated(EnumType.STRING)
    private OfferedAnswer offeredAnswer;
}
