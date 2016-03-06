package generics;

/**
 * Created by qinbingbing on 2/11/16.
 */
interface Payable<T> {}

class Employee1 implements Payable {

}

class Hourly extends Employee1 implements Payable {}

public class MultipleInterfaceVariants {

}
