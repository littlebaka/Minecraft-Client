package net.minecraft.isom;

import java.applet.Applet;
import java.awt.BorderLayout;

public class IsomPreviewApplet extends Applet {
    private static final long serialVersionUID = 1L;

    private IsomPreview isomPreview = new IsomPreview();

    public IsomPreviewApplet() {
        this.setLayout(new BorderLayout());
        add(isomPreview, BorderLayout.CENTER);
    }

    public void start() {
        isomPreview.start();
    }

    public void stop() {
        isomPreview.stop();
    }
}
