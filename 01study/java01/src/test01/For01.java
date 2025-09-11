package test01;

public class For01 {
    public static void main(String[] args) {
        
        // int ddan = 5;
        // for(int i=1;i<10;i++){
        //     System.out.println( ddan + " x " + i + " = "+ ddan*i);
        // }

        int n = 5;
        for(int i = 1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
