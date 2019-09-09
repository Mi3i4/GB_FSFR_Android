package com.finapp.gramfin.finapp.feature.second_screen.presenter;

import com.finapp.gramfin.finapp.feature.question_viewpager.QuestionViewpagerFragment;
import com.finapp.gramfin.finapp.feature.second_screen.model.ModelChapter;
import com.finapp.gramfin.finapp.service.FragmentRouter;

import java.util.ArrayList;
import java.util.List;

public class PresenterChapterSelection {

    private IFragmentChooseChapter ifragmentChooseChapter;
    private List<ModelChapter> listChapters = new ArrayList<>();


    public PresenterChapterSelection(IFragmentChooseChapter ifragmentChooseChapter) {
        this.ifragmentChooseChapter = ifragmentChooseChapter;
        setModelChapters();
    }

    private void setModelChapters() {

        listChapters.add(new ModelChapter("Рынок ценных бумаг",
                3, 2, 1));
        listChapters.add(new ModelChapter("Участники рынка ценных бумаг." +
                " Инфраструктурные организации ",
                3, 2, 1));
        listChapters.add(new ModelChapter("Эмиссия ценных бумаг. Обращение финансовых инструментов ",
                3, 2, 1));
        listChapters.add(new ModelChapter("Институты коллективного инвестирования ",
                3, 2, 1));
        listChapters.add(new ModelChapter("Государственные ценные бумаги. Государственный долг ",
                3, 2, 1));
        listChapters.add(new ModelChapter("Гражданско-правовые основы ведения предпринимательской деятельности ",
                3, 2, 1));
        listChapters.add(new ModelChapter("Корпоративное право ",
                3, 2, 1));
        listChapters.add(new ModelChapter("Регулирование финансового рынка и надзор на финансовом рынке." +
                " Защита прав и законных интересов инвесторов на финансовом рынке ",
                3, 2, 1));
        listChapters.add(new ModelChapter("Административные правонарушения и уголовные преступления на финансовом рынке ",
                3, 2, 1));
        listChapters.add(new ModelChapter("Финансовая математика и статистика",
                3, 2, 1));
        listChapters.add(new ModelChapter("Основы бухгалтерского учета и финансовой отчетности на финансовом рынке",
                3, 2, 1));
        listChapters.add(new ModelChapter("Налогообложение на финансовом рынке",
                3, 2, 1));
        listChapters.add(new ModelChapter("Мировой финансовый рынок",
                3, 2, 1));

        ifragmentChooseChapter.setChapters(listChapters);

    }

    public void callBackIdModelChapters(int id) {
        System.out.println("Номер в листе = " + id);

        switch (id) {
            case 0:
                FragmentRouter.getInstance().placeFragment(QuestionViewpagerFragment.class, null);
                break;
            default:
                FragmentRouter.getInstance().notImplementedToast();
        }
    }


}
