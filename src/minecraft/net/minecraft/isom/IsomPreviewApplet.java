package net.minecraft.isom;

import java.applet.Applet;
import java.awt.BorderLayout;
import net.minecraft.src.CanvasIsomPreview;

public class IsomPreviewApplet extends Applet
{
    private CanvasIsomPreview field_30001_a;

    public IsomPreviewApplet()
    {
        field_30001_a = new CanvasIsomPreview();
        setLayout(new BorderLayout());
        add(field_30001_a, "Center");
    }

    public void start()
    {
        field_30001_a.func_1272_b();
    }

    public void stop()
    {
        field_30001_a.func_1273_c();
    }
}
