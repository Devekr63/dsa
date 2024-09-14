package com.phonepe.coding.diagonal_mat_sort;

import java.util.*;

public class DiagonalMatrixSort {
    public static void main(String[] args) {
        int[][] m = {{1,4,-2,-3},{-2,3,4,2},{3,1,3,4}, {2,2,1,2}};
        var sortedVal = sortByFreq(m);

        var res = arrange(sortedVal, m.length, m[0].length);

        printMat(res);
    }

    private static List<Integer> sortByFreq(int[][] mat){
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int[] row : mat){
            for(int num : row){
                list.add(num);
                freq.put(num, freq.getOrDefault(num, 0)+1);
            }
        }

        list.sort((a, b) -> {
           if(freq.get(a) != freq.get(b)) return freq.get(a) - freq.get(b);
           return a - b;
        });

        return list;
    }

    private static int[][] arrange(List<Integer> list, int rows, int cols){
        int[][] res = new int[rows][cols];

        int idx = 0;

        //starting row is last row always
        for(int j=cols-1; j>=0; j--){
            int x = rows-1;
            int y = j;

            while(y < cols){
                if(x < 0) break;
                res[x--][y++] = list.get(idx++);
            }
        }

        for(int i=rows-2; i>=0; i--){
            int x = i;
            int y = 0;

            while(x >= 0){
                res[x--][y++] = list.get(idx++);
            }
        }

        return res;
    }

    private static void printMat(int[][] mat){
        for(int[] row : mat){
            for(int num : row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// 2  2  2  4
// 2  4  3  1
// 4  3  1 -2
// 3  1 -2 -3