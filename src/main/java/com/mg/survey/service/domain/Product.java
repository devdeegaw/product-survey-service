package com.mg.survey.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        question.setProduct(this);
        getQuestions().add(question);
    }

}
