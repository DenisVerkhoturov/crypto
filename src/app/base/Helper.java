package app.base;

/**
 * Класс целиком состоящий из статических методов.
 */
public class Helper
{
    /**
     * Метод приведения строки к прописаной строке с первой заглавной.
     * @param string - вкодящая строка: cAesAR
     * @return - возвращаумая строка: Caesar
     */
    public static String capitalize(String string)
    {
        return string.toLowerCase().substring(0,1).toUpperCase() + string.substring(1);
    }
}
