package es.ieslavereda.exercises;

public class E5 {

    public static void main(String[] args) {

        System.out.println("Exercise (a)");
        System.out.println("Recursive");
        System.out.println("stringClean(\"yyzzza\") → \"" + stringClean("yyzzza") + "\"");
        System.out.println("stringClean(\"abbbcdd\") → \"" + stringClean("abbbcdd") + "\"");
        System.out.println("stringClean(\"Hello\") → \"" + stringClean("Hello") + "\"");
        System.out.println("Iterative");
        System.out.println("stringClean(\"yyzzza\") → \"" + stringCleanIteratively("yyzzza") + "\"");
        System.out.println("stringClean(\"abbbcdd\") → \"" + stringCleanIteratively("abbbcdd") + "\"");
        System.out.println("stringClean(\"Hello\") → \"" + stringCleanIteratively("Hello") + "\"");

        System.out.println("Exercise (b)");
        System.out.println("Recursive");
        System.out.println("compare(\"plane\",\"zoo\") → " + compare("plane", "zoo"));
        System.out.println("compare(\"zoo\",\"plane\") → " + compare("zoo", "plane"));
        System.out.println("compare(\"zoo\",\"zoo\") → " + compare("zoo", "zoo"));
        System.out.println("Iterative");
        System.out.println("compare(\"plane\",\"zoo\") → " + compareIteratively("plane", "zoo"));
        System.out.println("compare(\"zoo\",\"plane\") → " + compareIteratively("zoo", "plane"));
        System.out.println("compare(\"zoo\",\"zoo\") → " + compareIteratively("zoo", "zoo"));

    }

    // Exercise 5a
    // Recursive
    public static String stringClean(String str) {
        if (str.length() <= 1) return str;
        else if (str.charAt(0) != str.charAt(1))
            return str.charAt(0) + stringClean(str.substring(1));
        else
            return stringClean(str.substring(1));
    }
    // Exercise 5a
    // Iterative
    public static String stringCleanIteratively(String str) {
        int i = 0;
        StringBuilder result = new StringBuilder();

        while (i < str.length() - 1) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                result.append(str.charAt(i));
            }
            i++;
        }
        if (i < str.length())
            result.append(str.charAt(i));

        return result.toString();
    }

    // Exercise 5b
    // Recursive
	public static int compare(String str1, String str2){
		if(str1.equals("") && str2.equals("")) return 0;
		if(str1.equals("")) return -1;
		if(str2.equals("")) return 1;
		if(str1.charAt(0)!=str2.charAt(0)) return (str1.charAt(0)<str2.charAt(0))?-1:1;
		else
			return compare(str1.substring(1),str2.substring(1));
	}
    // Exercise 5a
    // Iterative
    public static int compareIteratively(String str1, String str2) {

        int i = 0;

        while (i < str1.length() && i < str2.length() && str1.charAt(0) == str2.charAt(0))
            i++;

        if (i == str1.length() && i == str2.length()) return 0;
        if (i == str1.length()) return -1;
        if (i == str2.length()) return 1;
        else  return (str1.charAt(i) < str2.charAt(i)) ? -1 : 1;

    }
}
