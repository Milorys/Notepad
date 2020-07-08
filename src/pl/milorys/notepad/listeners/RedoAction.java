package pl.milorys.notepad.listeners;

import pl.milorys.notepad.toolbar.TopPanel;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

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

        if (getButtons() == null)
        {
            setButtons(TopPanel.getUndoRedoButtons());
        }

        if (!manager.canRedo())
        {
            JButton redoButton = getButtons().getRedoButton();
            redoButton.setEnabled(false);
            Logger.getGlobal().info("REDO BUTTON : Wyłączono");

            JMenuItem redoItem = getItems().getRedoItem();
            redoItem.setEnabled(false);
            Logger.getGlobal().info("REDO ITEM : Wyłączono");
        }

        if (manager.canUndo())
        {
            JButton undoButton = getButtons().getUndoButton();
            undoButton.setEnabled(true);
            Logger.getGlobal().info("UNDO BUTTON : Włączono");

            JMenuItem undoItem = getItems().getUndoItem();
            undoItem.setEnabled(true);
            Logger.getGlobal().info("REDO ITEM : Włączono");
        }

        getFrame().getLineCounter().updateLineCounter();
    }
}
