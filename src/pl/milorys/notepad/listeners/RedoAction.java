package pl.milorys.notepad.listeners;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class RedoAction extends UndoRedoAction
{
    public RedoAction(String name, Icon icon, UndoRedoButtons buttons, UndoRedoMenuItems items)
    {
        super(name, icon, buttons, items);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        UndoManager manager = getManager();
        manager.redo();

        if(getButtons() != null)
        {
            if (!manager.canRedo())
            {
                JButton redoButton = getButtons().getRedoButton();
                redoButton.setEnabled(false);
            }

            if (manager.canUndo())
            {
                JButton undoButton = getButtons().getUndoButton();
                undoButton.setEnabled(true);
            }
        }

        if (getItems() != null)
        {
            if (!manager.canRedo())
            {
                JMenuItem redoItem = getItems().getRedoItem();
                redoItem.setEnabled(false);
            }

            if(manager.canUndo())
            {
                JMenuItem undoItem = getItems().getUndoItem();
                undoItem.setEnabled(true);
            }
        }
    }
}
