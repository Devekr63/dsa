package com.phonepe.coding.problem_one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[][] m = {{1,4,-2,-3},{-2,3,4,2},{3,1,3,4}, {2,2,1,2}};
        int rows = m.length;
        int cols = m[0].length;

        List<Integer> sorted = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] row : m){
            for(int k : row){
                map.put(k, map.getOrDefault(k, 0)+1);
                sorted.add(k);
            }
        }

        sorted.sort((a, b) -> {
            if(map.get(a) != map.get(b)) return map.get(a) - map.get(b);
            else return a - b;
        });
        System.out.println(sorted);

        int[][] res = new int[rows][cols];

        int idx = 0;

        for(int j=cols-1; j>=0; j--){
            int x = rows-1;
            int y = j;


            while(y < cols){
                if(x < 0) break;
                res[x--][y++] = sorted.get(idx++);
            }
        }

        for(int i=rows-2; i>=0; i--){
            int x = i;
            int y = 0;

            while(x >= 0){
                res[x--][y++] = sorted.get(idx++);
            }
        }

        printMatrix(res);
    }

    private static void printMatrix(int[][] mat){
        for(int[] row : mat){
            for(int n : row){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
}