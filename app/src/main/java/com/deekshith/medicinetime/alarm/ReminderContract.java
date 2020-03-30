package com.deekshith.medicinetime.alarm;

import com.deekshith.medicinetime.BasePresenter;
import com.deekshith.medicinetime.BaseView;
import com.deekshith.medicinetime.data.source.History;
import com.deekshith.medicinetime.data.source.MedicineAlarm;



public interface ReminderContract {

    interface View extends BaseView<Presenter> {

        void showMedicine(MedicineAlarm medicineAlarm);

        void showNoData();

        boolean isActive();

        void onFinish();

    }

    interface Presenter extends BasePresenter {

        void finishActivity();

        void onStart(long id);

        void loadMedicineById(long id);

        void addPillsToHistory(History history);

    }
}
