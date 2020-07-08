package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;
import pl.milorys.notepad.menus.EditMenu;
import pl.milorys.notepad.toolbar.TopPanel;

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
        NotepadFrame.fileChooser = null;
        frame.getUndoManager().discardAllEdits();
        frame.setEdited(false);
        frame.getLineCounter().updateLineCounter();

        JButton undoButton = TopPanel.getUndoRedoButtons().getUndoButton();
        JMenuItem undoItem = EditMenu.getUndoRedoMenuItems().getUndoItem();
        undoButton.setEnabled(false);
        undoItem.setEnabled(false);
        JButton redoButton = TopPanel.getUndoRedoButtons().getRedoButton();
        JMenuItem redoItem = EditMenu.getUndoRedoMenuItems().getRedoItem();
        redoButton.setEnabled(false);
        redoItem.setEnabled(false);
    }
}
