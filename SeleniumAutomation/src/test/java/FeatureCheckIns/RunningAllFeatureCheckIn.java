package FeatureCheckIns;

import FeatureBoard.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SC01_MenuCheckIn.class,
        SC02_ButtonMenuHome.class,
        SC03_ButtonMenuPaketSoalC.class,
        SC04_CreateCheckIn.class,
        SC05_Question.class,
        SC06_CommentQuestion.class,
})
public class RunningAllFeatureCheckIn {
}
