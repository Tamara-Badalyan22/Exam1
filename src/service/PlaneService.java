package service;

import model.Plane;

import java.util.Scanner;

public class PlaneService {
    public Plane create() {
        System.out.println("----Create Plane-----");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter model : ");
        String model = s.next();
        System.out.println("Enter Country : ");
        String country = s.next();
        System.out.println("Enter year : ");
        int year = s.nextInt();
        if (year <= 1903 || year >= 2020)
            year = 1904;
        System.out.println("Enter hours : ");
        int hours = s.nextInt();
        if (hours <= 0 || hours >= 10000)
            hours = 100;
        System.out.println("Is military? : ");
        boolean military = s.nextBoolean();
        System.out.println("Engine type : ");
        String engineType = s.next();
        System.out.println("Enter weight : ");
        int weight = s.nextInt();
        if (weight <= 1000 || weight >= 160000)
            weight = 2000;
        System.out.println("Enter wingspan : ");
        int wingspan = s.nextInt();
        if (wingspan <= 10 || wingspan >= 45)
            wingspan = 20;
        System.out.println("Enter topSpeed : ");
        int topSpeed = s.nextInt();
        if (topSpeed < 0)
            topSpeed = 1000;
        System.out.println("Enter seats : ");
        int seats = s.nextInt();
        if(seats<0)
            seats=10;
        System.out.println("Enter cost : ");
        double cost = s.nextDouble();
        return new Plane(model, country, year, hours, military, engineType, weight, wingspan, topSpeed, seats, cost);
    }

    //Task1
    public void printInfo(Plane plane) {
        System.out.println("----Information about plane----");
        String model = plane.getModel();
        System.out.println("Model : " + model);
        String country = plane.getCountry();
        System.out.println("Country : " + country);
        int year = plane.getYear();
        System.out.println("Year : " + year);
        int hours = plane.getHours();
        System.out.println("Hours : " + hours);
        boolean isMilitary = plane.isMilitary();
        System.out.println("Military : " + isMilitary);
        String engineType = plane.getEngineType();
        System.out.println("EngineType : " + engineType);
        int weight = plane.getWeight();
        System.out.println("Weight : " + weight);
        int wingSpan = plane.getWingspan();
        System.out.println("Wingspan : " + wingSpan);
        int topSpeed = plane.getTopSpeed();
        System.out.println("TopSpeed : " + topSpeed);
        int seats = plane.getSeats();
        System.out.println("Seats : " + seats);
        double cost = plane.getCost();
        System.out.println("Cost : " + cost);
        System.out.println("-----------------------");
    }

    public void printInfoOfPlanes(Plane[] planes) {
        for (Plane item : planes) {
            printInfo(item);
        }
    }

    //Task2
    public void isMilitary(Plane plane) {
        if (plane.isMilitary() == true) {
            double cost = plane.getCost();
            System.out.println("Cost : " + cost);
            int topSpeed = plane.getTopSpeed();
            System.out.println("TopSpeed : " + topSpeed);
        } else {
            String model = plane.getModel();
            System.out.println("Model : " + model);
            String country = plane.getCountry();
            System.out.println("Country : " + country);
        }
    }

    //Task3
    public String newestPlane(Plane plane1, Plane plane2) {
        if (plane1.getYear() >= plane2.getYear())
            return plane1.getModel();
        return plane2.getModel();
    }

    //Task4
    public String planeWithBiggerWingspan(Plane plane1, Plane plane2) {
        if (plane1.getWingspan() <= plane2.getWingspan())
            return plane1.getModel();
        return plane2.getModel();
    }

    //Task5
    public Plane highestCostPlane(Plane p1, Plane p2, Plane p3) {
        if (p1.getCost() >= p2.getCost() && p1.getCost() >= p3.getCost())
            return p1;
        if (p2.getCost() > p3.getCost())
            return p2;
        return p3;
    }

    //Task6
    public void smallestSeatsPlane(Plane p1, Plane p2, Plane p3) {
        String country1 = p1.getCountry();
        String country2 = p2.getCountry();
        String country3 = p3.getCountry();
        if (p1.getCost() >= p2.getCost() && p1.getCost() >= p3.getCost())
            System.out.println("Country " + p1);
        else if (p2.getCost() > p3.getCost())
            System.out.println("Country " + p2);
        else
            System.out.println("Country " + p3);
    }

    //Task7
    public void allNotMilitaryPlanes(Plane[] planes) {
        for (Plane item : planes) {
            if (item.isMilitary() == false)
                printInfo(item);
        }
    }

    //Task8
    public void allMilitaryPlanes(Plane[] planes) {
        for (Plane item : planes) {
            if (item.isMilitary() == true && item.getHours() > 100)
                printInfo(item);
        }
    }

    //Task9
    public Plane minimalWeightPlane(Plane[] planes) {
        for (int i = 0; i < planes.length - 1; i++) {
            for (int j = 0; j < planes.length - 1 - i; j++) {
                if (planes[j].getWeight() > planes[j + 1].getWeight()) {
                    Plane tmp = planes[j];
                    planes[j] = planes[j + 1];
                    planes[j + 1] = tmp;
                }
            }
        }
        return planes[0];
    }

    //Task10
    public Plane minimalCostPlane(Plane[] planes) {
        for (int i = 0; i < planes.length - 1; i++) {
            for (int j = 0; j < planes.length - 1 - i; j++) {
                if (planes[j].getCost() > planes[j + 1].getCost()) {
                    Plane tmp = planes[j];
                    planes[j] = planes[j + 1];
                    planes[j + 1] = tmp;
                }
            }
        }
        return planes[0];
    }

    //Task11
    public void orderByYear(Plane[] planes) {
        for (int i = 0; i < planes.length - 1; i++) {
            for (int j = 0; j < planes.length - 1 - i; j++) {
                if (planes[j].getYear() > planes[j + 1].getYear()) {
                    Plane tmp = planes[j];
                    planes[j] = planes[j + 1];
                    planes[j + 1] = tmp;
                }
            }
        }
        printInfoOfPlanes(planes);
    }

    //Task12
    public void NonMilitary(Plane[] planes) {
        int count = 0;
        for (Plane item : planes) {
            if (item.isMilitary() == false)
                printInfo(item);
        }
    }

    public void orderByDescSeats(Plane[] planes) {
        for (int i = 0; i < planes.length - 1; i++) {
            for (int j = 0; j < planes.length - 1 - i; j++) {
                if (planes[j].getSeats() < planes[j + 1].getSeats()) {
                    Plane tmp = planes[j];
                    planes[j] = planes[j + 1];
                    planes[j + 1] = tmp;
                }
            }
        }
        NonMilitary(planes);
    }
}
