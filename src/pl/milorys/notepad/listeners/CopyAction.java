package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CopyAction extends AbstractAction
{
    private NotepadFrame frame;
    private JTextArea textArea;

    public CopyAction(String name, Icon icon)
    {
        frame = FrameGetter.getFrame();
        textArea = frame.getTextArea();

        putValue(Action.NAME, name);
        putValue(Action.SMALL_ICON, icon);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        textArea.copy();
    }
}
