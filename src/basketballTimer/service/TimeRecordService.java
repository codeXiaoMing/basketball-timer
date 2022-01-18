package basketballTimer.service;

import basketballTimer.entity.TimeRecord;
import basketballTimer.util.SoundUtil;
import javax.swing.Timer;

/**
 * Author: Ming
 * Date: 2022.01.14:33
 * Description: <����>
 */
public class TimeRecordService {
    private static final Integer END_TIME = 0;

    /**
     * ����ʱ�䣬�볡��24��ͨ��
     * @param timeRecord
     * @param timer
     */
    public void reduceTime(TimeRecord timeRecord, Timer timer) {
        timeRecord.lastTime--;
        if (timeRecord.lastTime == END_TIME && timeRecord.firstTime == END_TIME) {        //ʱ�䵽�ͽ���
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
