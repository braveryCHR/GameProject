package Game2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class WelcomeFrame
{
    public static JFrame welcomeFrame = new JFrame();
    public static PicturePanel picturePanel = new PicturePanel();

    // ��ʼ������
    public static void initFrame() {
        // ����JPanel��ӱ���ͼƬ
        welcomeFrame.setSize(560, 1000);
        welcomeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        welcomeFrame.setTitle("����");
        welcomeFrame.setVisible(true);
        welcomeFrame.add(picturePanel);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setSize(560, 1000);
        picturePanel.setVisible(true);
    }

    static void bgmusicStart() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    MusicPlay2 backgroundMusic = new MusicPlay2(
                            WelcomeFrame.class.getResourceAsStream("/backgroundMusic2.wav"));
                    try {
                        backgroundMusic.play();
                    } catch (Exception e) {
                        // TODO �Զ����ɵ� catch ��
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(93000);
                    } catch (InterruptedException e) {
                        // TODO �Զ����ɵ� catch ��
                        e.printStackTrace();
                    }
                }
                // ʹ����Ƶ��������������
            }
        }).start();
        return;
    }

    public static void main(String[] args) throws Exception {
        initFrame();
        bgmusicStart();
        GameStart.gameMode = 0;
        PicturePanel.easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                GameStart.gameMode = 0;
                GameStart.ballSpeed = 2.0;
                PicturePanel.gameModeLabel
                        .setText("<html><p><font size=\"5\">��Ŀǰѡ��������ģʽ<br>���������~" + "</font></p></html>");
            }
        });
        PicturePanel.middleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                GameStart.gameMode = 1;
                GameStart.ballSpeed = 0.9;
                PicturePanel.gameModeLabel
                        .setText("<html><p><font size=\"5\">��Ŀǰѡ���˽���ģʽ<br>���������~" + "</font></p></html>");
            }
        });
        PicturePanel.hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                GameStart.gameMode = 2;
                GameStart.ballSpeed = 0.9;
                PicturePanel.gameModeLabel
                        .setText("<html><p><font size=\"5\">��Ŀǰѡ���˵���ģʽ<br>���ð��~" + "</font></p></html>");
            }
        });
        PicturePanel.startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    System.out.println("12321");
                    GameStart.mainFrame.setVisible(true);
                    welcomeFrame.setVisible(false);
                } catch (Exception e) {
                    // TODO �Զ����ɵ� catch ��
                    e.printStackTrace();
                }
            }
        });
        GameStart.gameInit();
        GameStart.gameStart();
    }
}

class PicturePanel extends JPanel
{
    ImageIcon icon = new ImageIcon(this.getClass().getResource("/welcomeImage.jpg"));
    Image img = icon.getImage();
    public static JButton easyButton = new JButton("������\n����ģʽ");
    public static JButton middleButton = new JButton("������\n����ģʽ");
    public static JButton hardButton = new JButton("������\n����ģʽ");
    public static JButton startButton = new JButton("��ʼ��Ϸ");
    public static JLabel gameModeLabel = new JLabel(
            "<html><p><font size=\"5\">��Ŀǰѡ��������ģʽ<br>���������~" + "</font></p></html>");

    @Override
    protected void paintComponent(Graphics g) {
        setLayout(null);
        // TODO �Զ����ɵķ������
        super.paintComponent(g);
        setSize(560, 960);
        g.drawImage(img, 0, 0, 560, 960, icon.getImageObserver());
        add(gameModeLabel);
        gameModeLabel.setSize(200, 100);
        gameModeLabel.setVisible(true);
        gameModeLabel.setLocation(200, 550);
        gameModeLabel.setForeground(Color.red);
        // �������ģʽ����һ������ģʽ
        add(easyButton);
        easyButton.setSize(180, 50);
        easyButton.setVisible(true);
        easyButton.setLocation(180, 650);
        // ����ģʽ
        add(middleButton);
        middleButton.setSize(180, 50);
        middleButton.setVisible(true);
        middleButton.setLocation(80, 720);
        // ��ų�ģʽ
        add(hardButton);
        hardButton.setSize(180, 50);
        hardButton.setVisible(true);
        hardButton.setLocation(290, 720);
        add(startButton);
        startButton.setSize(180, 50);
        startButton.setVisible(true);
        startButton.setLocation(180, 790);
    }
}
