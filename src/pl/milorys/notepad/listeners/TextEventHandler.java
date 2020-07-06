package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;
import pl.milorys.notepad.menus.EditMenu;
import pl.milorys.notepad.toolbar.TopPanel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextEventHandler extends KeyAdapter
{
    private NotepadFrame frame;

    public TextEventHandler()
    {
        frame = FrameGetter.getFrame();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        int index = frame.getTitle().length();
        String titleLastChar = frame.getTitle().substring(index - 1, index);
        if (!titleLastChar.equals("*"))
        {
            if(frame.getTitle().equals(frame.getDefaultTitle()))
            {
                frame.setTitle(frame.getTitle() + "*");
            }
            else
            {
                frame.setTitle(frame.getDefaultTitle() + "*");
            }
            frame.setEdited(true);
        }

        if (frame.getUndoManager().canUndo())
        {
            JButton undoButton = TopPanel.getUndoRedoButtons().getUndoButton();
            JMenuItem undoMenuItem = EditMenu.getUndoRedoMenuItems().getUndoItem();
            undoButton.setEnabled(true);
            undoMenuItem.setEnabled(true);
        }

        if (frame.getUndoManager().canRedo())
        {
            JButton redoButton = TopPanel.getUndoRedoButtons().getRedoButton();
            JMenuItem redoMenuItem = EditMenu.getUndoRedoMenuItems().getRedoItem();
            redoButton.setEnabled(true);
            redoMenuItem.setEnabled(true);
        }
    }
}
