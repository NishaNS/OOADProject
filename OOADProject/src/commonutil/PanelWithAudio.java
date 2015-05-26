package commonutil;

import javax.swing.*;

/**
 * Created by MadVish on 5/25/15.
 */
public class PanelWithAudio extends JPanel {

    private final Audio audio;

    public PanelWithAudio(Audio audio) {
        super();
        this.audio = audio;
    }

    public void playAudio() {
        audio.playAudio();
    }

}
