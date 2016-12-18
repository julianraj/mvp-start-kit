package com.julianraj.mvpstartkit.ui.view;

import com.julianraj.mvpstartkit.models.TestModel;

/**
 * Created by julian on 12/17/16.
 */

public interface TestView extends LoadDataView {
    void renderTestModel(TestModel testModel);
}
