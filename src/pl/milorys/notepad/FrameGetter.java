package pl.milorys.notepad;

import pl.milorys.notepad.toolbar.BottomPanel;
import pl.milorys.notepad.toolbar.TopPanel;

public class FrameGetter
{
    private static NotepadFrame frame;
    private static BottomPanel bottomPanel;
    private static TopPanel topPanel;

    public FrameGetter(NotepadFrame aFrame)
    {
        frame = aFrame;
    }

    public static NotepadFrame getFrame()
    {
        return frame;
    }

    public static void setBottomPanel(BottomPanel aBottomPanel)
    {
        bottomPanel = aBottomPanel;
    }

    public static BottomPanel getBottomPanel()
    {
        return bottomPanel;
    }

    public static void setTopPanel(TopPanel aTopPanel)
    {
        topPanel = aTopPanel;
    }

    public static TopPanel getTopPanel()
    {
        return topPanel;
    }
}

