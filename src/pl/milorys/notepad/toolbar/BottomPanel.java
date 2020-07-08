package pl.milorys.notepad.toolbar;

import pl.milorys.notepad.CheckButton;
import pl.milorys.notepad.FrameGetter;
import pl.milorys.notepad.NotepadFrame;
import pl.milorys.notepad.listeners.BackgroundColorEventHandler;
import pl.milorys.notepad.listeners.ColorButtonEventHandler;
import pl.milorys.notepad.listeners.FontEventHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BottomPanel extends JPanel
{
    private NotepadFrame frame;
    private NotepadToolBar notepadToolBar;

    private JComboBox<Integer> fontSize;
    private JComboBox<String> fonts;
    private CheckButton bold;
    private CheckButton italic;
    private CheckButton lineWrap;
    private static JButton colorChooserButton;
    private static JButton backgroundColorChooser;

    public BottomPanel(NotepadToolBar notepadToolBar)
    {
        this.notepadToolBar = notepadToolBar;
        this.frame = FrameGetter.getFrame();
        FrameGetter.setBottomPanel(this);

        setLayout(new FlowLayout());

        Dimension dim = new Dimension(28, 28);

        initializeFonts();
        fontSize = new JComboBox<>(new Integer[] { 8, 10, 12, 15, 18, 24, 36, 48, 72});
        fontSize.setSelectedIndex(2);
        fontSize.setEditable(true);
        add(fontSize);

        //Kolor tekstu
        colorChooserButton = new JButton(frame.prepareIcon("icon_textcolor.png", 25));
        colorChooserButton.setToolTipText("Wybór koloru tekstu");
        colorChooserButton.setPreferredSize(new Dimension(28, 28));
        colorChooserButton.setBackground(frame.getTextArea().getForeground());
        colorChooserButton.addActionListener(new ColorButtonEventHandler(colorChooserButton));
        colorChooserButton.setFocusPainted(true);
        add(colorChooserButton);

        //Kolor tła
        backgroundColorChooser = new JButton(frame.prepareIcon("icon_background_color.png", 18));
        backgroundColorChooser.setToolTipText("Wybór koloru tła");
        backgroundColorChooser.setPreferredSize(new Dimension(28, 28));
        backgroundColorChooser.setBackground(frame.getTextArea().getBackground());
        backgroundColorChooser.addActionListener(new BackgroundColorEventHandler(backgroundColorChooser));
        add(backgroundColorChooser);

        bold = new CheckButton(null, "bold");
        bold.setToolTipText("Pogrubienie tekstu");
        bold.setPreferredSize(new Dimension(28, 28));
        bold.setIcon(frame.prepareIcon("icon_bold_not_selected.png", 28));
        add(bold);

        italic = new CheckButton(null, "italic");
        italic.setToolTipText("Pochylenie tekstu");
        italic.setPreferredSize(new Dimension(28, 28));
        italic.setIcon(frame.prepareIcon("icon_italic_not_selected.png", 28));
        add(italic);

        lineWrap = new CheckButton(null, null);
        lineWrap.setToolTipText("Zawijanie tekstu: wyłączony");
        lineWrap.setPreferredSize(dim);
        lineWrap.setIcon(frame.prepareIcon("icon_wrap-disabled.png",28));
        lineWrap.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(lineWrap.isClicked())
                {
                    lineWrap.setIcon(frame.prepareIcon("icon_wrap-disabled.png", 28));
                    lineWrap.setToolTipText("Zawijanie tekstu: wyłączony");
                }
                else
                {
                    lineWrap.setIcon(frame.prepareIcon("icon_wrap.png", 28));
                    lineWrap.setToolTipText("Zawijanie tekstu: włączony");
                }

                lineWrap.setClicked(!lineWrap.isClicked());
                frame.getTextArea().setLineWrap(lineWrap.isClicked());
            }
        });
        add(lineWrap);

        addListeners();
        setDefaultFontSettings();
    }

    private void addListeners()
    {
        fontSize.addActionListener(new FontEventHandler(this));
        fonts.addActionListener(new FontEventHandler(this));
        bold.addActionListener(new FontEventHandler(this));
        italic.addActionListener(new FontEventHandler(this));
    }

    private void initializeFonts()
    {
        fonts = new JComboBox<>();
        fonts.setEditable(true);
        fonts.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent event)
            {
                if(event.getStateChange() == ItemEvent.SELECTED)
                {
                    String fontName = fonts.getSelectedItem().toString();
                    fonts.setFont(new Font(fontName, Font.PLAIN, 11));
                }
            }
        });

        String[] aFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String font : aFonts)
            fonts.addItem(font);

        add(fonts);
    }

    public void setDefaultFontSettings()
    {
        //Domyślne ustawienia przy wejściu
        fonts.setSelectedIndex(3);
        fontSize.setSelectedIndex(3);
        Font font = new Font(fonts.getItemAt(fonts.getSelectedIndex()), Font.PLAIN, fontSize.getItemAt(fontSize.getSelectedIndex()));
        frame.getTextArea().setFont(font);
        frame.getLineCounter().setFont(font);
    }

    public CheckButton getBold()
    {
        return bold;
    }

    public CheckButton getItalic()
    {
        return italic;
    }

    public JComboBox<String> getFonts()
    {
        return fonts;
    }

    public  JComboBox<Integer> getFontSize()
    {
        return fontSize;
    }

    public static JButton getColorChooserButton()
    {
        return colorChooserButton;
    }
}
