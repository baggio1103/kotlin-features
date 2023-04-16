package airplane;

import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Airplane {

    private final Logger logger = Logger.getLogger(Airplane.class);

    private final long propellerSpeed;

    private final long cameraSpeed;

    private final Lock lock = new ReentrantLock();

    private final AtomicBoolean closed = new AtomicBoolean(true);

    private final Condition condition = lock.newCondition();

    public Airplane(long propellerSpeed, long cameraSpeed) {
        this.propellerSpeed = propellerSpeed;
        this.cameraSpeed = cameraSpeed;
    }

    public void engineWorkProcess() throws InterruptedException {
        try {
            lock.lock();
            while (true) {
                if (closed.get()) {
                    logger.info("Closed");
                    Thread.sleep(1000 * (1 / propellerSpeed));
                    logger.info("Opened");
                    closed.set(false);
                    condition.await();
                } else {
                    closed.set(true);
                    condition.signal();
                }
            }
        } finally {
            lock.lock();
        }
    }

    public void cameraWorkProcess() throws InterruptedException {
        try {
            lock.lock();
            while (true) {
                if (!closed.get()) {
                    for (int i = 0; i < cameraSpeed; i++) {
                        logger.info("Taking photos");
                    }
                    Thread.sleep(1000);
                    condition.signal();
                    condition.await();
                }
            }
        } finally {
            lock.lock();
        }
    }

}
