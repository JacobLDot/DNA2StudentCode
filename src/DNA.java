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

        // Length of STR & DNA sequence
        int strLength = STR.length();
        int seqLength = sequence.length();

        // Initial hash values
        long strHash = hash(STR, strLength);
        long seqHash = hash(sequence.substring(0, strLength), strLength);

        // Tracks max number of repetitions in a chain of STRs
        int totalCount = 0;

        // Slides a window of length of STR through the entire DNA sequence
        for (int i = 0; i <= seqLength - strLength; i++) {
            if (strHash == seqHash) {
                int strCount = 0;
                int seqStart = i;

                // If it matches, then begin checking for consecutive appearances
                while (seqStart + strLength <= seqLength && sequence.substring(seqStart, seqStart + strLength).equals(STR)) {
                    strCount++;
                    seqStart += strLength;
                }

                // Track maximum chain of repeated STRs
                totalCount = Math.max(totalCount, strCount);
            }

            // Slide window by 1 character if there's enough sequence left
            if (i + strLength < seqLength) {
                seqHash = hash(sequence.substring(i + 1, i + 1 + strLength), strLength);
            }
        }

        // Returns maximum chain of repeated STRs
        return totalCount;
    }

    // Method: hash
    public static long hash(String STR, int strLength) {
        // R: all ASCII values; H: # representing the STR; P: large prime number
        int R = 255;
        long h = 0;
        long p = 54321102419L;

        // Horner's Method: used for computing a hash value from a string
        for (int i = 0; i < strLength; i++) {
            h = (h * R + STR.charAt(i)) % p;
        }
        return h;
    }
}
