package app.base;

/**
 * Абстрактный класс язык, с наследниками которого работает внешняя среда.
 */
public abstract class Language
{
    public final String[] alphabet;

    protected Language(String[] alphabet)
    {
        this.alphabet = alphabet;
    }

    public String name(){
        return this.getClass().getSimpleName();
    }
}
