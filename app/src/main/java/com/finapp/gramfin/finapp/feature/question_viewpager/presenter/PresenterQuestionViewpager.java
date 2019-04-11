package com.finapp.gramfin.finapp.feature.question_viewpager.presenter;

import android.view.View;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.question_model.DataRecordRestModel;
import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;
import com.finapp.gramfin.finapp.frag_router.FragmentRouter;
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

    private void addModelQuestions() {
        QuestionLoader.getInstance()
                .getDataRecord(chapter_id, random.nextInt(QUESTIONS_AMOUNT), new QuestionLoader.OnRequestListener() {
                    @Override
                    public void onComplete(@Nullable DataRecordRestModel result) {
                        if (result != null) {
                            ModelQuestion model = new ModelQuestion(chapter_id, result.id, result.content, result.answers);
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

    public void callBack(View v) {

        switch (v.getId()) {
            default: FragmentRouter.getInstance().notImplementedToast();
        }
    }
}
