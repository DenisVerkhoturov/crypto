package app.base;

/**
 * Абстрактный класс язык, с наследниками которого работает внешняя среда.
 */
public abstract class Language
{
    public String[] alphabet;

    public String name(){
        return this.getClass().getSimpleName();
    }
}
