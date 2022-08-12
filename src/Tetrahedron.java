public class Tetrahedron {
    public Triangle a, b, c, d;

    public Tetrahedron(Triangle a, Triangle b, Triangle c, Triangle d) {

    }
    public Tetrahedron(Vertex a, Vertex b, Vertex c, Vertex d) {
        this.a = new Triangle(a, b, c);
        this.b = new Triangle(b, c, d);
        this.c = new Triangle(c, d, a);
        this.d = new Triangle(d, a, b);
    }
    public Tetrahedron(Vertex start, double len) {
        Vertex va = new Vertex(start);
        Vertex vb = new Vertex(start);
        Vertex vc = new Vertex(start);
        Vertex vd = new Vertex(start);
        vb.x += len;
        vc.z += len;
        vc.x += len/2;
        vd.y += len;
        vd.x += len/2;
        vd.z += len/2;
        System.out.println(va + " " + vb + " " + vc + " " + vd );
        this.a = new Triangle(va, vb, vc);
        this.b = new Triangle(vb, vc, vd);
        this.c = new Triangle(vc, vd, va);
        this.d = new Triangle(vd, va, vb);

    }

    public void show() {
        a.show();
        b.show();
        c.show();
        d.show();
    }
}
