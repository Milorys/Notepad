package pl.milorys.notepad.toolbar;

import pl.milorys.notepad.AttributeButton;
import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;
import pl.milorys.notepad.listeners.*;
import pl.milorys.notepad.menus.EditMenu;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel
{
    private NotepadFrame frame;
    private NotepadToolBar notepadToolBar;
    private JButton undoButton;
    private JButton redoButton;
    private static UndoRedoButtons urb;

    public TopPanel(NotepadToolBar notepadToolBar)
    {
        frame = FrameGetter.getFrame();
        FrameGetter.setTopPanel(this);
        this.notepadToolBar = notepadToolBar;

        setLayout(new FlowLayout());

        Dimension dim = new Dimension(28, 28);

        JButton newButton = new JButton(frame.prepareIcon("icon_new_content.png", 24));
        newButton.addActionListener(new NewContentEventHandler());
        newButton.setToolTipText("Nowy");
        newButton.setPreferredSize(dim);
        add(newButton);

        JButton openButton = new JButton(frame.prepareIcon("icon_open.png", 24));
        openButton.addActionListener(new OpenItemEventHandler());
        openButton.setToolTipText("Otwórz");
        openButton.setPreferredSize(dim);
        add(openButton);

        AttributeButton saveButton = new AttributeButton(frame.prepareIcon("icon_save_file.png", 24), "save");
        saveButton.setToolTipText("Zapisz");
        saveButton.setActionCommand("Zapisz");
        saveButton.addActionListener(new SaveAsEventHandler());
        saveButton.setPreferredSize(dim);
        add(saveButton);

        AttributeButton saveAsButton = new AttributeButton(frame.prepareIcon("icon_save_file_as.png", 24), "save_as");
        saveAsButton.setToolTipText("Zapisz jako");
        saveAsButton.setActionCommand("Zapisz jako");
        saveAsButton.addActionListener(new SaveAsEventHandler());
        saveAsButton.setPreferredSize(dim);
        add(saveAsButton);

        add(new JSeparator());

        JButton cutButton = new JButton(new CutAction(null, frame.prepareIcon("icon_cut.png", 24)));
        cutButton.setToolTipText("Wytnij");
        cutButton.setPreferredSize(dim);
        add(cutButton);

        JButton copyButton = new JButton(new CopyAction(null, frame.prepareIcon("icon_copy.png", 24)));
        copyButton.setToolTipText("Kopiuj");
        copyButton.setPreferredSize(dim);
        add(copyButton);

        JButton pasteButton = new JButton(new PasteAction(null, frame.prepareIcon("icon_paste.png", 24)));
        pasteButton.setToolTipText("Wklej");
        pasteButton.setPreferredSize(dim);
        add(pasteButton);

        add(new JSeparator());

        //Undo i redo
        undoButton = new JButton();
        undoButton.setPreferredSize(dim);

        redoButton = new JButton();
        redoButton.setPreferredSize(dim);

        urb = new UndoRedoButtons(undoButton, redoButton);
        undoButton.setAction(new UndoAction(null, frame.prepareIcon("icon_undo.png", 24), urb, EditMenu.getUndoRedoMenuItems()));
        undoButton.setEnabled(false);
        undoButton.setToolTipText("Cofnij");
        redoButton.setAction(new RedoAction(null, frame.prepareIcon("icon_redo.png", 24), urb, EditMenu.getUndoRedoMenuItems()));
        redoButton.setEnabled(false);
        redoButton.setToolTipText("Ponów");
        add(undoButton);
        add(redoButton);
    }

    public JButton getUndoButton()
    {
        return undoButton;
    }

    public JButton getRedoButton()
    {
        return redoButton;
    }

    public static UndoRedoButtons getUndoRedoButtons()
    {
        return urb;
    }
}
