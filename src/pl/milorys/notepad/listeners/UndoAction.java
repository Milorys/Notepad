package pl.milorys.notepad.listeners;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class UndoAction extends UndoRedoAction
{
    public UndoAction(String name, Icon icon, UndoRedoButtons buttons, UndoRedoMenuItems items)
    {
        super(name, icon, buttons, items);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        UndoManager manager = getManager();
        manager.undo();

        if(getButtons() != null)
        {
            if(!manager.canUndo())
            {
                JButton undoButton = getButtons().getUndoButton();
                undoButton.setEnabled(false);
            }

            if (manager.canRedo())
            {
                JButton redoButton = getButtons().getRedoButton();
                redoButton.setEnabled(true);
            }
        }

        if(getItems() != null)
        {
            if(!manager.canUndo())
            {
                JMenuItem undoMenuItem = getItems().getUndoItem();
                undoMenuItem.setEnabled(false);
            }

            if(manager.canRedo())
            {
                JMenuItem redoMenuItem = getItems().getRedoItem();
                redoMenuItem.setEnabled(true);
            }
        }
    }
}
