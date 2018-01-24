package isep.stageoutilsconteneur;

import android.app.Application;
import android.content.Context;

import isep.stageoutilsconteneur.helper.LocaleHelper;

/**
 * Created by linfengwang on 24/01/2018.
 */

public class MainApplication extends Application{
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));

    }
}
