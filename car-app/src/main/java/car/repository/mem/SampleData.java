package car.repository.mem;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    static List<Car> cars = new ArrayList<>();
    static List<Brand> brands = new ArrayList<>();
    static List<Dealership> dealerships = new ArrayList<>();
    static{
        Brand toyota = new Brand(1,"Toyota","https://brand.toyota.com/content/dam/brandhub/guidelines/logo/four-column/BHUB_Logo_LogoFamily_01.svg");
        Brand ford = new Brand(2,"Ford","https://www.citypng.com/public/uploads/preview/ford-logo-emblem-hd-png-70175169471401511cpxj0ogw.png");
        Brand porsche = new Brand(3,"Porsche","https://1000logos.net/wp-content/uploads/2018/02/Porsche-Logo-500x281.png");
        Car yarris = new Car(1,"yarris",toyota,130000);
        Car rav = new Car(2,"rav4",toyota,140000);
        Car chr = new Car(3,"chr",toyota,150000);
        Car raptor = new Car(4,"raptor",ford,10000);
        Car mondeo = new Car(5,"mondeo",ford,9000);
        Car cortina = new Car(6,"cortina",ford,11000);
        Car macan = new Car(7,"macan",porsche,220000);
        Car taycan = new Car(8,"taycan",porsche,520000);
        bind(yarris, toyota);
        bind(rav, toyota);
        bind(chr, toyota);
        bind(raptor, ford);
        bind(mondeo, ford);
        bind(cortina, ford);
        bind(macan, porsche);
        bind(taycan, porsche);

        Dealership vcentrum = new Dealership(1,"vcentrum","https://www.vcentrum.pl/wp-content/uploads/2021/09/vcentrum-logo.png");
        Dealership eurocar = new Dealership(2,"eurocar","https://eurocar.pl/wp-content/uploads/2023/08/logo-euro-car.png");
        Dealership carmax = new Dealership(3,"carmax","https://1000logos.net/wp-content/uploads/2021/09/CarMax-Logo-500x281.png");
        bind(yarris, carmax);
        bind(chr, carmax);
        bind(rav, carmax);
        bind(raptor, eurocar);
        bind(mondeo, eurocar);
        bind(cortina, eurocar);
        bind(macan, eurocar);
        bind(taycan, eurocar);
        bind(macan, vcentrum);
        cars.add(yarris);
        cars.add(chr);
        cars.add(raptor);
        cars.add(mondeo);
        cars.add(cortina);
        cars.add(macan);
        cars.add(taycan);
        cars.add(rav);

        dealerships.add(vcentrum);
        dealerships.add(eurocar);
        dealerships.add(carmax);

        brands.add(toyota);
        brands.add(ford);
        brands.add(porsche);






    }
    private static void bind(Car c, Dealership d)
    {
        d.addCar(c);
        c.addDealership(d);

    }
    private static void bind(Car c, Brand b)
    {
        b.addCar(c);
        c.setBrand(b);
    }
}
