package de.bht.pr2.lab02.part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortingAlgorithmsTest {

  @Test
  void allSortAlgorithmsSortTheSameInput() {
    int[] input = {7, 2, 9, -1, 5, 2};
    int[] expected = {-1, 2, 2, 5, 7, 9};

    assertArrayEquals(expected, BubbleSort.sort(input.clone()));
    assertArrayEquals(expected, InsertionSort.sort(input.clone()));
    assertArrayEquals(expected, QuickSort.sort(input.clone()));
  }
}