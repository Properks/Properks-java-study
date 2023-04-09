package Chapter_12.Collection.List;

import Chapter_12.Collection.*;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        Mystack<Member> newStack = new Mystack<>();
        Member John = new Member("John", 20201190);
        Member Jack = new Member("Jack", 20201191);
        Member David = new Member("David", 20201192);
        Member Kane = new Member("Kane", 20201193);
        Member Emily = new Member("Emily", 20201194);
        Member Robert = new Member("Robert", 20201195);

        System.out.println("Pop when nothing is in stack=====================");
        newStack.pop();
        System.out.println("Push in stack============================");
        
        newStack.push(John);
        newStack.push(Jack);
        newStack.push(David);
        newStack.push(Kane);
        newStack.push(Emily);
        newStack.push(Robert);
        
        System.out.println("Stack===================================");
        newStack.showInfo();
        
        System.out.println("Pop in stack============================");
        Member top = newStack.top();
        newStack.pop();
        System.out.println("Popped member is " + top);
        
        System.out.println("Stack===================================");
        newStack.showInfo();

    }
}