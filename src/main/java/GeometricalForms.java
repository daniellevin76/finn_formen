

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class GeometricalForms {



    String figure;
    public String determineShape(ArrayList<double[]> points) {



       

        List<double[]> distinctPoints = removeDuplicates(points);

        try {
            switch (distinctPoints.size()) {
                case 0:
                    figure = "None";
                    break;

                case 1:
                    figure = "Point";
                    break;

                case 2:
                    figure = "Line";
                    break;

                case 3:
                    figure = determineTriangleShape(points);
                    break;

                case 4:
                    figure = determineRectangleShape(points);
                    break;

            }
            return figure;


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "None";
    }

    private String determineRectangleShape(ArrayList<double[]> points) {
        DistanceCalculator distancesCalculator = new DistanceCalculator(points);
        distancesCalculator.calculateDistanceBetweenPoints(points);
        return null;
    }




    private String determineTriangleShape(ArrayList<double[]> points) {

        String triangle = "Triangle";

        double[] v = {0.0,0.0,0.0};
        //Add the first point at the end of point array to be able to take the
        //difference between the last point and the first point
        points.add(points.get(0));

     double[] distances =  {0.0,0.0,0.0};

        for(int j=0; j<points.size()-1; j++){

            for(int i = 0; i < points.get(j).length; i++) {
                double p = Math.sqrt(Math.abs(points.get(j)[i] - points.get(j+1)[i]));
                v[i] = p;

            }
            distances[j] = (Math.sqrt(Arrays.stream(v).sum()));
            }


        if((distances[0]==distances[1]) && (distances[1]==distances[2]) && (distances[2]==distances[0])){

            triangle = "Equilateral Triangle";

        } else if((distances[0]==distances[1]) || (distances[1]==distances[2]) || (distances[2]==distances[0])){
            triangle = "Isosceles Triangle";

        }

        return triangle;
    }

    private List<double[]> removeDuplicates(ArrayList<double[]> points) {

        try {return points.stream()
                .distinct()
                .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}

