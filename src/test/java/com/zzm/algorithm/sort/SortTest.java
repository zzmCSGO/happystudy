package com.zzm.algorithm.sort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

/**
 * @Author:zzm
 * @Date:2024/8/31 13:01
 */
@RunWith(JUnit4.class)
public class SortTest {

    private int[] array = {1, 5, 6, 2, 3, 4};
    @Test
    public void testQuickSort() {
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    @Test
    public void testMergeSort() {
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testHeapSort() {
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }




    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right);
        quickSort(array, left, p - 1);
        quickSort(array, p + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int j;
        int i = j = left;
        while (j < right) {
            //遇到大的了，j动i不懂
            if (array[j] < pivot) {
                if (i != j) {
                    swap(array, i, j);
                }
                i++;
            }
            j++;
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void mergeSort(int[] array) {
        int[] res = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        mergeRecursion(array, left, right, res);
    }

    public void mergeRecursion(int[] array, int left, int right, int[] res) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeRecursion(array, left, mid, res);
        mergeRecursion(array, mid + 1, right, res);
        merge(array, left, mid, mid + 1, right, res);
        System.arraycopy(res, left, array, left, right - left + 1);
    }


    private void merge(int[] array, int i, int iEnd, int j, int jEnd, int[] res) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (array[i] < array[j]) {
                res[k] = array[i];
                i++;
            } else {
                res[k] = array[j];
                j++;
            }
            k++;
        }

        if (i > iEnd) {
            System.arraycopy(array, j, res, k, jEnd - j + 1);
        }

        if (j > jEnd) {
            System.arraycopy(array, i, res, k, iEnd - i + 1);
        }
    }

    public void heapSort(int[] array) {
        heapify(array, array.length);
        for (int right = array.length - 1; right >= 0; right--) {
            swap(array, 0, right);
            down(array, 0, right);
        }
    }

    private void heapify(int[] array, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            down(array, i, length);
        }
    }

    private void down(int[] array, int parent, int length) {
        while (true) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int max = parent;
            if (left < length && array[max] < array[left]) {
                max = left;
            }
            if (right < length && array[max] < array[right]) {
                max = right;
            }
            if (max == parent) {
                break;
            }
            swap(array, max, parent);
            parent = max;
        }
    }


}
