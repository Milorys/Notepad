package pl.milorys.notepad.listeners;

import pl.milorys.notepad.CheckButton;
import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;
import pl.milorys.notepad.toolbar.BottomPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontEventHandler implements ActionListener
{
    private NotepadFrame frame;
    private BottomPanel bottomPanel;

    private JComboBox<Integer> fontSize;
    private JComboBox<String> fonts;

    private CheckButton bold;
    private CheckButton italic;

    public FontEventHandler(BottomPanel bottomPanel)
    {
        this.bottomPanel = bottomPanel;

        frame = FrameGetter.getFrame();

        fontSize = bottomPanel.getFontSize();
        fonts = bottomPanel.getFonts();

        bold = bottomPanel.getBold();
        italic = bottomPanel.getItalic();

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int mode = 0;

        if (e.getSource() instanceof CheckButton)
        {
            CheckButton cb = (CheckButton) e.getSource();
            if(cb.getAttribute().equals("bold"))
            {
                if(cb.isClicked())
                {
                    cb.setIcon(frame.prepareIcon("icon_bold_not_selected.png", 28));
                }
                else
                {
                    cb.setIcon(frame.prepareIcon("icon_bold_selected.png", 28));
                }

                cb.setClicked(!cb.isClicked());
            }
            if(cb.getAttribute().equals("italic"))
            {
                if(cb.isClicked())
                {
                    cb.setIcon(frame.prepareIcon("icon_italic_not_selected.png", 28));
                }
                else
                {
                    cb.setIcon(frame.prepareIcon("icon_italic_selected.png", 28));
                }

                cb.setClicked(!cb.isClicked());
            }
        }

        if(bottomPanel.getBold().isClicked())
        {
            mode += Font.BOLD;
        }
        if (bottomPanel.getItalic().isClicked())
        {
            mode += Font.ITALIC;
        }

        Integer size;

        try
        {
            size = (Integer) fontSize.getEditor().getItem();
        }
        catch (Exception ex)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(frame, "Podana wartość musi być liczbą!", "Wystąpił błąd", JOptionPane.ERROR_MESSAGE);
            fontSize.setSelectedItem(15);
            size = 15;
        }

        if (size > 1000)
        {
            size = 1000;
            fontSize.setSelectedItem(1000);
        }

        if (size < 1)
        {
            size = 15;
            fontSize.setSelectedItem(15);
        }

        Font font = new Font(fonts.getItemAt(fonts.getSelectedIndex()), mode, size);
        frame.getTextArea().setFont(font);
    }
}
