package basketballTimer.view;

import basketballTimer.constant.Common;
import basketballTimer.entity.TimeRecord;
import basketballTimer.service.TimeRecordService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimePanel extends JPanel implements ActionListener {    //记录半场时间

    private static TimeRecordService timeRecordService;
    public JLabel showTime;            //显示时间
    public Timer timer;               //控制时间
    public TimeRecord timeRecord;

    public TimePanel(String type) {
        setLayout(null);                    //设置为null布局，自己控制各个组件的位置
        timeRecord = new TimeRecord(type);

        showTime = new JLabel(timeRecord.initTime);
        showTime.setForeground(timeRecord.fontColor);        //设置字体颜色
        showTime.setBounds(timeRecord.containerX, timeRecord.containerY, Common.screenWidth, timeRecord.containerHeight);
        showTime.setFont(new java.awt.Font("showTime", Font.PLAIN, timeRecord.fontSize));
        add(showTime);

        timer = new Timer(timeRecord.containerFrequency, this);            //每1秒发生一次事件
        timeRecordService = new TimeRecordService();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {            //每过1秒产生一个新事件
            timeRecordService.reduceTime(timeRecord, timer);
            showTime.setText(
                    timeRecord.firstTime + timeRecord.containerSplit.substring(timeRecord.containerSplit.length() - 1)
                            + timeRecord.lastTime);
        }
    }
}
