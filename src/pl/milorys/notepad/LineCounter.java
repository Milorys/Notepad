package pl.milorys.notepad;

import javax.swing.*;

public class LineCounter extends JTextArea
{
    private JTextArea textArea;

    public LineCounter(JTextArea textArea)
    {
        this.textArea = textArea;

        setColumns(1);
        setEditable(false);
    }

    public void updateLineCounter()
    {
        int lines = textArea.getLineCount();

        setText(null);

        for (int i = 1; i <= lines; i++)
        {
            append(i + "\n");
        }

    }
}
