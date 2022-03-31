package com.ibs.reactive.flux;

import reactor.core.publisher.Flux;

import java.util.List;

//Java 15 feature to represent model object
//record  Employee (int id,String name) {
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class FluxAndDataSources {
    public static void main(String[] args) {
//        getSequence();
//        getMoreSequence();
        //getListSequence();
//        getArraySequence();
        getEmployeList();
    }

    private static void getEmployeList() {
        List<Employee> employeeList = List.of(new Employee(1, "A1"), new Employee(1, "A2"));
        Flux.fromIterable(employeeList).subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));

    }

    private static void getArraySequence() {
        Integer[] list = {80, 78, 90, 56};
        Flux.fromArray(list).subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    private static void getListSequence() {
        List<Integer> integerList = List.of(10, 78, 67, 80, 89);
        Flux.fromIterable(integerList).subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    //List as sequence
    private static void getMoreSequence() {
        Flux.range(1, 100)
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    private static void getSequence() {
        Flux.just(1, 2, 3, 4, 5, 6, 7, 9, 10)
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }
}


