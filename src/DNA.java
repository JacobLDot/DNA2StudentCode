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
    private final static int RADIX = 4;

    // Horner's Method: used for computing a hash value from a string
    public static long hash(String STR) {
        long hash = 0;
        for (int i = 0; i < STR.length(); i++) {
            hash = (hash * RADIX + STR.charAt(i));
        }
        return hash;
    }

    public static int STRCount(String sequence, String STR) {

        // Length of STR & DNA sequence
        int strLength = STR.length();
        int seqLength = sequence.length();

        // Initial hash values
        long strHash = hash(STR);
        long seqHash = 0;

        // Highest power of RADIX
        long power = 1;

        // Initial hash for first window
        for (int i = 0; i < strLength; i++) {
            seqHash = (seqHash * RADIX + sequence.charAt(i));
            if (i < strLength - 1) {
                power = (power * RADIX);
            }
        }

        int maxCount = 0;

        // Slides a window of length of STR through the entire DNA sequence
        for (int i = 0; i <= seqLength - strLength; i++) {
            if (seqHash == strHash) {
                int strCount = 0;
                int position = i;
                long currentHash = seqHash;

                // As long as the STRs are consecutive keep counting STRs
                while (position + strLength <= seqLength && currentHash == strHash) {
                    strCount++;
                    position += strLength;
                    if (position + strLength > seqLength) break;

                    // Skip forward strLength times in the sequence
                    long nextHash = 0;
                    for (int j = 0; j < strLength; j++) {
                        nextHash = nextHash * RADIX + sequence.charAt(position + j);
                    }
                    currentHash = nextHash;
                }

                // Track maximum chain of repeated STRs
                maxCount = Math.max(maxCount, strCount);

                // Skip counted parts if found STR
                if (strCount > 0) i += (strCount - 1) * strLength;
            }
            // Rolling hash - slide by 1 character
            if (i + strLength < seqLength) {
                // "sequence.charAt(i) * pow" removes old first char
                // "* RADIX" shifts all characters to the left
                // "+ sequence.charAt(i + strLength)" adds the next character
                seqHash = ((seqHash - sequence.charAt(i) * power) * RADIX) + sequence.charAt(i + strLength);
            }
        }

        // Returns maximum chain of repeated STRs
        System.out.println(maxCount);
        return maxCount;
    }
}