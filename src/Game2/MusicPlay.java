package Game2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * ������������
 */
class MusicPlay extends Thread
{
    String fileName;

    public MusicPlay(String fileName) {
        this.fileName = fileName;
       // System.out.println(fileName);
    }
    @Override
    public void run() {
        // TODO �Զ����ɵķ������
        super.run();
        InputStream in = null;
        try {
            in = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
        // ������Ƶ������
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
        AudioPlayer.player.start(audioStream);
        // ֹͣ��������
        AudioPlayer.player.stop(audioStream);
    }
    
    void play() throws Exception {
        InputStream in = new FileInputStream(fileName);
        // ������Ƶ������
        final AudioStream audioStream = new AudioStream(in);
        System.out.println("thread start before "+ audioStream);
        new Thread(new Runnable() {         
            @Override
            public void run() {
                // ʹ����Ƶ��������������
                AudioPlayer.player.start(audioStream);              
            }
        }).start();

        AudioPlayer.player.stop(audioStream);
    }
    
    void playCircle() throws Exception {
        while (true)
        {
            InputStream in = new FileInputStream(fileName);
            // ������Ƶ������
            final AudioStream audioStream = new AudioStream(in);
            new Thread(new Runnable() {         
                @Override
                public void run() {
                    // ʹ����Ƶ��������������
                    AudioPlayer.player.start(audioStream);
                }
            }).start();
            Thread.sleep(93000);
        }
    }
}