package basketballTimer.view;

import basketballTimer.entity.Score;
import basketballTimer.entity.Team;
import basketballTimer.util.PropertiesUtil;
import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {        //计分
    private static final String TEAM_FONT_SIZE = "team.font.size";
    private static final String SCORE_FONT_SIZE = "score.font.size";
    private static final String LEFT_TEAM = "leftTeam";
    private static final String RIGHT_TEAM = "rightTeam";
    private static final String LEFT_SCORE = "leftScore";
    private static final String RIGHT_SCORE = "rightScore";

    public JLabel leftTeamLabel;
    public JLabel rightTeamLabel;
    public JLabel leftScoreLabel;
    public JLabel rightScoreLabel;
    public Team leftTeam;
    public Team rightTeam;
    public Score leftScore;
    public Score rightScore;

    public ScorePanel() {
        setLayout(null);            //设置为null布局，自己控制各个组件的位置

        initTeam();
        initScore();
    }

    private void initTeam() {
        Integer teamFontSize = Integer.valueOf(PropertiesUtil.read(TEAM_FONT_SIZE));

        leftTeam = new Team(LEFT_TEAM);
        leftTeamLabel = new JLabel(leftTeam.name);
        leftTeamLabel.setBounds(leftTeam.containerX, leftTeam.containerY,
                leftTeam.containerWidth, leftTeam.containerHeight);
        leftTeamLabel.setFont(new Font("leftTeamLabel", Font.BOLD, teamFontSize));
        leftTeamLabel.setForeground(leftTeam.fontColor);
        add(leftTeamLabel);

        rightTeam = new Team(RIGHT_TEAM);
        rightTeamLabel = new JLabel(rightTeam.name);
        rightTeamLabel.setBounds(rightTeam.containerX, rightTeam.containerY,
                rightTeam.containerWidth, rightTeam.containerHeight);
        rightTeamLabel.setFont(new Font("rightTeamLabel", Font.BOLD, teamFontSize));
        rightTeamLabel.setForeground(rightTeam.fontColor);
        add(rightTeamLabel);
    }

    private void initScore() {
        Integer scoreFontSize = Integer.valueOf(PropertiesUtil.read(SCORE_FONT_SIZE));

        leftScore = new Score(LEFT_SCORE);
        leftScoreLabel = new JLabel("0");
        leftScoreLabel.setBounds(leftScore.containerX, leftScore.containerY,
                leftScore.containerWidth, leftScore.containerHeight);
        leftScoreLabel.setFont(new java.awt.Font("leftScore", Font.PLAIN, scoreFontSize));
        leftScoreLabel.setForeground(leftScore.fontColor);
        add(leftScoreLabel);

        rightScore = new Score(RIGHT_SCORE);
        rightScoreLabel = new JLabel("0");
        rightScoreLabel.setBounds(rightScore.containerX, rightScore.containerY,
                rightScore.containerWidth, rightScore.containerHeight);
        rightScoreLabel.setForeground(rightScore.fontColor);
        rightScoreLabel.setFont(new java.awt.Font("rightScore", Font.PLAIN, scoreFontSize));
        add(rightScoreLabel);
    }
}