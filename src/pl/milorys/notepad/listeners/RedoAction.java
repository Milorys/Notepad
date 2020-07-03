package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class RedoAction extends AbstractAction
{
    private UndoManager manager;
    private JTextArea textArea;
    private NotepadFrame frame;

    public RedoAction(String name, Icon icon)
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
        manager.redo();
    }
}
