package pl.milorys.notepad.dialogs;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;
import pl.milorys.notepad.toolbar.BottomPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsDialog extends JDialog
{
    private NotepadFrame frame;
    private static JComboBox<String> themes;

    public SettingsDialog(Frame owner)
    {
        super(owner);
        setModal(true);
        setTitle("Ustawienia");
        setLayout(new FlowLayout());

        frame = FrameGetter.getFrame();
        setLocationRelativeTo(frame);

        //Panel zmiany motywu
        JPanel themePanel = new JPanel();
        themePanel.setLayout(new GridLayout(3, 1));
        themePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Zmiana motywu"));
        JLabel label1 = new JLabel("Ustawienie pozwalające zmienić motyw aplikacji");
        JLabel label2 = new JLabel("Motyw systemowy zależny jest od twojego systemu operacyjnego");

        themes = new JComboBox<>();
        themes.addItem("Light");
        themes.addItem("Dark");
        themes.addItem("Dracula");
        themes.addItem("Java Look and Feel");
        themes.addItem("Systemowy");
        themes.setSelectedIndex(frame.getSettings().getTheme());
        themes.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int index = themes.getSelectedIndex();
                NotepadFrame.setNotepadTheme(index);
                SwingUtilities.updateComponentTreeUI(SettingsDialog.this);
                pack();
                BottomPanel.getColorChooserButton().setBackground(frame.getTextArea().getForeground());
            }
        });

        themePanel.add(label1);
        themePanel.add(label2);
        themePanel.add(themes);

        add(themePanel);
        pack();
    }

    private void showMessageError()
    {
        JOptionPane.showMessageDialog(frame, "Ustawianie motowu nie powiodło się!", "Wystąpił błąd", JOptionPane.ERROR_MESSAGE);
    }

    public void changeFeel(String classname) throws Exception
    {
        UIManager.setLookAndFeel(classname);
        SwingUtilities.updateComponentTreeUI(frame);
    }

    public static JComboBox<String> getThemes()
    {
        return themes;
    }
}
