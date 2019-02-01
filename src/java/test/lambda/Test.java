package test.lambda;

/**
 * @author stevenw
 * @date 2018/8/31
 */
public class Test {
    public static void main(String[] args) throws Exception{
        /*try {
            String A = "";
            each();
            return;
        }catch (Exception e){
            System.err.println("A");
            e.printStackTrace();
        }*/
        String str = "1111,2222";
        System.err.println(str.matches("(\\d+,?\\d+)+"));

    }
    public static void each() throws Exception{
        try {
            String A = "";
            A  = A.substring(0,3);
            return;
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        System.err.println("111");
    }
}
