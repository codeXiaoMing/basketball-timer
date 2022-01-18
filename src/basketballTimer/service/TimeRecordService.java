package basketballTimer.service;

import basketballTimer.entity.TimeRecord;
import basketballTimer.util.SoundUtil;
import javax.swing.Timer;

/**
 * Author: Ming
 * Date: 2022.01.14:33
 * Description: <描述>
 */
public class TimeRecordService {
    private static final Integer END_TIME = 0;

    /**
     * 减少时间，半场、24秒通用
     * @param timeRecord
     * @param timer
     */
    public void reduceTime(TimeRecord timeRecord, Timer timer) {
        timeRecord.lastTime--;
        if (timeRecord.lastTime == END_TIME && timeRecord.firstTime == END_TIME) {        //时间到就结束
            try {
                SoundUtil.play();
                timer.stop();
            } catch (Exception a) {
                a.printStackTrace();
            }
        } else if (timeRecord.lastTime < END_TIME && timeRecord.firstTime > END_TIME) {
            timeRecord.lastTime = timeRecord.lastTimeStart;
            timeRecord.firstTime--;
        }
    }
}
