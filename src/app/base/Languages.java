package app.base;

/**
 * Абстрактный класс язык, с наследниками которого работает внешняя среда.
 */
public enum Languages
{
    RU("ru","russian", new char[] {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'}),
    EN("en", "english", new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'});

    private final String code;
    private final String readableName;
    private final char[] alphabet;

    Languages(String code, String readableName, char alphabet[])
    {
        this.code = code;
        this.readableName = readableName;
        this.alphabet = alphabet;
    }

    public String code()
    {
        return this.code;
    }

    public String readableName()
    {
        return this.readableName;
    }

    public char[] alphabet()
    {
        return this.alphabet;
    }
}
