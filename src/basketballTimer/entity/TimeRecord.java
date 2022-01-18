package basketballTimer.entity;

import basketballTimer.constant.Common;
import basketballTimer.util.PropertiesUtil;
import java.awt.Color;

/**
 * Author: Ming
 * Date: 2022.01.14:35
 * Description: <ÃèÊö>
 */
public class TimeRecord {
    public int firstTime;
    public int lastTime;
    public int lastTimeStart;
    public int containerX;
    public int containerY;
    public int containerHeight;
    public int containerFrequency;
    public int fontSize;
    public String initTime;
    public String containerSplit;
    public Color fontColor;

    public TimeRecord(String type) {
        this.containerX = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_X, type)));
        this.containerY = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_Y, type)));
        this.containerHeight = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_HEIGHT, type)));
        this.containerFrequency = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_FREQUENCY, type)));
        this.containerSplit = PropertiesUtil.read(String.format(Common.CONTAINER_SPLIT, type));
        this.lastTimeStart = Integer.valueOf(PropertiesUtil.read(String.format(Common.LASTTIME_START, type)));
        this.fontSize = Integer.valueOf(PropertiesUtil.read(String.format(Common.FONT_SIZE, type)));

        this.initTime = PropertiesUtil.read(String.format(Common.INIT_TIME, type));
        System.out.println(initTime);
        String[] times = initTime.split(this.containerSplit);
        System.out.println(times.length);
        this.firstTime = Integer.valueOf(times[0]);
        this.lastTime = Integer.valueOf(times[1]);

        this.fontColor = new Color(Integer.valueOf(PropertiesUtil.read(String.format(Common.FONTR, type))),
                Integer.valueOf(PropertiesUtil.read(String.format(Common.FONTG, type))),
                Integer.valueOf(PropertiesUtil.read(String.format(Common.FONTB, type))));
    }
}
