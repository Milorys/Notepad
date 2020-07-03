package pl.milorys.notepad.menus;

import javax.swing.*;

public class NotepadMenuBar extends JMenuBar
{
    public NotepadMenuBar()
    {
        add(new FileMenu("Plik"));
        add(new EditMenu("Edycja"));
    }
}
