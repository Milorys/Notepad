package pl.milorys.notepad.dialogs;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;
import pl.milorys.notepad.listeners.SaveAsEventHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ExitSaveDialog extends JDialog
{
    private NotepadFrame frame;
    private JLabel label;
    private JLabel imageLabel;
    private JFileChooser fileChooser;

    public ExitSaveDialog(Frame owner)
    {
        super(owner);
        setModal(true);
        setTitle("Notatnik");
        setLayout(new BorderLayout());
        setLocationRelativeTo(owner);

        NotepadFrame frame = FrameGetter.getFrame();
        fileChooser = frame.getFileChooser();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        frame.setClosing(true);

        URL url = getClass().getClassLoader().getResource("file_icon.png");
        Image img = new ImageIcon(url).getImage().getScaledInstance(40, 40, 4);
        Icon icon = new ImageIcon(img);
        imageLabel = new JLabel();
        imageLabel.setIcon(icon);

        if (fileChooser != null && fileChooser.getSelectedFile() != null)
        {
            String filename = fileChooser.getSelectedFile().getName();
            label = new JLabel("Czy chcesz zapisać zmiany w pliku " + filename + "?");
        }
        else
            label = new JLabel("Czy chcesz zapisać ten plik?");

        JButton save = new JButton("Zapisz");
        save.addActionListener(new SaveAsEventHandler());
        JButton dontSave = new JButton("Nie zapisuj");;
        dontSave.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        JButton cancel = new JButton("Anuluj");
        cancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setClosing(false);
                dispose();
            }
        });

        northPanel.add(imageLabel);
        northPanel.add(label);
        centerPanel.add(save);
        centerPanel.add(dontSave);
        centerPanel.add(cancel);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        pack();
    }
}
