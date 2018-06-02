package Game2;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * ������������
 */
class MusicPlay2 extends Thread
{
    InputStream in = null;

    public MusicPlay2(InputStream in) {
        this.in = in;
       // System.out.println(fileName);
    }
    @Override
    public void run() {
        // TODO �Զ����ɵķ������
        super.run();
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
        // ������Ƶ������
        final AudioStream audioStream = new AudioStream(in);
        new Thread(new Runnable() {         
            @Override
            public void run() {
                // ʹ����Ƶ��������������
                AudioPlayer.player.start(audioStream);              
            }
        }).start();

        AudioPlayer.player.stop(audioStream);
    }
}