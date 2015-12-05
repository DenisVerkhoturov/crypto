package app.manager;

import app.base.Language;
import app.language.Russian;

/**
 * Класс управляющий языками.
 */
public class LanguageManager
{
    private String languagePath = "app.language";

    private Language currentLanguage;

    public LanguageManager()
    {
        this.currentLanguage = new Russian();
    }

    public void setCurrentLanguage(String language)
    {}
}
