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

        // Variables to keep track of STR count and STR length
        int maxTimes = 0;
        int keyLength = STR.length();

        // Go through DNA sequence and check if the sequence
        // starting with each character is equal to the STR
        for (int i = 0; i <= sequence.length() - keyLength; i++) {
            int times = 0;
            while (sequence.startsWith(STR, i + times * keyLength)) {
                times++;
            }

            // If there is a longer string of STRs in the
            // DNA sequence then set the new longest.
            if (times > maxTimes) {
                maxTimes = times;
            }
        }

        // Print out and return STR count.
        System.out.println(maxTimes);
        return maxTimes;
    }
}
