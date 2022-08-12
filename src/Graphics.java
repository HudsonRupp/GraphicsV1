public class Graphics {
    public static int[] ProjectVertex(Vertex a) {
        int[] r = {(int) ((a.x / a.z) * 1000),(int) ((a.y / a.z) * 1000)};
        return r;
    }
}
