package com.mg.survey.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "SURVEY_RESPONSE")
public class SurveyResponse {

    @Id
    @GeneratedValue
    @Column(name = "SURVEY_ID")
    private int surveyId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PRODUCT_ID")
    private int productId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surveyResponse")
    private List<SurveyAnswer> surveyAnswers = new ArrayList<>();

    public void addSurveyAnswer(SurveyAnswer surveyAnswer){
        surveyAnswer.setSurveyResponse(this);
        getSurveyAnswers().add(surveyAnswer);
    }

}
