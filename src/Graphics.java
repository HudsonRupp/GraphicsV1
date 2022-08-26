import java.util.ArrayList;

public class Graphics {
    public static ArrayList<Polyhedron> polyhedra = new ArrayList<>();
    public static ArrayList<Polygon> polygons = new ArrayList<>();

    public Graphics() {

    }
    public static void translateVertices(Vertex vector) {
        for(Polyhedron p : polyhedra) {
            for (Vertex v : p.vertices) {
                v.x += vector.x;
                v.y += vector.y;
                v.z += vector.z;
            }
        }

    }
    public static void rotateY(double angle) {
        for (Polyhedron p : polyhedra) {
            for (Vertex v : p.vertices) {
                double oldY = v.y;
                v.y = v.y * Math.cos(angle) - v.z * Math.sin(angle);
                v.z = v.z * Math.cos(angle) + oldY * Math.sin(angle);
            }
        }
    }
    public static void rotateX(double angle) {
        for (Polyhedron p : polyhedra) {
            for (Vertex v : p.vertices) {
                double oldX = v.x;
                v.x = v.x * Math.cos(angle) - v.z * Math.sin(angle);
                v.z = v.z * Math.cos(angle) + oldX * Math.sin(angle);
            }
        }
    }


    //WRONG WAY
    /*
    public static void rotateVertices(double ang1, double ang2) {
        //convert cartesian to spherical;
        for (Polyhedron p : polyhedra) {
            for (Vertex v : p.vertices) {
                //cartesian to spherical
                //https://en.wikipedia.org/wiki/Spherical_coordinate_system#Coordinate_system_conversions
                double r =Math.sqrt((v.x * v.x) + (v.y * v.y) + (v.z * v.z));
                double inclination = Math.acos(v.z / r);
                double azimuth;
                if (v.x > 0 ) {
                    azimuth = Math.atan(v.y / v.x);
                } else if ( v.x < 0 && v.y >= 0) {
                    azimuth = Math.atan(v.y / v.x) + Math.PI;
                } else if (v.x < 0 && v.y < 0) {
                    azimuth = Math.atan(v.y/v.x) - Math.PI;
                } else if (v.x == 0 && v.y > 0) {
                    azimuth = Math.PI / 2;
                } else if (v.x ==0 && v.y < 0) {
                    azimuth = -Math.PI / 2;
                } else if (v.x == 0 && v.y == 0) {
                    //is undefined, does it matter?
                    System.out.println("broke");
                    azimuth = 0;
                } else {
                    System.out.println("broke");
                    azimuth = 0;
                }
                //add angles
                inclination += ang1;
                azimuth += ang2;


                //convert back to cartesian

                v.x = r * Math.cos(azimuth) * Math.sin(inclination);
                v.y = r * Math.sin(azimuth) * Math.sin(inclination);
                v.z = r * Math.cos(inclination);
            }
        }
    }

     */


    public static int[] ProjectVertex(Vertex a) {
        int[] r = {(int) ((a.x / a.z) * 1000),(int) ((a.y / a.z) * 1000)};
        return r;
    }
}
