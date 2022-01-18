package basketballTimer.view;

import basketballTimer.constant.Common;
import basketballTimer.constant.Point;
import basketballTimer.util.PropertiesUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BasketWindow extends JFrame implements KeyListener, ActionListener {        //计分计时窗口

    private static final String TITIL = "title.name";
    private static final String HALF_COURT = "half";
    private static final String SHOT_CLOCK_VIOLATION = "24";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";

    private ScorePanel score;            //得分
    private TimePanel halfCourt;    //半场倒计时
    private JLabel titil;            //标题
    private TimePanel shotClockViolation;   //24秒

    public BasketWindow() {
        initTitil();
        initTeam();

        halfCourt = new TimePanel(HALF_COURT);
        halfCourt.setBounds(0, 610, Common.screenWidth, 310);
        add(halfCourt);

        shotClockViolation = new TimePanel(SHOT_CLOCK_VIOLATION);
        shotClockViolation.setBounds(0, 900, Common.screenWidth, 150);
        add(shotClockViolation);

        setLayout(null);            //设置为null布局，自己控制各个组件的位置
        setUndecorated(true);       //全屏
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
        validate();
        setBounds(0, 0, Common.screenWidth, Common.screenheight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initTitil() {
        titil = new JLabel(PropertiesUtil.read(TITIL));
        titil.setBounds(150, 10, Common.screenWidth, 150);
        titil.setFont(new java.awt.Font("24", Font.BOLD, 100));
        titil.setForeground(Color.blue);
        add(titil);
    }

    private void initTeam() {
        score = new ScorePanel();
        score.setBounds(0, 150, Common.screenWidth, 450);
        add(score);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        Point key = Point.matches(e.getKeyCode());
        // 计分
        if (key != null) {
            switch (key.getType()) {
                case LEFT:
                    score.leftScore.count += key.getPoint();
                    score.leftScoreLabel.setText("" + score.leftScore.count);
                    break;
                case RIGHT:
                    score.rightScore.count += key.getPoint();
                    score.rightScoreLabel.setText("" + score.rightScore.count);
                    break;
            }
        } else {    //计时
            if (e.getKeyCode() == KeyEvent.VK_F1) {    //按F1开始比赛
                halfCourt.timeRecord.firstTime = 1;
                halfCourt.timeRecord.lastTime = 0;
                halfCourt.timer.start();
            } else if (e.getKeyCode() == KeyEvent.VK_S) {   //按S暂停比赛
                halfCourt.timer.stop();
            } else if (e.getKeyCode() == KeyEvent.VK_L) {   //按L继续比赛
                halfCourt.timer.restart();
            } else if (e.getKeyCode() == KeyEvent.VK_F2) {  //按F2回一秒
                halfCourt.timeRecord.lastTime += 1;
            } else if (e.getKeyCode() == KeyEvent.VK_F3) {  //按F3回一分钟
                halfCourt.timeRecord.firstTime += 1;
            } else if (e.getKeyCode() == KeyEvent.VK_Z) {    //按Z开始24秒
                shotClockViolation.timeRecord.firstTime = 23;
                shotClockViolation.timeRecord.lastTime = 9;
                shotClockViolation.timer.start();
            } else if (e.getKeyCode() == KeyEvent.VK_X) {   //按X暂停24秒
                shotClockViolation.timer.stop();
                if (shotClockViolation.timeRecord.firstTime < 14) {
                    shotClockViolation.timeRecord.firstTime = 13;
                    shotClockViolation.timeRecord.lastTime = 9;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_C) {   //按C继续24秒
                shotClockViolation.timer.restart();
            } else if (e.getKeyCode() == KeyEvent.VK_V) {   //按V开始14秒
                shotClockViolation.timeRecord.firstTime = 13;
                shotClockViolation.timeRecord.lastTime = 9;
                shotClockViolation.timer.start();
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //按ESC退出程序
                halfCourt.timer.stop();
                shotClockViolation.timer.stop();
                this.dispose();
            }
        }


    }

    public void actionPerformed(ActionEvent z) {        //控制菜单栏
//        if (z.getSource() == titilName) {
//            titils = JOptionPane.showInputDialog(null, "请输入要修改的标题", "修改标题", JOptionPane.INFORMATION_MESSAGE);
//            if (titils != null) {
//                try {
//                    FileWriter out1 = new FileWriter(titilFile);
//                    BufferedWriter out2 = new BufferedWriter(out1);
//                    out2.write(titils);
//                    out2.flush();
//                    out2.close();
//                    out1.close();
//                    titil.setText(titils);
//                } catch (IOException e) {
//                }
//            }
//        }
//        if (z.getSource() == team1Chage) {
//            leftTeam = JOptionPane.showInputDialog(null, "请输入要修改的名字", "修改队伍1名字", JOptionPane.INFORMATION_MESSAGE);
//            if (leftTeam != null) {
//                try {
//                    FileWriter out1 = new FileWriter(team1File);
//                    BufferedWriter out2 = new BufferedWriter(out1);
//                    out2.write(leftTeam);
//                    out2.flush();
//                    out2.close();
//                    out1.close();
//                    score.team1.setText(leftTeam);
//                } catch (IOException e) {
//                }
//            }
//        }
//        if (z.getSource() == team2Chage) {
//            rightTeam = JOptionPane.showInputDialog(null, "请输入要修改的名字", "修改队伍2名字", JOptionPane.INFORMATION_MESSAGE);
//            if (rightTeam != null) {
//                try {
//                    FileWriter out1 = new FileWriter(team2File);
//                    BufferedWriter out2 = new BufferedWriter(out1);
//                    out2.write(rightTeam);
//                    out2.flush();
//                    out2.close();
//                    out1.close();
//                    score.team2.setText(rightTeam);
//                } catch (IOException e) {
//                }
//            }
//        }
    }
}
