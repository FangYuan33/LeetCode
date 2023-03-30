package leetcode.tree.postorder;

public class SolutionOffer33 {
    public boolean verifyPostorder(int[] postorder) {
        return doVerifyPostorder(postorder, 0, postorder.length - 1);
    }

    // 其中 begin 为要验证的树的开始索引 end为树的结束索引
    private boolean doVerifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }

        // 用左节点和根节点不断比较，找到右子树的最小节点，这样能把左子树的索引结束位置找出来
        int rightIndex = left;
        while (postorder[rightIndex] < postorder[right]) {
            rightIndex++;
        }
        // 验证右子树是不是都大于根节点，都大的话会重合
        int tempRightIndex = rightIndex;
        while (postorder[tempRightIndex] > postorder[right]) {
            tempRightIndex++;
        }

        return tempRightIndex == right && doVerifyPostorder(postorder, left, rightIndex - 1)
                && doVerifyPostorder(postorder, rightIndex, right - 1);
    }
}
