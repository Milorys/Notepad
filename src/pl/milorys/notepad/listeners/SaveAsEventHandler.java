package pl.milorys.notepad.listeners;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveAsEventHandler implements ActionListener
{
    private NotepadFrame frame;
    private JTextArea textArea;
    private FileNameExtensionFilter fileFilter;

    public SaveAsEventHandler()
    {
        frame = FrameGetter.getFrame();
        textArea = frame.getTextArea();
        fileFilter = frame.getFileFilter();
    }

    public void saveFile()
    {
        PrintWriter pw;
        try
        {
            File file = NotepadFrame.fileChooser.getSelectedFile();
            pw = new PrintWriter(file);
            Scanner scanner = new Scanner(textArea.getText());
            while (scanner.hasNext())
            {
                pw.println(scanner.nextLine());
            }
            frame.setTitle(frame.getDefaultTitle() + " | " + file.getName());
            pw.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (!event.getActionCommand().equals("Zapisz jako") && NotepadFrame.fileChooser
                != null && NotepadFrame.fileChooser.getSelectedFile() != null)
        {
            saveFile();
            frame.setEdited(false);
        }
        else
        {
            File tempFile = null;
            if (NotepadFrame.fileChooser != null && NotepadFrame.fileChooser.getSelectedFile() != null)
            {
                tempFile = NotepadFrame.fileChooser.getSelectedFile();
            }

            NotepadFrame.fileChooser = new JFileChooser();
            JFileChooser fc = NotepadFrame.fileChooser;
            if(NotepadFrame.fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION)
            {
                saveFile();
                frame.setEdited(false);
            }
            else NotepadFrame.fileChooser.setSelectedFile(tempFile);
        }

        if (frame.isClosing()) System.exit(0);

    }
}
