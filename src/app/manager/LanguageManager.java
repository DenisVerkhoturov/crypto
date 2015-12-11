package app.manager;

import app.base.Helper;
import app.base.Language;
import app.base.PackageManager;

/**
 * Класс управляющий языками.
 */
public class LanguageManager extends PackageManager
{
    private Language current;

    public LanguageManager()
    {
        super();
        this.workingPath = "language";
        this.type = Language.class;
    }

    public Language getCurrent() throws NullPointerException
    {
        return this.current;
    }

    public boolean setCurrent(String language)
    {
        try {
            this.current = (Language) Class.forName(this.workingPath + "." + Helper.capitalize(language)).newInstance();
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Такого класса не существует: " + e);
        } catch (InstantiationException e) {
            System.out.println("Не возможно создать экземпляр этого класса: " + e);
        } catch (IllegalAccessException e) {
            System.out.println("Модификатор доступа не позволяет создать экземпляр класса: " + e);
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e);
        }

        return false;
    }
}
