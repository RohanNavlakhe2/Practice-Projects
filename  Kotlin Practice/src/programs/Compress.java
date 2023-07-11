package programs;

public class Compress {
    public static void main(String[] args) {
        System.out.println(compress(new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(compress(new char[] {'a'}));
        System.out.println(compress(new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }

    public static int compress(char[] chars) {

        if (chars.length == 1) {
            return 1;
        }

        StringBuilder s = new StringBuilder();
        char character = chars[0];
        int charCount = 1;

        for (int i = 1; i <= chars.length - 1; i++) {
            if (chars[i] == character) {
                charCount++;

                if (i == chars.length - 1) {
                    s.append(character);
                    if (charCount > 1) {
                        s.append(Integer.toString(charCount));
                    }
                }
            } else {
                s.append(character);
                if (charCount > 1) {
                    s.append(Integer.toString(charCount));
                }

                character = chars[i];
                charCount = 1;
            }
        }

        chars = s.toString().toCharArray();
        chars = new char[20];
        System.out.println(chars);
        return chars.length;
    }

}
