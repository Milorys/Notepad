package pl.milorys.notepad.listeners;

import javax.swing.*;

public class UndoRedoButtons
{
    private JButton undoButton;
    private JButton redoButton;

    public UndoRedoButtons(JButton undoButton, JButton redoButton)
    {
        this.redoButton = redoButton;
        this.undoButton = undoButton;
    }

    public JButton getUndoButton()
    {
        return undoButton;
    }

    public JButton getRedoButton()
    {
        return redoButton;
    }
}
