package src.thread;

class Rabbit implements Runnable {
    private  static int distance = 50;
    private Race race;

    public Rabbit(Race race) {
        this.race = race;
    }

    @Override
    public void run() {
        while (distance > 0 && !race.isFinished()) {
            distance -= 10;

            if (distance <=0) {
                race.setWinner("兔子");
                System.out.println("兔子赢了比赛！");
                race.setFinished(true);
                break;
            }
            if (distance<race.getToisePosition()){
                System.out.println("兔子领先");
            }
            System.out.println("兔子距离终点: " + distance);
            if (distance < race.getToisePosition()) {
                System.out.println("兔子：我要休息一下");
                try {
                    Thread.sleep(3000); // 兔子休息1秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(100); // 兔子的下一次移动时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getPosition(){
        return distance;
    }
}

class Toise implements Runnable {
    private static int distance = 50;
    private Race race;

    public Toise(Race race) {
        this.race = race;
    }

    public static int getPosition() {
        return distance;
    }

    @Override
    public void run() {
        while (distance > 0 && !race.isFinished()) {
            distance -= 1;

            if (distance <= 0) {
                race.setWinner("乌龟");
                System.out.println("乌龟赢了比赛！");
                race.setFinished(true);
                break;
            }
            if (distance<race.getRabbitPosition()){
                System.out.println("乌龟领先");
            }
            System.out.println("乌龟距离终点: " + distance);
            try {
                Thread.sleep(100); // 乌龟的下一次移动时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Race {
    private volatile boolean finished = false;
    private String winner;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getToisePosition() {
        return Toise.getPosition();
    }

    public int getRabbitPosition(){
        return Rabbit.getPosition();
    }
}

public class Test1 {
    public static void main(String[] args) {
        Race race = new Race();
        Rabbit rabbit = new Rabbit(race);
        Toise toise = new Toise(race);

        Thread rabbitThread = new Thread(rabbit);
        Thread toiseThread = new Thread(toise);

        rabbitThread.start();
        toiseThread.start();
    }
}
