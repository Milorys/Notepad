package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public abstract class UndoRedoAction extends AbstractAction
{
    private UndoRedoButtons buttons;
    private UndoRedoMenuItems items;
    private NotepadFrame frame;
    private JTextArea textArea;
    private UndoManager manager;

    public UndoRedoAction(String name, Icon icon, UndoRedoButtons buttons, UndoRedoMenuItems items)
    {
        this.buttons = buttons;
        this.items = items;

        frame = FrameGetter.getFrame();
        textArea = frame.getTextArea();
        manager = frame.getUndoManager();

        putValue(Action.NAME, name);
        putValue(Action.SMALL_ICON, icon);
    }

    public abstract void actionPerformed(ActionEvent e);

    public UndoRedoButtons getButtons()
    {
        return buttons;
    }

    public UndoRedoMenuItems getItems()
    {
        return items;
    }

    public NotepadFrame getFrame()
    {
        return frame;
    }

    public JTextArea getTextArea()
    {
        return textArea;
    }

    public UndoManager getManager()
    {
        return manager;
    }

    public void setButtons(UndoRedoButtons buttons)
    {
        this.buttons = buttons;
    }
}
