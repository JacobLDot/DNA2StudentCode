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

    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        int maxTimes = 0;
        int keyLength = STR.length();
        for (int i = 0; i <= sequence.length() - keyLength; i++) {
            int times = 0;
            while (i + ((times + 1) * keyLength) <= sequence.length() && sequence.substring(i + (times * keyLength), i + ((times + 1) * keyLength)).equals(STR)) {
                times++;
            }
            if (times > maxTimes) {
                maxTimes = times;
            }
        }
        System.out.println(maxTimes);
        return maxTimes;
    }
}
