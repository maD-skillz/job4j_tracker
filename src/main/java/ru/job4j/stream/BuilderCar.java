package ru.job4j.stream;

public class BuilderCar {
    private String name;

    private String model;

    private int year;

    private int maxSpeed;

    private int range;

    private boolean insurance;

    static class Builder {
        private String name;
        private String model;
        private int year;
        private int maxSpeed;
        private int range;
        private boolean insurance;

        Builder builderName(String name) {
            this.name = name;
            return this;
        }

        Builder builderModel(String model) {
            this.model = model;
            return this;
        }

        Builder builderYear(int year) {
            this.year = year;
            return this;
        }

        Builder builderMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder builderRange(int range) {
            this.range = range;
            return this;
        }

        Builder builderInsurance(boolean insurance) {
            this.insurance = insurance;
            return this;
        }

        BuilderCar build() {
            BuilderCar builderCar = new BuilderCar();
            builderCar.name = name;
            builderCar.model = model;
            builderCar.year = year;
            builderCar.maxSpeed = maxSpeed;
            builderCar.range = range;
            builderCar.insurance = insurance;
            return builderCar;
        }
    }

    public static void main(String[] args) {
        BuilderCar builderCar = new Builder().builderName("Chevrolet")
                .builderModel("Camaro")
                .builderYear(1999)
                .builderMaxSpeed(250)
                .builderRange(500)
                .builderInsurance(true)
                .build();
        System.out.println(builderCar);
    }

    @Override
    public String toString() {
        return "BuilderCar{"
                + "name='"
                + name + '\''
                + ", model='"
                + model + '\''
                + ", year="
                + year
                + ", maxSpeed="
                + maxSpeed
                + ", range="
                + range
                + ", insurance="
                + insurance
                + '}';
    }
}

