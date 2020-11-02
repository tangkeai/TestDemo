package user;

import operation.IOperation;

public abstract class User {
    protected String name;

    protected IOperation[] iOperations;//将操作放在这个数组上

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();//不用实现，可以用抽象方法

    public IOperation doOperation(int choice) {
        return this.iOperations[choice];//发生向上转型
    }
}
