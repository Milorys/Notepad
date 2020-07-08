package pl.milorys.notepad.listeners;

import pl.milorys.notepad.toolbar.TopPanel;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

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

        if(getButtons() == null)
        {
            setButtons(TopPanel.getUndoRedoButtons());
        }

        if(!manager.canUndo())
        {
            JButton undoButton = getButtons().getUndoButton();
            undoButton.setEnabled(false);
            Logger.getGlobal().info("UNDO BUTTON : Wyłączono");

            JMenuItem undoMenuItem = getItems().getUndoItem();
            undoMenuItem.setEnabled(false);
            Logger.getGlobal().info("UNDO ITEM : Wyłączono");
        }

        if (manager.canRedo())
        {
            JButton redoButton = getButtons().getRedoButton();
            redoButton.setEnabled(true);
            Logger.getGlobal().info("REDO BUTTON : Włączono");

            JMenuItem redoMenuItem = getItems().getRedoItem();
            redoMenuItem.setEnabled(true);
            Logger.getGlobal().info("REDO ITEM : Włączono");
        }

        getFrame().getLineCounter().updateLineCounter();
    }
}
