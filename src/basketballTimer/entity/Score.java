package basketballTimer.entity;

import basketballTimer.constant.Common;
import basketballTimer.util.PropertiesUtil;
import java.awt.Color;

/**
 * Author: Ming
 * Date: 2022.01.18:56
 * Description: <ÃèÊö>
 */
public class Score {
    public int count;
    public int containerX;
    public int containerY;
    public int containerWidth;
    public int containerHeight;
    public Color fontColor;

    public Score(String type) {
        this.containerX = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_X, type)));
        this.containerY = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_Y, type)));
        this.containerWidth = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_WIDTH, type)));
        this.containerHeight = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_HEIGHT, type)));
        this.fontColor = new Color(Integer.valueOf(PropertiesUtil.read(String.format(Common.FONTR, type))),
                Integer.valueOf(PropertiesUtil.read(String.format(Common.FONTG, type))),
                Integer.valueOf(PropertiesUtil.read(String.format(Common.FONTB, type))));
        count = 0;
    }
}
