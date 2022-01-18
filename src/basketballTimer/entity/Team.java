package basketballTimer.entity;

import basketballTimer.constant.Common;
import basketballTimer.util.PropertiesUtil;
import java.awt.Color;

/**
 * Author: Ming
 * Date: 2022.01.17:40
 * Description: <ÃèÊö>
 */
public class Team {
    public int containerX;
    public int containerY;
    public int containerWidth;
    public int containerHeight;
    public String name;
    public Color fontColor;

    public Team(String type) {
        this.containerX = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_X, type)));
        this.containerY = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_Y, type)));
        this.containerWidth = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_WIDTH, type)));
        this.containerHeight = Integer.valueOf(PropertiesUtil.read(String.format(Common.CONTAINER_HEIGHT, type)));
        this.name = PropertiesUtil.read(String.format(Common.NAME, type));
        this.fontColor = new Color(Integer.valueOf(PropertiesUtil.read(String.format(Common.FONTR, type))),
                Integer.valueOf(PropertiesUtil.read(String.format(Common.FONTG, type))),
                Integer.valueOf(PropertiesUtil.read(String.format(Common.FONTB, type))));
    }
}
