package exceptions;

public class Person extends Student{

    public void getX(int x) throws Exception {
        throw new Exception();
    }
    public int findById(int n) throws OddException {

        if(n%2==0){
            throw new EvenException();
        }
        else
            throw new OddException();
    }
}
