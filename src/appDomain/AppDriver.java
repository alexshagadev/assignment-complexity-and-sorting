package appDomain;

import shapes.*;
import utilities.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Comparator;

public class AppDriver {

    public static void main(String[] args) {
        String filePath = null;
        String sortBy = null;
        String sortMethod = null; 
        
        // Loop through args
        for (String arg : args) {
        	// Example: -fres/shapes3.txt -Tv -Sb
        	// currently extra spaces break everything ¯\_(ツ)_/¯
            String lowerCase = arg.toLowerCase();

            if (lowerCase.startsWith("-f")) {
                filePath = arg.substring(2);
            } else if (lowerCase.startsWith("-t")) {
                sortBy = arg.substring(2);
            } else if (lowerCase.startsWith("-s")) {
                sortMethod = arg.substring(2);
            } else {
                return;
            }
        }

        // Declare shapes array
        Prism[] shapesArray = null;

        // Read the shapes from the txt file
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            
            // Check number of shapes
            int numOfShapes = Integer.parseInt(scanner.nextLine()); 
            // Define shapes array
            shapesArray = new Prism[numOfShapes];

            for (int i = 0; i < numOfShapes; i++) {
                String shapeLine = scanner.nextLine();
                String[] shapeData = shapeLine.split(" ");

                // Create shapes & populate array
                switch (shapeData[0]) {
                    case "Cylinder":
                        double cylinderHeight = Double.parseDouble(shapeData[1]);
                        double cylinderRadius = Double.parseDouble(shapeData[2]);
                        shapesArray[i] = new Cylinder(cylinderHeight, cylinderRadius);
                        break;
                    case "Cone":
                        double coneHeight = Double.parseDouble(shapeData[1]);
                        double coneRadius = Double.parseDouble(shapeData[2]);
                        shapesArray[i] = new Cone(coneHeight, coneRadius);
                        break;
                    case "Pyramid":
                        double pyramidHeight = Double.parseDouble(shapeData[1]);
                        double pyramidEdge = Double.parseDouble(shapeData[2]);
                        shapesArray[i] = new Pyramid(pyramidHeight, pyramidEdge);
                        break;
                    case "SquarePrism":
                        double squareHeight = Double.parseDouble(shapeData[1]);
                        double squareEdge = Double.parseDouble(shapeData[2]);
                        shapesArray[i] = new SquarePrism(squareHeight, squareEdge);
                        break;
                    case "TriangularPrism":
                        double triangleHeight = Double.parseDouble(shapeData[1]);
                        double triangleEdge = Double.parseDouble(shapeData[2]);
                        shapesArray[i] = new TriangularPrism(triangleHeight, triangleEdge);
                        break;
                    case "PentagonalPrism":
                        double pentagonHeight = Double.parseDouble(shapeData[1]);
                        double pentagonEdge = Double.parseDouble(shapeData[2]);
                        shapesArray[i] = new PentagonalPrism(pentagonHeight, pentagonEdge);
                        break;
                    case "OctagonalPrism":
                        double octagonHeight = Double.parseDouble(shapeData[1]);
                        double octagonEdge = Double.parseDouble(shapeData[2]);
                        shapesArray[i] = new OctagonalPrism(octagonHeight, octagonEdge);
                        break;
                    default:
                        break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } 

        // Sort the shapes
        if (shapesArray != null) {
            Comparator<Prism> comparator = null;

            // Match comparator with sort type
            switch (sortBy) {
                case "v":
                    comparator = new Prism.VolumeComparator();
                    break;
                case "h":
                	// height is natural order
                    comparator = null; 
                    break;
                case "a":
                    comparator = new Prism.BaseAreaComparator();
                    break;
                default:
                    System.out.println("Invalid sort type");
                    return;
            }

            // Measure how long it takes to run the algorithm
            long startTime = System.nanoTime();
            
            // Call sort function based on user input
            switch (sortMethod) {
                case "b":
                    // bubble sort
                    break;
                case "s":
                    // selection sort
                    break;
                case "i":
                    // insertion sort
                    break;
                case "m":
                    // merge sort
                    break;
                case "q":
                	QuickSort.sort(shapesArray, comparator);
                    break;
                case "h":
                	HeapSort.sort(shapesArray, comparator);
                	break;
                default:
                    System.out.println("Invalid sorting method");
                    return;
            }
            
            // Stop measuring the time
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // divide by 1 million to get milliseconds

            // Display the sorted array
            displayResults(shapesArray, sortBy);
            
            // Print out the run time for the sorting algorithm (currently only for merge sort)
            System.out.println("m run time was: " + duration + " milliseconds");
        }
    }
    
    private static void displayResults(Prism[] shapesArray, String sortBy) {
        // Display the results to the user
        if (shapesArray.length > 0) {
            // Display the first element
            if ("v".equals(sortBy)) {
                System.out.printf("First element is: The polygons.%s has a Volume of: %.16E%n", shapesArray[0].getClass().getSimpleName(), shapesArray[0].calcVolume());
            } else if ("h".equals(sortBy)) {
                // Display height without rounding
                System.out.printf("First element is: The polygons.%s has a Height of: %s%n", shapesArray[0].getClass().getSimpleName(), shapesArray[0].getHeight());
            } else if ("a".equals(sortBy)) {
                System.out.printf("First element is: The polygons.%s has a Base Area of: %.16E%n", shapesArray[0].getClass().getSimpleName(), shapesArray[0].calcBaseArea());
            }

            // Display every thousandth element
            for (int i = 1000; i < shapesArray.length; i += 1000) {
                if ("v".equals(sortBy)) {
                    System.out.printf(i + "th element is: The polygons.%s has a Volume of: %.16E%n", shapesArray[i].getClass().getSimpleName(), shapesArray[i].calcVolume());
                } else if ("h".equals(sortBy)) {
                    // Display height without rounding
                    System.out.printf(i + "th element is: The polygons.%s has a Height of: %s%n", shapesArray[i].getClass().getSimpleName(), shapesArray[i].getHeight());
                } else if ("a".equals(sortBy)) {
                    System.out.printf(i + "th element is: The polygons.%s has a Base Area of: %.16E%n", shapesArray[i].getClass().getSimpleName(), shapesArray[i].calcBaseArea());
                }
            }

            // Display the second last element
            if (shapesArray.length > 1) {
                if ("v".equals(sortBy)) {
                    System.out.printf("Second last element is: The polygons.%s has a Volume of: %.16E%n", shapesArray[shapesArray.length - 2].getClass().getSimpleName(), shapesArray[shapesArray.length - 2].calcVolume());
                } else if ("h".equals(sortBy)) {
                    // Heights don't need to be rounded because they're not big
                    System.out.printf("Second last element is: The polygons.%s has a Height of: %s%n", shapesArray[shapesArray.length - 2].getClass().getSimpleName(), shapesArray[shapesArray.length - 2].getHeight());
                } else if ("a".equals(sortBy)) {
                    System.out.printf("Second last element is: The polygons.%s has a Base Area of: %.16E%n", shapesArray[shapesArray.length - 2].getClass().getSimpleName(), shapesArray[shapesArray.length - 2].calcBaseArea());
                }
            }

            // And finally the last element
            if ("v".equals(sortBy)) {
                System.out.printf("Last element is: The polygons.%s has a Volume of: %.16E%n", shapesArray[shapesArray.length - 1].getClass().getSimpleName(), shapesArray[shapesArray.length - 1].calcVolume());
            } else if ("h".equals(sortBy)) {
                System.out.printf("Last element is: The polygons.%s has a Height of: %s%n", shapesArray[shapesArray.length - 1].getClass().getSimpleName(), shapesArray[shapesArray.length - 1].getHeight());
            } else if ("a".equals(sortBy)) {
                System.out.printf("Last element is: The polygons.%s has a Base Area of: %.16E%n", shapesArray[shapesArray.length - 1].getClass().getSimpleName(), shapesArray[shapesArray.length - 1].calcBaseArea());
            }
        }
    }

}
