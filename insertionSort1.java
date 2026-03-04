//https://www.hackerrank.com/challenges/insertionsort1/problem?isFullScreen=true

public static <T> void printArr(List<T> arr) {
    System.out.println(arr.toString().replaceAll("[\\[\\],]", ""));
}

public static void insertionSort1(int n, List<Integer> arr) {
    int last = arr.get(n - 1);
    int i = n - 2;
    
    while (i >= 0 && arr.get(i) > last) {
        arr.set(i + 1, arr.get(i));
        printArr(arr);
        i--;
    }
    
    arr.set(i + 1, last);
    printArr(arr);
}
