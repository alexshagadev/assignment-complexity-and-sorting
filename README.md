# Shape Sorting and Benchmarking Program

This program reads geometric shape data from a file, creates shape objects, sorts them using various sorting algorithms, displays the results, and benchmarks the efficiency of each algorithm.

## Features
- *Shape Types*: Supports sorting for different 3D shapes:
  - Cylinders
  - Cones
  - Pyramids
  - Prisms
  
- *Sorting Criteria*: Sort shapes by:
  - Height
  - Volume
  - Base Area

- *Sorting Algorithms*:
  - Bubble Sort
  - Insertion Sort
  - Selection Sort
  - Merge Sort
  - Quick Sort
  - Custom algorithm

- *Benchmarking*: 
  - Compares the efficiency of the sorting algorithms by measuring sorting time in milliseconds.
  - Sorting algorithms are separated from the benchmarking logic for modularity.

## Command Line Usage

To run the program, the user will specify:
- The file containing the shape data.
- The sorting algorithm to use.
- The property to sort by (height, volume, or base area).

### Example Command:
```bash
java -jar Sort.jar -ffile_name -tv -sb