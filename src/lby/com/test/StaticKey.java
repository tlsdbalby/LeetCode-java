package lby.com.test;
/*
* new执行顺序：静态代码块 》 非静态代码块 》 构造方法
* 静态方法调用执行顺序：静态代码块 》 静态方法
* 注：静态代码块永远第一个执行！但全局只执行一次！若先new后访问静态方法，则在静态方法访问过程中不会执行静态代码块
* */
public class StaticKey {
    static {
        System.out.println("静态代码块执行！");
    }
    {
        System.out.println("非静态代码块执行！");
    }
    public StaticKey() {
        System.out.println("构造方法执行！");
    }
    public static void test(){
        System.out.println("静态方法执行！");
    }

    public static void main(String[] args) {
//        StaticKey.test();
        StaticKey staticKey = new StaticKey();
    }

}

