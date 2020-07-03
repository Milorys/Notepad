package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;
import pl.milorys.notepad.dialogs.ExitSaveDialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowEventHandler extends WindowAdapter
{
    private NotepadFrame frame;

    public WindowEventHandler()
    {
        frame = FrameGetter.getFrame();
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        if(frame.isEdited())
        {
            ExitSaveDialog dialog = new ExitSaveDialog(frame);
            dialog.setVisible(true);
        }
        else System.exit(0);

    }
}
