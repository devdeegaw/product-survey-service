package com.mg.survey.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SURVEY_ANSWER")
public class SurveyAnswer {

    @Id
    @GeneratedValue
    @Column(name = "SURVEY_ANSWER_ID")
    private int surveyAnswerId;

    @OneToOne
    private Question question;

    @OneToOne
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "SURVEY_ID")
    @JsonIgnore
    private SurveyResponse surveyResponse;
}
