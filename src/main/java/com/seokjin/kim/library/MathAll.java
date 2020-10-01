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
