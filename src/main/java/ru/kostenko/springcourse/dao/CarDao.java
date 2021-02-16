package ru.kostenko.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kostenko.springcourse.Car.Car;
import ru.kostenko.springcourse.Car.CarRepository;

import java.util.List;

@Service
public class CarDao {

    public CarRepository carRepository;

    @Autowired
    public CarDao(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getListCar(){
        return carRepository.findAll();

    }

    public Car getCarById( Integer id){
        return carRepository.getOne(id);
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public void deleteCarById (Integer id){
        carRepository.deleteById(id);
    }
}
