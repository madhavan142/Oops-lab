public class OddEvenMultithreading{ 
    public static void main(String[] args) {
        int start = 1;
        int end = 20;

        Thread evenThread = new Thread(new EvenNumbersGenerator(start, end));
        Thread oddThread = new Thread(new OddNumbersGenerator(start, end));

        evenThread.start();
        oddThread.start();
    }
}

class EvenNumbersGenerator implements Runnable {
    private int start;
    private int end;

    public EvenNumbersGenerator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("Even numbers:");
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
