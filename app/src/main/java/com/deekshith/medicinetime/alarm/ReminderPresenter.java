package com.deekshith.medicinetime.alarm;

import android.support.annotation.NonNull;

import com.deekshith.medicinetime.data.source.History;
import com.deekshith.medicinetime.data.source.MedicineAlarm;
import com.deekshith.medicinetime.data.source.MedicineDataSource;
import com.deekshith.medicinetime.data.source.MedicineRepository;


public class ReminderPresenter implements ReminderContract.Presenter {

    private final MedicineRepository mMedicineRepository;

    private final ReminderContract.View mReminderView;

    ReminderPresenter(@NonNull MedicineRepository medicineRepository, @NonNull ReminderContract.View reminderView) {
        this.mMedicineRepository = medicineRepository;
        this.mReminderView = reminderView;

        mReminderView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void finishActivity() {
        mReminderView.onFinish();
    }

    @Override
    public void onStart(long id) {
        loadMedicineById(id);
    }

    @Override
    public void loadMedicineById(long id) {
        loadMedicine(id);
    }


    private void loadMedicine(long id) {
        mMedicineRepository.getMedicineAlarmById(id, new MedicineDataSource.GetTaskCallback() {
            @Override
            public void onTaskLoaded(MedicineAlarm medicineAlarm) {
                if (!mReminderView.isActive()) {
                    return;
                }
                if (medicineAlarm == null) {
                    return;
                }
                mReminderView.showMedicine(medicineAlarm);
            }

            @Override
            public void onDataNotAvailable() {
                mReminderView.showNoData();
            }
        });
    }

    @Override
    public void addPillsToHistory(History history) {
        mMedicineRepository.saveToHistory(history);
    }
}
