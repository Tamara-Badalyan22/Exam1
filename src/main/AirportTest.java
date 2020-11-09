package main;

import model.Plane;
import service.PlaneService;

public class AirportTest {
    public static void main(String[] args) {
        PlaneService service = new PlaneService();
        //Task1
        service.printInfo(service.create());

        Plane plane1 = service.create();
        Plane plane2 = service.create();
        Plane plane3 = service.create();

        Plane[] planes = {plane1, plane2, plane3};

        System.out.println("------All planes----");
        service.printInfoOfPlanes(planes);

        service.isMilitary(plane1);

        service.newestPlane(plane1, plane2);

        service.planeWithBiggerWingspan(plane1, plane2);

        service.highestCostPlane(plane1, plane2, plane3);

        service.smallestSeatsPlane(plane1, plane2, plane3);

        service.allNotMilitaryPlanes(planes);

        service.allMilitaryPlanes(planes);

        service.minimalWeightPlane(planes);

        service.minimalCostPlane(planes);

        service.orderByYear(planes);

        service.orderByDescSeats(planes);

    }
}
