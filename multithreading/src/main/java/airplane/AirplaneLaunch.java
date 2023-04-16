package airplane;

public class AirplaneLaunch {

    public static void main(String[] args) throws InterruptedException {
        var airplane = new Airplane(1, 1);
        var camera = new Thread(() -> {
            try {
                airplane.cameraWorkProcess();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "camera");
        var propeller = new Thread(() -> {
            try {
                airplane.engineWorkProcess();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "propeller");
        propeller.start();
        Thread.sleep(1000);
        camera.start();
    }

}
