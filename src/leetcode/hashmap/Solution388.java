package leetcode.hashmap;

import java.util.HashMap;

public class Solution388 {

    public static void main(String[] args) {
//        System.out.println(new Solution388().lengthLongestPath("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));
//        System.out.println(new Solution388().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(new Solution388().lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    }

    public int lengthLongestPath(String input) {
        String res = "";
        int index = 0;
        HashMap<String, String> tPath = new HashMap<>();
        while (index < input.length() && index != -1) {
            // 确定是否有 \n
            if (input.startsWith("\n", index)) {
                index += 1;
            }
            StringBuilder t = new StringBuilder();
            // 确定是多少个 \t
            while (input.startsWith("\t", index)) {
                t.append("\t");
                index += 1;
            }
            int nextNIndex = input.indexOf("\n", index);
            // 文件或路径
            String fileOrPath;
            if (nextNIndex == -1) {
                fileOrPath = input.substring(index);
            } else {
                fileOrPath = input.substring(index, nextNIndex);
            }

            String pre;
            if (t.length() > 0) {
                pre = tPath.get(t.substring(0, t.length() - 1));
            } else {
                pre = "";
            }
            if (fileOrPath.contains(".")) {
                String path = pre + "/" + fileOrPath;
                if (path.length() > res.length()) {
                    res = path;
                }
            } else {
                tPath.put(t.toString(), pre + "/" + fileOrPath);
            }
            index = nextNIndex;
        }

        return res.length() > 0 ? res.length() - 1 : 0;
    }
}
