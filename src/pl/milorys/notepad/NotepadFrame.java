package pl.milorys.notepad;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import pl.milorys.notepad.dialogs.SettingsDialog;
import pl.milorys.notepad.listeners.*;
import pl.milorys.notepad.menus.NotepadMenuBar;
import pl.milorys.notepad.toolbar.NotepadToolBar;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.net.URL;

public class NotepadFrame extends JFrame
{
    private final int TEXT_ROWS = 10;
    private final int TEXT_COLUMNS = 20;
    private final String defaultTitle = "Notatnik (egzemplarz testowy)";
    private JTextArea textArea;
    public static JFileChooser fileChooser = null;
    private FileNameExtensionFilter fileFilter;
    private JPanel toolbarPanel = new JPanel();
    private boolean edited = false;
    private boolean closing = false;
    private static NotepadSettings settings;
    private UndoManager manager;

    public Icon prepareIcon(String iconName, int size)
    {
        URL url = getClass().getClassLoader().getResource(iconName);
        Image img = new ImageIcon(url).getImage().getScaledInstance(size, size, 0);
        Icon icon = new ImageIcon(img);
        return icon;
    }

    public NotepadFrame()
    {
        FrameGetter frameGetter = new FrameGetter(this);
        settings = new NotepadSettings();
        setNotepadTheme(settings.getTheme());

        //Ustawianie rozdzielczości
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit.getScreenSize();
        int width = (int) dim.getWidth() / 2;
        int height = (int) dim.getHeight() / 2 + 200;

        setSize(width, height);
        setTitle(defaultTitle);

        //Filtr rozszerzeń
        fileFilter = new FileNameExtensionFilter("Pliki tekstowe", "txt");

        //Pole tekstowe
        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        textArea.addKeyListener(new TextEventHandler());
        JScrollPane scrollPane = new JScrollPane(textArea);

        manager = new UndoManager();
        textArea.getDocument().addUndoableEditListener(manager);

        //Pasek popup
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new CutAction("Wytnij", prepareIcon("icon_cut.png", 16)));
        popupMenu.add(new CopyAction("Kopiuj", prepareIcon("icon_copy.png", 16)));
        popupMenu.add(new PasteAction("Wklej", prepareIcon("icon_paste.png", 16)));
        textArea.setComponentPopupMenu(popupMenu);

        //Dodanie do ramki
        setJMenuBar(new NotepadMenuBar());
        add(new NotepadToolBar(), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addWindowListener(new WindowEventHandler());
    }

    public static void setNotepadTheme(int value)
    {
        JComboBox<String> themes = SettingsDialog.getThemes();


        if (value < 0 || value > 4)
        {
            setNotepadTheme(0);
        }
        else
        {
            try
            {
                switch (value)
                {
                    case 0:
                        UIManager.setLookAndFeel(new FlatLightLaf());
                        break;
                    case 1:
                        UIManager.setLookAndFeel(new FlatDarkLaf());
                        break;
                    case 2:
                        UIManager.setLookAndFeel(new FlatDarculaLaf());
                        break;
                    case 3:
                        changeFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                        break;
                    case 4:
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        break;
                }
                SwingUtilities.updateComponentTreeUI(FrameGetter.getFrame());
                String aValue = String.valueOf(value);
                settings.setTheme(aValue);
            }
            catch (UnsupportedLookAndFeelException e)
            {
                e.printStackTrace();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void changeFeel(String classname) throws Exception
    {
        UIManager.setLookAndFeel(classname);
        SwingUtilities.updateComponentTreeUI(FrameGetter.getFrame());
    }

    public JFileChooser getFileChooser()
    {
        return fileChooser;
    }

    public JTextArea getTextArea()
    {
        return textArea;
    }

    public String getDefaultTitle()
    {
        return defaultTitle;
    }

    public FileNameExtensionFilter getFileFilter()
    {
        return fileFilter;
    }

    public boolean isClosing()
    {
        return closing;
    }

    public boolean isEdited()
    {
        return edited;
    }

    public void setEdited(boolean edited)
    {
        this.edited = edited;
    }

    public void setClosing(boolean closing)
    {
        this.closing = closing;
    }

    public NotepadSettings getSettings()
    {
        return settings;
    }

    public UndoManager getUndoManager()
    {
        return manager;
    }

}
