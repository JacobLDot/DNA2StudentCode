/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: [YOUR NAME HERE]
 *</p>
 */

public class DNA {

    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        int times = 0;
        int counter = 0;
        int maxTimes = 0;
        int keyLength = STR.length();
        for (int i = 0; i < sequence.length(); i++) {
            times = 0;
            while (true) {
                if (sequence.substring(i + (times * keyLength), i + (times * keyLength) + keyLength) == STR) {
                    times += 1;
                    if (times > maxTimes) {
                        maxTimes = times;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(maxTimes);
        return maxTimes;
    }
}
