package com.deekshith.medicinetime;

import android.content.Context;
import android.support.annotation.NonNull;


import com.deekshith.medicinetime.data.source.MedicineRepository;
import com.deekshith.medicinetime.data.source.local.MedicinesLocalDataSource;


/**
 * Created by deekshith on 13/05/17.
 */

public class Injection {

    public static MedicineRepository provideMedicineRepository(@NonNull Context context) {
        return MedicineRepository.getInstance(MedicinesLocalDataSource.getInstance(context));
    }
}