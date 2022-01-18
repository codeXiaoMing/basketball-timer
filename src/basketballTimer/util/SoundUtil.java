package basketballTimer.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

/**
 * Author: Ming
 * Date: 2022.01.14:14
 * Description: <ÃèÊö>
 */
public class SoundUtil {
    private static final String PROMPTSOUND = "promptSound";

    private static AudioClip clip;

    static {
        System.out.println("static");
        try {
            clip = Applet.newAudioClip(new File(PropertiesUtil.read(PROMPTSOUND)).toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void play() {
        clip.play();
        System.out.println("play");
    }
}
