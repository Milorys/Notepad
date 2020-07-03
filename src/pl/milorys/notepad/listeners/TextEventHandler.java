package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import java.awt.*;
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
            if(frame.getTitle() != frame.getDefaultTitle())
            {
                frame.setTitle(frame.getTitle() + "*");
            }
            else
            {
                frame.setTitle(frame.getDefaultTitle() + "*");
            }
            frame.setEdited(true);
        }
    }
}
