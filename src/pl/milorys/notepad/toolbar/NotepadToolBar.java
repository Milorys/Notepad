package pl.milorys.notepad.toolbar;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import java.awt.*;

public class NotepadToolBar extends JToolBar
{
    private NotepadFrame frame;

    public NotepadToolBar()
    {
        frame = FrameGetter.getFrame();

        setLayout(new BorderLayout());

        // Panele
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());

        add(northPanel, BorderLayout.NORTH);
        northPanel.add(new TopPanel(this), BorderLayout.WEST);
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(new BottomPanel(this), BorderLayout.WEST);
    }
}
