package com.mg.survey.service.api;

import com.mg.survey.service.model.SurveyQuestionAnswer;
import com.mg.survey.service.service.SurveyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey")
public class SurveyResourceImpl implements SurveyResource {

    private SurveyService surveyService;

    public SurveyResourceImpl(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @Override
    @PostMapping("/product/{productId}/user/{userName}/submission")
    public void submitSurvey(@PathVariable("userName") String user,
                             @PathVariable("productId") int productId,
                             @RequestBody List<SurveyQuestionAnswer> surveyQuestionAnswers) {

        surveyService.submitSurvey(user, productId, surveyQuestionAnswers);
    }

}
