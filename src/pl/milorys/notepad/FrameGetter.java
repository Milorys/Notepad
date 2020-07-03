package pl.milorys.notepad;

public class FrameGetter
{
    private static NotepadFrame frame;

    public FrameGetter(NotepadFrame aFrame)
    {
        frame = aFrame;
    }

    public static NotepadFrame getFrame()
    {
        return frame;
    }
}
