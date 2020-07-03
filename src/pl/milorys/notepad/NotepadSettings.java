package pl.milorys.notepad;

import java.io.*;
import java.util.Properties;

public class NotepadSettings
{
    private File file;
    private Properties properties;
    private FileReader fileReader;

    private int theme;

    public NotepadSettings()
    {
        file = new File("settings.properties");
        this.properties = new Properties();
        if (!file.exists()) createFile();
        openStream();
        initializeFields();
    }

    private void openStream()
    {
        try
        {
            this.fileReader = new FileReader(file);
            properties.load(fileReader);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void initializeFields()
    {
        this.theme = Integer.parseInt(properties.getProperty("theme"));
    }

    private void createFile()
    {
        PrintWriter pw = null;

        try
        {
            pw = new PrintWriter(file);
            properties.setProperty("theme", "0");
            properties.store(pw, "Ustawienia notatnika - nie ruszaj, jeśli się nie znasz");

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            pw.close();
        }
    }

    public int getTheme()
    {
        return theme;
    }

    public void setTheme(String value)
    {
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            properties.replace("theme", value);
            properties.store(fw, null);
            initializeFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
