import static java.util.Objects.hash;

/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: [Jacob Lowe]
 *</p>
 */

public class DNA {

    public static int STRCount(String sequence, String STR) {
        int strCount = 0;
        int strLength = STR.length();
        long strHash = hash(STR, strLength);
        long seqHash = hash(sequence.substring(0, strLength - 1), strLength);
        for (int i = STR.length(); i < sequence.length() - 1; i++) {
            if (strHash == seqHash) {

                // Begin checking for consecutive appearances
                while (strHash == seqHash) {
                    strCount++;;
                    seqHash = hash(sequence.substring(i, i + strLength), strLength);
                }
            }
            seqHash = hash(sequence.substring(1 + (i - STR.length()), i), strLength);
        }
        return strCount;
    }

    public static long hash(String STR, int strLength) {
        int R = 255;
        long h = 0;
        long p = 54321102419L;
        for (int i = 0; i < strLength; i++) {
            h = (h * R + STR.charAt(i)) % p;
        }
        return h;
    }
}
