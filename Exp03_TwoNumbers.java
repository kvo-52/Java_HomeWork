public class Exp03_TwoNumbers {
    
        static void generate(int source, int target, int c, int d, String path) { 
            if (source > target) return;
            if (source == target) {
                System.out.println(path);
                return;
            }
            generate(source * c, target, c, d, path + "K1 ");
            generate(source + d, target, c, d, path + "K2 ");
            }
    }


    
    