package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.Notepad;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewContentEventHandler implements ActionListener
{
    private NotepadFrame frame;

    public NewContentEventHandler()
    {
        this.frame = FrameGetter.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        frame.setTitle(frame.getDefaultTitle());
        frame.getTextArea().setText(null);
    }
}
