package Daily;

public class IntegerAndInt {

    public static void main(String[] args) {
        IntegerAndInt integerAndInt = new IntegerAndInt();
        integerAndInt.IntegerContrast();
    }

    private void IntegerContrast(){
        Integer integer1 = new Integer(100);
        Integer integer2 = new Integer(100);
        int int1 = 100;
        boolean flag = false;
        if(integer1 == integer2){
            flag = true;
        }else{
            flag = false;
        }
        System.out.println( "integer1 = integer2:" + flag);
        System.out.println("integer1 equals. integer2:" + integer1.equals(integer2));
        System.out.println("integer1 equals. int1:" + integer1.equals(int1));
        System.out.print("integer1 == int1:");
        System.out.println( integer1 == int1);
    }
}
