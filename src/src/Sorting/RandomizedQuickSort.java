package Sorting;
import java.util.Random;

public class RandomizedQuickSort {



        // Function to partition the array
        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    // Swapping arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Swapping arr[i+1] and arr[high] (pivot)
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }

        // Function to perform random partition
        private static int randomPartition(int[] arr, int low, int high) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(high - low + 1) + low;
            // Swapping the randomly selected pivot with the last element
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[high];
            arr[high] = temp;
            return partition(arr, low, high);
        }

        // Function to perform Quick Sort
        private static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = randomPartition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        // Utility function to print an array
        private static void printArray(int[] arr) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // Main method to test the Quick Sort algorithm
        public static void main(String[] args) {
            int[] arr = {34,23,67,567,8,6,4,8,53,6,32};
            System.out.println("Original array:");
            printArray(arr);

            quickSort(arr, 0, arr.length - 1);

            System.out.println("Sorted array:");
            printArray(arr);
        }
    }


