package top.tinn.Over200.Problem_307;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/19
 */
public class NumArray {
    private int[] tree;
    private int n;
    public NumArray(int[] nums) {
        if (nums.length > 0){
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        for (int i = n, j = 0; i < n * 2; i++, j++){
            tree[i] = nums[j];
        }
        for (int i = n - 1; i > 0; i--){
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int i, int val) {
        i += n;
        tree[i] = val;
        while (i > 0){
            int left = i;
            int right = i;
            if ((i & 1) == 0){
                right++;
            }else{
                left--;
            }
            tree[i / 2] = tree[left] + tree[right];
            i >>>= 1;
        }
    }

    public int sumRange(int i, int j) {
        int l = i + n;
        int r = j + n;
        int sum = 0;
        while (l <= r){
            if (l % 2 == 1){
                sum += tree[l];
                l++;
            }
            if (r % 2 == 0){
                sum += tree[r];
                r--;
            }
            l >>>= 1;
            r >>>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1,3,5});
        System.out.println(numArray.sumRange(0,2));
        numArray.update(0,2);
        System.out.println(numArray.sumRange(0,2));
    }
}
