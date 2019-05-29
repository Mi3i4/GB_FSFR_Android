package com.finapp.gramfin.finapp.feature.question_viewpager.presenter;

import com.finapp.gramfin.finapp.api.question_model.DataRecordRestModel;
import com.finapp.gramfin.finapp.api.question_model.data_reqord.AnswerRecordRestModel;
import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;
import com.finapp.gramfin.finapp.service.QuestionLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.Nullable;

public class PresenterQuestionViewpager {
    private static final int QUESTIONS_AMOUNT = 221;
    private static final int QUESTIONS_NEEDED = 10;

    private int chapter_id = 1; // TODO Сейчас доступна только первая тема, для получения списка вопросов будет другое API
    private IQuestionViewpager iQuestionViewpager;
    private List<ModelQuestion> questionList = new ArrayList<>();
    private final Random random = new Random();

    public PresenterQuestionViewpager(IQuestionViewpager iQuestionViewpager) {
        this.iQuestionViewpager = iQuestionViewpager;
        addModelQuestions();
    }

    public String calcRightAnswersAmount() {
        int result = 0;

        for (ModelQuestion model:questionList) { if (model.getHaveRightChoice()) result ++; }

        return String.valueOf(new StringBuilder().append(result).append(" / ").append(QUESTIONS_NEEDED));
    }

    private void addModelQuestions() {
        QuestionLoader.getInstance()
                .getDataRecord(chapter_id, random.nextInt(QUESTIONS_AMOUNT), new QuestionLoader.OnRequestListener() {
                    @Override
                    public void onComplete(@Nullable DataRecordRestModel result, String error) {
                        if (result != null) {
                            ModelQuestion model = new ModelQuestion(chapter_id, result.id, result.content, result.answers);
                            model.setChapterName(result.chapters.name);
                            if (result.topics != null) { model.setTopicName(result.topics.name); }

                            questionList.add(model);

                        } else if (!error.equals(QuestionLoader.QUESTION_NOT_FOUND)) {
                            ModelQuestion model = new ModelQuestion(chapter_id, -1, error, new ArrayList<AnswerRecordRestModel>());
                            questionList.add(model);
                        }

                        if (questionList.size() == QUESTIONS_NEEDED) {
                            QuestionLoader.getInstance().clearCash();
                            iQuestionViewpager.setQuestion(questionList);
                        }
                        else addModelQuestions();
                    }
                });
    }

    private void setAnswer(ModelQuestion modelQuestion, int choice) {
        modelQuestion.setUserChoice(choice);
        iQuestionViewpager.gotoNextPage();
    }

    public void callBack(int id, int choice) {
        ModelQuestion modelQuestion = questionList.get(id);
        setAnswer(modelQuestion, choice);
    }
}
