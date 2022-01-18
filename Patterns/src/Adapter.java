public class Adapter     // создадим адаптер для индюшек, которые смогут вести себя как утки
{
    public interface Duck {     //наши утки будут реализовывать интерфейс Duck
        void quack();
        void fly();
    }

    // конкретный подкласс Duck
    public static class MallardDuck implements Duck
    {
        @Override
        public void quack() {
            System.out.println("Quack");
        }

        @Override
        public void fly() {
            System.out.println("I'm flying");
        }
    }

    //интерфейс индюшки
    public interface Turkey {
        void gobble();  //индюшки не крякают (у них нет метода quack())...
        void fly();  //но могут летать, НО недолго!
    }

    //Конкретная реализация обощенного класса Turkey
    public static class WildTUrkey implements Turkey {
        @Override
        public void gobble() {
            System.out.println("Gobble gobble");
        }

        @Override
        public void fly() {
            System.out.println("I'm flying a short distance");
        }
    }

    //Нам не хватает объектов Duck и мы хотим использовать вместо них объекты Turkey.
    //Создаем адаптер для индюшек
    public static class TurkeyAdapter implements Duck {   //реализуем интерфейс того же типа, на который расчитан клиент
        Turkey turkey;

        public TurkeyAdapter(Turkey turkey)     //Получаем ссылку на адаптируемый объект, обычно это делается в конструкторе
        {
            this.turkey = turkey;
        }

        @Override
        public void quack() {       //адаптер должен реализвать все методы интерфейса. Преобраование quack() - реализация gobble
            turkey.gobble();
        }

        @Override
        public void fly() {  //индюшка не умеет летать на дальние расстояния.
            for (int i = 0; i < 5; i++) {
                turkey.fly();  //чтобы установить соответствие между этими методами, вызываем fly() класса Turkey 5 раз
            }
        }
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

}
