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
        long strHash = 0;
        long seqHash = 0;
        long numValue = 1;

        for (int i = 0; i < strLength; i++) {
            strHash = (strHash * RADIX + STR.charAt(i));
            seqHash = (seqHash * RADIX + sequence.charAt(i));
            if (i < strLength - 1) {
                numValue = (numValue * RADIX);
            }
        }

        int maxCount = 0;

        // Slides a window of length of STR through the entire DNA sequence
        for (int i = 0; i <= seqLength - strLength; i++) {
            int strCount = 0;
            int position = i;
            long currentHash = seqHash;
            while (position + strLength <= seqLength && currentHash == strHash) {
                strCount++;
                position += strLength;
                if (position + strLength - 1 > seqLength) break;
                currentHash = 0;
                for (int j = 0; j < strLength; j++) {
                    currentHash = (currentHash * RADIX + sequence.charAt(position + j));
                }
            }

            // Track maximum chain of repeated STRs
            maxCount = Math.max(maxCount, strCount);

            // Rolling hash
            if (i + strLength < seqLength) {
                seqHash = (seqHash - sequence.charAt(i) * numValue);
                seqHash = (seqHash * RADIX) + sequence.charAt(i + strLength);
            }
        }

        // Returns maximum chain of repeated STRs
        System.out.println(maxCount);
        return maxCount;
    }
}