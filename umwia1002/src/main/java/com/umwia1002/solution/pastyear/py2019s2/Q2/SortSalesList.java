package com.umwia1002.solution.pastyear.py2019s2.Q2;

public class SortSalesList {
    public static void main(String[] args) {
        SalesList[] dataList = {
                new SalesList("Asia", 450, "Ahmad"),
                new SalesList("Europe", 518, "Hemish"),
                new SalesList("Europe", 650, "Banny"),
                new SalesList("Greenland", 200, "Ain"),
                new SalesList("Asia", 390, "Ali"),
                new SalesList("Greenland", 670, "Ben"),
                new SalesList("Asia", 790, "Lee"),
        };

        System.out.println("Original Data:");
        for(SalesList e : dataList) {
            System.out.println(e);
        }

        System.out.println("Sorting Result on Region using SelectionSort:");
        selectionSortRegion(dataList);
        for(SalesList e : dataList) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Sorting Result on Sales using InsertionSort:");
        insertionSortAmount(dataList);
        for(SalesList e : dataList) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Sorting Result on SalesRep using BubbleSort:");
        bubbleSortRepresentative(dataList);
        for(SalesList e : dataList) {
            System.out.println(e);
        }
        System.out.println();

        
    }

    public static void selectionSortRegion(SalesList[] list) {
        int n = list.length;
        for (int i = 0; i < n; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list[j].region.compareTo(list[maxIndex].region) > 0) {
                    maxIndex = j;
                }
            }
            
            SalesList tmp = list[i];
            list[i] = list[maxIndex];
            list[maxIndex] = tmp;
        }
    }

    public static void insertionSortAmount(SalesList[] list) {
        int n = list.length;
        for(int i = 1; i < n; i++) {
            SalesList key = list[i];
            int j = i - 1;
            
            while(j >= 0 && list[j].salesAmount.compareTo(key.salesAmount) > 0) {
                list[j + 1] = list[j];
                j--;
            }

            list[j + 1] = key;
        }
    }

    public static void bubbleSortRepresentative(SalesList[] list) {
        int n = list.length;
        for(int i = 0; i < n; i++) {
            boolean hasSwap = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(list[j].salesRepresentative.compareTo(list[j + 1].salesRepresentative) > 0) {
                    SalesList tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                    hasSwap = true;
                }
            }

            if(!hasSwap) break;
        }
    }
}
