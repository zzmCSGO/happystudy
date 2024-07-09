package com.zzm.cz.pdd;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.cz.pdd
 * @Author: zzm
 * @CreateTime: 2024-03-24  19:36
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam3 {

    //    快递员都可以从u走到v，或者从v走到u，那么则评定站点u为超级快递点。请你帮忙算一算，一共有多少个超级快递点
    public static void main(String[] args) {
        int n = 7;//快递点个数
        int m = 7;//单向车道个数
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {4, 7}, {2, 5}, {5, 4}, {6, 4}};
        int i = superPoint(n, m, arr);
        System.out.println(i);

    }

     /*n个快递点之间通过m条单向车道连接。快递员从任何一个快递站点出发，
     无法通过单向车道回到该站点。 也就是说，n个快递点组成一张有向无环图。
     对于
     或者从v走到u，那么则评定站点u为超级快递点，一共有多少个超级快递点*/

    private static int superPoint(int n, int m, int[][] arr) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            out[u]++;
            in[v]++;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (in[i] + out[i] == n - 1) {
                count++;
            }
        }
        return count;
    }
}
