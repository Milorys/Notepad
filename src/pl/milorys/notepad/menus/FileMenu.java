package pl.milorys.notepad.menus;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.dialogs.ProgramInfoDialog;
import pl.milorys.notepad.listeners.OpenItemEventHandler;
import pl.milorys.notepad.listeners.SaveAsEventHandler;
import pl.milorys.notepad.listeners.SettingsEventHandler;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

public class FileMenu extends JMenu
{
    private NotepadFrame frame;

    private JMenuItem addIcon(JMenuItem menuItem, String iconName)
    {
        if (iconName != null)
        {
            URL url = getClass().getClassLoader().getResource(iconName);
            Image img = new ImageIcon(url).getImage().getScaledInstance(17, 17, 0);
            Icon icon = new ImageIcon(img);
            menuItem.setIcon(icon);
        }
        else System.out.println("Error");

        return menuItem;
    }

    public FileMenu(String name)
    {
        super(name);

        frame = FrameGetter.getFrame();

        JMenuItem openItem = new JMenuItem("Otwórz");
        openItem = addIcon(openItem, "icon_open.png");
        openItem.addActionListener(new OpenItemEventHandler());
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
        add(openItem);

        JMenuItem saveItem = new JMenuItem("Zapisz");
        saveItem = addIcon(saveItem, "icon_save_file.png");
        saveItem.addActionListener(new SaveAsEventHandler());
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        add(saveItem);

        JMenuItem saveAsItem = new JMenuItem("Zapisz jako");
        saveAsItem = addIcon(saveAsItem, "icon_save_file_as.png");
        saveAsItem.addActionListener(new SaveAsEventHandler());
        add(saveAsItem);

        addSeparator();

        JMenuItem settingsItem = new JMenuItem("Ustawienia");
        add(settingsItem);

        settingsItem.addActionListener(new SettingsEventHandler());
        addSeparator();
        JMenuItem programInfoItem = new JMenuItem("O programie");
        programInfoItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ProgramInfoDialog dialog = new ProgramInfoDialog(frame);
                dialog.setVisible(true);
            }
        });
        add(programInfoItem);
        setMnemonic('o');
    }
}
