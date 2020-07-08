package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundColorEventHandler implements ActionListener
{
    private NotepadFrame frame;
    private JButton backgroundColorChooser;

    public BackgroundColorEventHandler(JButton backgroundColorChooser)
    {
        this.backgroundColorChooser = backgroundColorChooser;

        frame = FrameGetter.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Color selectedColor = JColorChooser.showDialog(frame, "Wybór koloru tła", frame.getTextArea().getBackground());
        if (selectedColor != null)
        {
            frame.getTextArea().setBackground(selectedColor);
            backgroundColorChooser.setBackground(selectedColor);
        }
    }
}
