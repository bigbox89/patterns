public class Main {
    public static void main(String[] args) {

        /*
        //тестовый код для провперки адаптера
        Adapter.MallardDuck duck = new Adapter.MallardDuck();
        Adapter.WildTUrkey turkey = new Adapter.WildTUrkey();
        Adapter.Duck turkeyAdapter = new Adapter.TurkeyAdapter(turkey);
        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        Adapter.testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        Adapter.testDuck(turkeyAdapter);

        //Заказываем кофе и наблюдаем за гибкой архитектурой, построенной на основе паттерна Декоратор.
         */

        /*
        Decorator.Beverage beverage = new Decorator.Espresso(); //эспрессо без дополнений, выводим описание и стоимость
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Decorator.Beverage beverage2 = new Decorator.DarkRoast();
        beverage2 = new Decorator.Mocha(beverage2);  //завораичваем в объект Mocha
        beverage2 = new Decorator.Mocha(beverage2); //второй раз
        beverage2 = new Decorator.Whip(beverage2);  //заворачиваем в Whip
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Decorator.Beverage beverage3 = new Decorator.HouseBlend(); //домашняя смесь с соей, шоколадом и взитыми сливками
        beverage3 = new Decorator.Soy(beverage3);
        beverage3 = new Decorator.Mocha(beverage3);
        beverage3 = new Decorator.Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
        */

        /*
        //используя ппатерн фасад, привязываем все действия системы к одному пульту
        Fasad.Amplifier amp = new Fasad.Amplifier();
        Fasad.Tuner tuner = new Fasad.Tuner();
        Fasad.DvdPlayer dvd = new Fasad.DvdPlayer();
        Fasad.CdPlayer cd = new Fasad.CdPlayer();
        Fasad.Projector projector = new Fasad.Projector();
        Fasad.Screen screen = new Fasad.Screen();
        Fasad.TheaterLights lights = new Fasad.TheaterLights();
        Fasad.PopcornPopper popper = new Fasad.PopcornPopper();
        //Создаем фасад со всеми компонентами подсистемы
        Fasad.HomeTheaterFacade homeTheater = new Fasad.HomeTheaterFacade(amp, tuner,dvd,cd,projector, screen, lights, popper);
        homeTheater.watchMovie("Matrix");   //Упрощенный интерфейс используется для запуска и для прекращения просмотра
        homeTheater.endMovie();
        */

        //тестируем компоновщика
        Componovshik.MenuComponent pancakeHouseMenu = new Componovshik.Menu("Pancake House Menu", "Breakfast");
        Componovshik.MenuComponent dinerMenu = new Componovshik.Menu("Diner Menu", "Lunch");
        Componovshik.MenuComponent cafeMenu = new Componovshik.Menu("Cafe Menu", "Dinner");
        Componovshik.MenuComponent dessertMenu = new Componovshik.Menu("Dessert Menu", "Dessert of course!");
        Componovshik.MenuComponent allMenus = new Componovshik.Menu("All Menus", "All Menus combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new Componovshik.MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89));
        dinerMenu.add(dessertMenu);

        dessertMenu.add(new Componovshik.MenuItem("Apple Pie","Apple pie with a flakey crust, topped with vanilla icecream",true,1.59));

        Componovshik.Waitress waitress = new Componovshik.Waitress(allMenus);
        waitress.printMenu();
    }
}

