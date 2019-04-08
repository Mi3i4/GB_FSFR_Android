package com.finapp.gramfin.finapp.feature.question_viewpager.presenter;

import android.view.View;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.api.question_model.DataRecordRestModel;
import com.finapp.gramfin.finapp.api.question_model.data_reqord.AnswerRecordRestModel;
import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;
import com.finapp.gramfin.finapp.frag_router.FragmentRouter;
import com.finapp.gramfin.finapp.service.QuestionLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

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
                    public void onComplete(@Nullable DataRecordRestModel result, String error) {
                        if (result != null) {
                            ModelQuestion model = new ModelQuestion(chapter_id, result.id, result.content, result.answers);
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

    private void setAnswer(View view, AnswerRecordRestModel answer) {
        if (answer.is_correct == 1) view.setBackgroundResource(R.color.colorLightGreen);
        else view.setBackgroundResource(R.color.colorLightRed);

        iQuestionViewpager.gotoNextPage();
    }

    public void callBack(View view, int id) {
        ArrayList<AnswerRecordRestModel> answers = questionList.get(id).getAnswers();

        switch (view.getId()) {
            case R.id.answer_choice_1: setAnswer(view, answers.get(0)); break;
            case R.id.answer_choice_2: setAnswer(view, answers.get(1)); break;
            case R.id.answer_choice_3: setAnswer(view, answers.get(2)); break;
            case R.id.answer_choice_4: setAnswer(view, answers.get(3)); break;
            default: FragmentRouter.getInstance().notImplementedToast();
        }
    }
}
