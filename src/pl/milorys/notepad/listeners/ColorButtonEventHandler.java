package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButtonEventHandler implements ActionListener
{
    private NotepadFrame frame;
    private JButton colorChooserButton;
    private Color currentColor;

    public ColorButtonEventHandler(JButton colorChooserButton)
    {
        frame = FrameGetter.getFrame();

        this.currentColor = frame.getTextArea().getForeground();
        this.colorChooserButton = colorChooserButton;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Color selectedColor = JColorChooser.showDialog(frame, "Wybór koloru", frame.getTextArea().getForeground());
        if (selectedColor != null)
        {
            currentColor = selectedColor;
            frame.getTextArea().setForeground(selectedColor);
            colorChooserButton.setBackground(selectedColor);
        }
    }
}
