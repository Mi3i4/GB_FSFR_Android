package com.finapp.gramfin.finapp.feature.statistics.wrong_answers;

import androidx.lifecycle.ViewModel;

import com.finapp.gramfin.finapp.R;
import com.finapp.gramfin.finapp.feature.statistics.wrong_answers.model.WrongAnswersModel;
import com.finapp.gramfin.finapp.service.FragmentRouter;

import java.util.ArrayList;
import java.util.List;

public class WrongAnswersViewModel extends ViewModel {

    private List<WrongAnswersModel> wrongAnswersModelArrayList = new ArrayList<>();

    public void setupModel() {
        if (wrongAnswersModelArrayList.size() > 0) { return; }

        //TODO implement list of wrong answers
        for (int i = 0; i < 4; i++) {
            wrongAnswersModelArrayList.add(new WrongAnswersModel(
                    FragmentRouter.getInstance().getString(R.string.chapter_holder),
                    FragmentRouter.getInstance().getString(R.string.question_holder),
                    v ->  FragmentRouter.getInstance().notImplementedToast()
            ));
        }
    }

    public List<WrongAnswersModel> getWrongAnswersModelArrayList() { return wrongAnswersModelArrayList; }
}
