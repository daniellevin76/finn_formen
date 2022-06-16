
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeometricalFormsTest {
    GeometricalForms geometricalForms;

    @BeforeEach
    void setup(){
        geometricalForms = new GeometricalForms();
    }

    @Test
    void should_returnNone_when_NullIsGiven(){
        assertEquals("None", geometricalForms.determineShape(null));
    }

    @Test
    void should_returnPoint_when_onePointIsGiven(){

        double[] point = {1.0, 2.0, 3.0};
        ArrayList<double []> points = new ArrayList<>();
        points.add(point);

        assertEquals("Point", geometricalForms.determineShape(points));
    }


    @Test
    void should_returnLine_when_twoPointsAreGiven(){

        double[] p1 = {1.0, 2.0, 3.0};
        double[] p2 = {1.0,4.0,5.0};
        ArrayList<double []> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);

        assertEquals("Line", geometricalForms.determineShape(points));
    }

    @Test
    void should_returnAPoint_when_twoPointsAreIdentical(){

        double[] p1 = {1.0, 2.0,3.0};
        double[] p2 = {1.0,2.0,3.0};
        ArrayList<double []> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);

        assertEquals("Line", geometricalForms.determineShape(points));
    }

    @Test
    void should_returnATriangle_when_threePointsAreGiven(){

        double[] p1 = {1.0, 2.0,3.0};
        double[] p2 = {2.0,5.0,3.0};
        double[] p3 = {2.0,5.0,5.0};
        ArrayList<double []> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);

        assertEquals("Triangle", geometricalForms.determineShape(points));
    }

    @Test
    void should_returnAnIsoscelesTriangle_when_threePointsAreGivenTwoEquidistant(){

        double[] p1 = {0.0,0.0,1.0};
        double[] p2 = {0.0,1.0,0.0};
        double[] p3 = {0.0,0.0,0.0};
        ArrayList<double []> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);

        assertEquals("Isosceles Triangle", geometricalForms.determineShape(points));
    }

    @Test
    void should_returnAnEquilateralTriangle_when_threeEquidistantPointsAreGiven(){

        double[] p1 = {1.0,0.0,0.0};
        double[] p2 = {0.0,1.0,0.0};
        double[] p3 = {0.0,0.0,1.0};
        ArrayList<double []> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);

        assertEquals("Equilateral Triangle", geometricalForms.determineShape(points));
    }

    @Test
    void should_returnARectangle_when_FourPointsAreGiven(){

        double[] p1 = {1.0,9.0,5.0};
        double[] p2 = {6.0,1.0,2.0};
        double[] p3 = {1.0,3.0,1.0};
        double[] p4 = {5.0,4.0,1.0};
        ArrayList<double []> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        assertEquals("Rectangle", geometricalForms.determineShape(points));
    }

    @Test
    void should_returnARectangle_when_FourPointsAreGivenTwoPointsIdentical(){

        double[] p1 = {1.0,9.0,5.0};
        double[] p2 = {6.0,1.0,2.0};
        double[] p3 = {1.0,9.0,5.0};
        double[] p4 = {5.0,4.0,1.0};
        ArrayList<double []> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        assertEquals("Triangle", geometricalForms.determineShape(points));
    }

}

