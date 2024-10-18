# Shape Sorting and Benchmarking Program

This program reads geometric shape data from a file, creates shape objects, sorts them using various sorting algorithms, displays the results, and benchmarks the efficiency of each algorithm.

## Features

- _Shape Types_: Supports sorting for different 3D shapes:
  - Cylinders
  - Cones
  - Pyramids
  - Prisms
- _Sorting Criteria_: Sort shapes by:

  - Height
  - Volume
  - Base Area

- _Sorting Algorithms_:

  - Bubble Sort
  - Insertion Sort
  - Selection Sort
  - Merge Sort
  - Quick Sort
  - Heap Sort

- _Benchmarking_:
  - Compares the efficiency of the sorting algorithms by measuring sorting time in milliseconds.
  - Sorting algorithms are separated from the benchmarking logic for modularity.

## Command Line Usage

To run the program, the user will indicate the following using the specified formats with no spaces:

- The file containing the shape data:
  "-f" or "-F" followed by the file name.
- The property to sort by (height, volume, or base area).
  "-t" or "-T" followed by "v" for Volume, "h" for Height, or "a" for Base Area.
- The sorting algorithm to use.
  "-s" or "-S" followed by "b" for Bubble, "s" for Selection, "i" for Insertion, "m" for Merge, "q" for Quick, or "h" for Heap.

### Example Command:

```bash
java -jar Sort.jar -ffile_name -tv -sb
```

-This will open the "file_name" file and use a bubble sort to sort the volumes of the elements.
