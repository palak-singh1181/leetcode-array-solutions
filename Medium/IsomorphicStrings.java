
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < 256; i++) {
            mapS[i] = -1;
            mapT[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            if (mapS[a] == -1 && mapT[b] == -1) {

                mapS[a] = b;
                mapT[b] = a;
            }
            else {

                if (mapS[a] != b || mapT[b] != a) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";

        System.out.println(isIsomorphic(s, t));
    }
}