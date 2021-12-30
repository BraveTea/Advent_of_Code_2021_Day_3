public class BitCounter {

    private int count;

    BitCounter(){
        count = 0;

    }

    public void increase(){
        count++;
    }

    public int getCount() {
        return count;
    }


    @Override
    public String toString() {
        return "BitCounter{" +
                "count=" + count +
                '}';
    }
}
