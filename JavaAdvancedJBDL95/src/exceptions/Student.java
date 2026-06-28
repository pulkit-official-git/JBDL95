package exceptions;

import java.sql.SQLException;

public class Student {

    public int findById(int n) throws Exception {

        try {
            if(n<=20){
                throw new SQLException();
            }
            if (n % 2 == 0) {
                throw new EvenException();
            } else throw new OddException();
        }

//        }catch (Exception e){
//            System.out.println("parent");
//        }
        catch (OddException oe){
            System.out.println("i dont like odd numbers");
        }catch (EvenException ev){
            System.out.println("i dont like even numbers");
            throw new EvenException();
        }catch (SQLException sqlException){
            /*
            * DriverManger.createStatement()
            * retry1
            * retry2
            * retry3
            *
            * */
            throw new SQLException();
        }finally {
            System.out.println("still here");
        }

        return 0;


    }
}

/*
* throw  (current exception)
* throws (passing the thrown exception to the caller)
*
*
* dont handle parent exception before child exception
* you ca even throw exception from catch block
* catch doesnt exist without try
*
* nested try catch
*
* inside catch can we have try catch (yes)
* inside try can we have try catch (yes)
*
* called by jvm
*
* clearing the open connections and resources
*
*
* cron job
* retries
*
* try catch
*
* finally
* */