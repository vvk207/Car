package ru.kostenko.springcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kostenko.springcourse.Car.Car;
import ru.kostenko.springcourse.dao.CarDao;

import java.util.List;

@Controller
public class CarController {

private final CarDao carDao;

 @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;

 }
    // список машин
    @GetMapping("/cars")
    public String getAllCars(Model model){
        List<Car> cars = carDao.getListCar();
        model.addAttribute("cars", cars);
        return "/cars-list";
    }

    // форма добавления машины
    @GetMapping("/car-create")
    public String getFormCars( Car car){
     return "car-create";
    }
    //добавляем машину
    @PostMapping("/car-create")
    public String getNewCar( Car car) {
    carDao.saveCar(car);
    return "redirect:/cars";


    //обновление машины
    }
    @GetMapping("/car-update/{id}")
    public String getFormUpdate(@PathVariable("id") Integer id, Model model){
    Car car = carDao.getCarById(id);
    model.addAttribute("car", car );
    return"/car-update";
    }
    @PostMapping("/car-update")
    public String getUpdateCar(Car car){
     carDao.saveCar(car);
     return "redirect:/cars";
    }



   // удаление машины
   @GetMapping("/car-delete/{id}")
   public String deleteCarById(@PathVariable("id") Integer id){
   carDao.deleteCarById(id);
   return"redirect:/cars";

   }

}
