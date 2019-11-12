package pl.tw.dailycodingquestion;

/**
 * Suppose we represent our file system by a string in the following manner:
 * <p>
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * <p>
 * dir
 * --subdir1
 * --subdir2
 * ----file.ext
 * <p>
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
 * <p>
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 * <p>
 * dir
 * --subdir1
 * ----file1.ext
 * ----subsubdir1
 * --subdir2
 * ----subsubdir2
 * ------file2.ext
 * <p>
 * The directory dir contains two sub-directories subdir1 and subdir2.
 * subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1.
 * subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
 * <p>
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system.
 * For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext",
 * and its length is 32 (not including the double quotes).
 * <p>
 * Given a string representing the file system in the above format,
 * return the length of the longest absolute path to a file in the abstracted file system.
 * If there is no file in the system, return 0.
 */

public class CodingQuestion17 {

    public static void main(String[] args) {
        System.out.println(maxLength("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    public static int maxLength(String fs) {
        int maxSize = 0;
        int[] levelsLength = new int[100];
        int i = 0;

        while (i <= fs.length()) {
            int level = 0;
            while (fs.charAt(i) == '\t') {
                level++;
                i++;
            }

            int endOfName = fs.indexOf('\n', i);
            endOfName = endOfName == -1 ? fs.length() : endOfName;
            String name = fs.substring(i, endOfName);

            if (level != 0) {
                levelsLength[level] = levelsLength[level - 1] + name.length() + 1;
            } else {
                levelsLength[level] = name.length();
            }

            if (name.contains(".")) {
                maxSize = Math.max(levelsLength[level], maxSize);
            }

            i = endOfName + 1;
        }
        return maxSize;
    }
}
