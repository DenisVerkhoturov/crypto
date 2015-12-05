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

    public Language getCurrentLanguage()
    {
        return this.currentLanguage;
    }

    public boolean setCurrentLanguage(String language)
    {
        if (this.validateLanguage(language)) {
            try {
                this.currentLanguage = (Language) Class.forName(languagePath + "." + language).newInstance();
                return true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * Проверяет существование класса соответствующего переданному строковому обозначению языка.
     * @param language - строковое обозначение языка (например, Russian)
     * @return - возвращает true если класс найден и false если класс не удалось найти.
     */
    private boolean validateLanguage(String language)
    {
        try {
            Class.forName(languagePath + "." + language);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
