package pl.milorys.notepad.menus;

import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;
import pl.milorys.notepad.listeners.*;
import pl.milorys.notepad.toolbar.TopPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class EditMenu extends JMenu
{
    private NotepadFrame frame;
    private static UndoRedoMenuItems urmi;

    public EditMenu(String name)
    {
        super(name);

        frame = FrameGetter.getFrame();

        JMenuItem undoItem = new JMenuItem();
        JMenuItem redoItem = new JMenuItem();

        urmi = new UndoRedoMenuItems(undoItem, redoItem);

        undoItem.setAction(new UndoAction("Cofnij", frame.prepareIcon("icon_undo.png", 16), null, urmi));
        undoItem.setEnabled(false);
        undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
        redoItem.setAction(new RedoAction("Ponów", frame.prepareIcon("icon_redo.png", 16), null, urmi));
        redoItem.setEnabled(false);
        add(undoItem);
        add(redoItem);

        addSeparator();

        JMenuItem cutItem = new JMenuItem(new CutAction("Wytnij", frame.prepareIcon("icon_cut.png", 16)));
        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X ,KeyEvent.CTRL_MASK));
        JMenuItem copyItem = new JMenuItem(new CutAction("Kopiuj", frame.prepareIcon("icon_copy.png", 16)));
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C ,KeyEvent.CTRL_MASK));
        JMenuItem pasteItem = new JMenuItem(new CutAction("Wklej", frame.prepareIcon("icon_paste.png", 16)));
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V ,KeyEvent.CTRL_MASK));
        add(cutItem);
        add(copyItem);
        add(pasteItem);
    }

    public static UndoRedoMenuItems getUndoRedoMenuItems()
    {
        return urmi;
    }
}
