package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoAction extends AbstractAction
{
    private UndoManager manager;
    private JTextArea textArea;
    private NotepadFrame frame;

    public UndoAction(String name, Icon icon)
    {
        frame = FrameGetter.getFrame();
        textArea = frame.getTextArea();
        manager = frame.getUndoManager();

        putValue(Action.NAME, name);
        putValue(Action.SMALL_ICON, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        manager.undo();
    }
}
