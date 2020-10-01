package com.seokjin.kim.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MathAll {
    /**
     * 조합 케이스 nCr 획득
     */
    public static Set<String> getCombination( int n, int r ){
        Set<String> result = new LinkedHashSet<>();
        checkCombination( n, r, 0, result, "", 1);
        return result;
    }
    
    /**
     * 조합 케이스 nCr 획득
     */
    public static Set<String> getCombination( String[] n, int r ){
        Set<String> result = new LinkedHashSet<>();
        checkArrayCombination( n, r, 0, result, "", 0);
        return result;
    }
    
    /**
     * 표준편차 구하기
     * 표준편차 = 분산의 제곱근
     * 분산 = 편차 제곱의 합 / 총 변량의 개수
     */
    public static double standardDeviation( double[] array ){
        
        if (array.length < 2) return Double.NaN;
        
        double sum = 0.0;
        double sd = 0.0;
        double diff;
        double meanValue = mean(array);

        for (int i = 0; i < array.length; i++) {
          diff = array[i] - meanValue;
          sum += diff * diff;
        }
        sd = Math.sqrt(sum /array.length);

        return sd;
    }
    
    /**
     * 배열의 평균 구하기
     */
    public static double mean(double[] array) {  // 산술 평균 구하기
        double sum = 0.0;

        for (int i = 0; i < array.length; i++)
          sum += array[i];

        return sum / array.length;
      }
    
    /*
     * 종료 조건 : r개 뽑앗을 때,
     * return : void
     */
    private static void checkArrayCombination( String[] n, int r, int checking, Set<String> result, String next, int startIndex ) {
        if( checking == r ) {
            result.add(next);
            return;
        }
        for( int index = startIndex; index < n.length; index++ ) {
            String temp = next;
            temp += " " + n[index];
            temp = temp.trim();
            checkArrayCombination(n, r, checking+1, result, temp, index+1);
        }
    }

    /*
     * 종료 조건 : r개 뽑앗을 때,
     * return : void
     */
    private static void checkCombination( int n, int r, int checking, Set<String> result, String next, int startIndex ) {
        if( checking == r ) {
            result.add(next);
            return;
        }
        for( int index = startIndex; index <= n; index++ ) {
            String temp = next;
            temp += " " + index;
            temp = temp.trim();
            checkCombination(n, r, checking+1, result, temp, index+1);
        }
    }
}
