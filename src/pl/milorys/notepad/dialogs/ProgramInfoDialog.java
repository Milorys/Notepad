package pl.milorys.notepad.dialogs;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ProgramInfoDialog extends JDialog
{
    public ProgramInfoDialog(Frame owner)
    {
        super(owner);
        setModal(true);
        setTitle("O programie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(owner);
        setLayout(new GridBagLayout());

        NotepadFrame frame = FrameGetter.getFrame();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;

        JLabel authorImage = new JLabel();
        authorImage.setIcon(frame.prepareIcon("Milorys.png", 100));
        authorImage.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        gbc.gridy = 0;
        add(authorImage, gbc);

        gbc.gridy = 1;
        add(new JSeparator(), gbc);

        JLabel info = new JLabel("Bardzo wczesna wersja notatnika - 02.07.2020");
        gbc.gridy = 2;
        add(info, gbc);

        JLabel author = new JLabel("Wykonanie Michał Markiewicz (Milorys)");
        gbc.gridy = 3;
        add(author, gbc);

        JLabel copryright = new JLabel("Wszelkie prawa zastrzeżone ©");
        gbc.gridy = 4;
        add(copryright, gbc);

        setSize(350, 250);
        setResizable(false);
    }
}
