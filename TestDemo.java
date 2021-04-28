import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {

//有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。
//请设计一个算法，求出a和b点的最近公共祖先的编号。
//给定两个int a, b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
//测试样例：
//2，3
//返回：1


//思路：满二叉树的子节点与父节点之间的关系为root = child / 2
//利用这个关系，如果a ！= b，就让其中的较大数除以2， 如此循环知道a == b，
//即是原来两个数的最近公共祖先
    public int getLCA(int a, int b){
        while(a != b){
            if(a > b){
                a /=2;
            }else{
                b /= 2;
            }
        }
        return a;
    }

    /*
     * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
     * 输入: 一个byte型的数字
     * 输出: 无  
     * 返回: 对应的二进制数字中1的最大连续数
     * 输入描述:
     * 输入一个byte数字
     * 输出描述:
     * 输出转成二进制之后连续1的个数
     * 示例1 
     * 输入
     * 3
     * 输出
     * 2
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int maxcount = 0;
            int count = 0;
            while(a != 0){
                if(a % 2 == 1){
                    count++;
                    maxcount = Math.max(maxcount,count);
                }else{
                    count = 0;
                }
                a >>= 1;
            }
            System.out.println(maxcount);
        }
    }
    /*
    题目：有两个32位整数n和m，请编写算法将m的二进制数位插入到n的二进制的第j到第i位,其中二进制的位数从低位
    数到高位且以0开始。给定两个数int n和int m，同时给定int j和int i，意义如题所述，请返回操作后的数，保证n的第j到第i位均为
    零，且m的二进制位数小于等于i-j+1
    测试样例：
    1024，19，2，6
    返回：1100
    分析：    i   j
    1024：1000000000
      19：0000010011
      可以看到上面得出，只要我们用1011与1024的第j位到第i位做或运算（|）即可。
      我们想到可以让10011左移j位就可以正常做运算了。
      10000000000
      00001001100
     */
    int bin_insearch(int n, int m, int j, int i)
    {
        m = m << j;
        n = n | m;
        return n;
    }

    /**
     * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
     * @param args
     */
    public static void main4(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int count = 0;
            int countmain = 0;
            int b = 0;
            int x = 0;
            int y = 0;
            for(int i = 1; i <= a/2; i++){
                b = a - i;
                if(i == 1){
                    count = b - i;
                    countmain = count;
                    x = i;
                    y = b;
                }
                if(iszhi(b) && iszhi(i)){
                    count = b - i;
                    countmain = y - x;
                    if(count < countmain){
                        x = i;
                        y = b;
                    }
                }
            }
            System.out.println(y);
            System.out.println(x);
        }
    }
    public static boolean iszhi(int num){
        if(num == 1){
            return false;
        }
        for(int j=2; j < num; j ++){
            if(num % j == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 输入年 月 日 判断为这一年的第多少天
     * @param args
     */

    public static void main6(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            int result = 0;
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                for(int i = 1; i <= month -1; i++){
                    if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10) {
                        result += 31;
                    } else if (i == 2) {
                        result += 29;
                    } else {
                        result += 30;
                    }
                }
            }else{
                for(int i = 1; i <= month -1; i++){
                    if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10) {
                        result += 31;
                    } else if (i == 2) {
                        result += 28;
                    } else {
                        result += 30;
                    }
                }
            }
            result = result +day;
            System.out.println(result);
        }

    }

    /**
     * 题目描述：
     * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
     * 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
     * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
     * @param args
     * 解题思路：
     * 题目可以转化成求符合条件的集合真子集个数。每次从全集中选择若干元素（小球）组成子集（袋子）。集合子集个数为2^n个，使用dfs必然超时。且此题有重复元素，那么就搜索剪枝。
     * 对于任意两个正整数a,b如果满足 a+b>a*b，则必有一个数为1.可用数论证明：
     * 设a=1+x,b=1+y，则1+x+1+y>(1+x)*(1+y)，--->  1>x*y，则x，y必有一个为0，即a,b有一个为1.
     * 推广到任意k个正整数，假设a1,a2,...ak，如果不满足给定条件，即和sum小于等于积pi，
     * 如果此时再选择一个数b,能使其满足sum+b > pi*b，则，b必然为1，且为必要非充分条件。
     * 反之，如果选择的b>1，则sum+b <=pi*b，即a1,a2,...,ak,b不满足给定条件。（搜索剪枝的重要依据）
     *
     * 因此，将球按标号升序排序。每次从小到大选择，当选择到a1,a2,...,ak-1时满足给定条件，而再增加选择ak时不满足条件（ak必然大于等于max(a1,a2,...,ak-1)），继续向后选择更大的数，必然无法满足！因此，可以进行剪枝。
     * 如果有多个1，即当k=1时，sum(1)>pi(1)不满足，但下一个元素仍为1，则可以满足1+1>1*1，所以要判断当前ak是否等于1.
     * 此外，对于重复数字，要去重复。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i=0; i<n; i++)
                nums[i] = scanner.nextInt();

            Arrays.sort(nums);
            System.out.println(find(nums, 0, 0, 1));
        }
    }

    private static int find(int[] nums, int index, long sum, long multi) {
        int count = 0;
        for(int i=index; i<nums.length; i++) {
            sum += nums[i];
            multi *= nums[i];
            if(sum > multi)
                count += 1 + find(nums, i+1, sum, multi);
            else if(nums[i] == 1)
                count += find(nums, i+1, sum, multi);
            else
                break;
            sum -= nums[i];
            multi /= nums[i];
            while (i<nums.length-1 && nums[i]==nums[i+1])
                i++;
        }
        return count;
    }
}
