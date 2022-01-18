public class Fasad
{
    public static class Amplifier{
        public void on() {
            System.out.println("Top-O-Line Amplifier on");
        }

        public void setDvd(DvdPlayer dvd) {
            System.out.println("Top-O-Line Amplifier setting DVD Player to" + dvd.toString());
        }

        public void setSurroundSound() {
            System.out.println("Top-O-Line Amplifier surround sound on (5 speakers, 1 subwoofer)");
        }

        public void setVolume(int i) {
            System.out.println("Top-O-Line Amplifier setting volume to "+i);
        }

        public void off() {
            System.out.println("Top-O-Line Amplifier off");
        }
    }
    public static class Tuner{}
    public static class DvdPlayer
    {
        @Override
        public String toString() {
            return "Top-O-Line DVD Player";
        }

        public void on() {
            System.out.println("Top-O-Line DVD Player on");
        }
        public void play(String movie)
        {
            System.out.println("Top-O-Line Amplifier playing "+ movie);
        }

        public void stop() {
            System.out.println("Top-O-Line DVD Player stopped");
        }

        public void eject() {
            System.out.println("Top-O-Line DVD Player eject");
        }

        public void off() {
            System.out.println("Top-O-Line DVD Player off");
        }
    }
    public static class CdPlayer{}
    public static class Projector{
        public void on() {
            System.out.println("Top-O-Line Projector on");

        }

        public void wideScreenMode() {
            System.out.println("Top-O-Line Projector in widescreen mode (16x9 aspect ratio");
        }

        public void off() {
            System.out.println("Top-O-Line Projector off");
        }
    }
    public static class TheaterLights{
        public void dim(int i)
        {
            System.out.println("THeater Ceiling Lights dimming to " + i + "%");
        }

        public void on() {
            System.out.println("Theater Ceiling Lights on");
        }
    }
    public static class Screen{
        public void down() {
            System.out.println("Theater Screen going down");
        }

        public void up() {
            System.out.println("Theater Screen going up");
        }
    }
    public static class PopcornPopper{
        

        public void on() {
            System.out.println("Popcorn Popper on");
        }

        public void pop() {
            System.out.println("Popper popping popcorn!");
        }

        public void off() {
            System.out.println("Popcorn Popper off");
        }
    }

    //надо сделать единый пульт ууправления всеми устройствами, чтобы удобно смотреть фильм

    public static class HomeTheaterFacade
    {
        Amplifier amp;      //композиция: компоненты подсистемы, которые мы собираемся использовать.
        Tuner tuner;
        DvdPlayer dvd;
        CdPlayer cd;
        Projector projector;
        TheaterLights lights;
        Screen screen;
        PopcornPopper popper;

        //в констуркторе фасада передаются ссылки на все компоненты. Фасад присваивает их соответсвующим переменным экземпляра.
        public HomeTheaterFacade (Amplifier amp, Tuner tuner, DvdPlayer dvd, CdPlayer cd, Projector projector, Screen screen, TheaterLights lights, PopcornPopper popper)
        {
            this.amp = amp;
            this.tuner = tuner;
            this.dvd = dvd;
            this.cd = cd;
            this.projector = projector;
            this.screen = screen;
            this.lights = lights;
            this.popper = popper;
        }

        //сводим компоненты подсистемы в единый интерфейс. Начнем с методов watchMovie() и endMovie();
        public void watchMovie(String movie)
        {
            System.out.println("Get ready to watch a movie...");
            popper.on();
            popper.pop();
            lights.dim(10);
            screen.down();
            projector.on();
            projector.wideScreenMode();
            amp.on();
            amp.setDvd(dvd);
            amp.setSurroundSound();
            amp.setVolume(5);
            dvd.on();
            dvd.play(movie);
        }
        
        public void endMovie() {
            System.out.println("Shutting movie theater down...");
            popper.off();
            lights.on();
            screen.up();
            projector.off();
            amp.off();
            dvd.stop();
            dvd.eject();
            dvd.off();
        }
    }
}
