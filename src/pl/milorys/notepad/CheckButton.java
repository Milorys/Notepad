package pl.milorys.notepad;

import javax.swing.*;

public class CheckButton extends JButton
{
    private boolean clicked;
    private String attribute;

    public CheckButton() {}

    public CheckButton(String name, String attribute)
    {
        super(name);

        clicked = false;
        this.attribute = attribute;
    }

    public boolean isClicked()
    {
        return clicked;
    }

    public boolean setClicked(boolean clicked)
    {
        this.clicked = clicked;
        return clicked;
    }

    public String getAttribute()
    {
        return attribute;
    }
}
