package pl.milorys.notepad.menus;

import pl.milorys.notepad.listeners.CopyAction;
import pl.milorys.notepad.listeners.CutAction;
import pl.milorys.notepad.listeners.PasteAction;

import javax.swing.*;

public class EditMenu extends JMenu
{
    public EditMenu(String name)
    {
        super(name);

        JMenu editMenu = new JMenu("Edycja");
        JMenuItem cutItem = new JMenuItem(new CutAction("Wytnij", null));
        JMenuItem copyItem = new JMenuItem(new CopyAction("Kopiuj", null));
        JMenuItem pasteItem = new JMenuItem(new PasteAction("Wklej", null));
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
    }
}
