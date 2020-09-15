public class Box {

    private int height;
    private int width;
    private int depth;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public int boxVolume() {
        int volume = this.height * this.width * this.depth;
        return volume;
    }
}
