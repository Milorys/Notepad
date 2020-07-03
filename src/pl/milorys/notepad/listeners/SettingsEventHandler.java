package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.dialogs.SettingsDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsEventHandler implements ActionListener
{
    pl.milorys.notepad.NotepadFrame frame;

    public SettingsEventHandler()
    {
        frame = FrameGetter.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        SettingsDialog dialog = new SettingsDialog(frame);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
