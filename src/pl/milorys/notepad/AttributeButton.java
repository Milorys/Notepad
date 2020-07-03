package pl.milorys.notepad;

import javax.swing.*;

public class AttributeButton extends JButton
{
    private String attribute;

    public AttributeButton(Icon icon, String attribute)
    {
        super(icon);
        this.attribute = attribute;
    }

    public String getAttribute()
    {
        return attribute;
    }
}
