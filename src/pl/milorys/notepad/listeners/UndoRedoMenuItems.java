package pl.milorys.notepad.listeners;

import javax.swing.*;

public class UndoRedoMenuItems
{
    private JMenuItem undoItem;
    private JMenuItem redoItem;

    public UndoRedoMenuItems(JMenuItem undoItem, JMenuItem redoItem)
    {
        this.undoItem = undoItem;
        this.redoItem = redoItem;
    }

    public JMenuItem getUndoItem()
    {
        return undoItem;
    }

    public JMenuItem getRedoItem()
    {
        return redoItem;
    }
}
