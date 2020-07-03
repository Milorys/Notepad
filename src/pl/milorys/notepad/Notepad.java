package pl.milorys.notepad;

import javax.swing.*;
import java.awt.*;

public class Notepad
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                NotepadFrame frame = new NotepadFrame();
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
