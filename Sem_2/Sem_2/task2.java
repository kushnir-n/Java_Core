package Sem_2;

// Написать функцию, возвращающую истину, если в переданном целочисленном массиве есть два соседних элемента, с нулевым значением.

public class task2 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 4};
        System.out.println(hasZeroNeighbors(arr));
        
    }

    public static boolean hasZeroNeighbors(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }

        return false;
    }

}



