package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenItemEventHandler implements ActionListener
{
    private pl.milorys.notepad.NotepadFrame frame;
    private JTextArea textArea;

    public OpenItemEventHandler()
    {
        frame = FrameGetter.getFrame();
        textArea = frame.getTextArea();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        NotepadFrame.fileChooser = new JFileChooser();
        NotepadFrame.fileChooser.setFileFilter(frame.getFileFilter());
        if(NotepadFrame.fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION)
        {
            Scanner scanner;
            File file = NotepadFrame.fileChooser.getSelectedFile();
            try
            {
                scanner = new Scanner(file);
                textArea.setText("");
                while (scanner.hasNext()) {
                    textArea.append(scanner.nextLine() + "\n");
                }
                frame.setTitle(frame.getDefaultTitle() + " | " + file.getName());
            }
            catch (FileNotFoundException fileNotFoundException)
            {
                fileNotFoundException.printStackTrace();
            }
        }
    }
}
