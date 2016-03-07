package app.base;

/**
 * Абстрактный класс язык, с наследниками которого работает внешняя среда.
 */
public enum Language
{
    RU("ru","russian", new String[] {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"}),
    EN("en", "english", new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"});

    final String code;
    final String readableName;
    final String[] alphabet;

    Language(String code, String readableName, String alphabet[])
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

    public String[] alphabet()
    {
        return this.alphabet;
    }
}
