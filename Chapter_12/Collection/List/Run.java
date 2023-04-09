package Chapter_12.Collection.List;

import Chapter_12.Collection.*;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        Myqueue<Member> newQueue = new Myqueue<>();
        Member John = new Member("John", 20201190);
        Member Jack = new Member("Jack", 20201191);
        Member David = new Member("David", 20201192);
        Member Kane = new Member("Kane", 20201193);
        Member Emily = new Member("Emily", 20201194);
        Member Robert = new Member("Robert", 20201195);

        System.out.println("Pop when nothing is in stack=====================");
        newQueue.pop();
        System.out.println("Push in stack============================");
        
        newQueue.push(John);
        newQueue.push(Jack);
        newQueue.push(David);
        newQueue.push(Kane);
        newQueue.push(Emily);
        newQueue.push(Robert);
        
        System.out.println("Stack===================================");
        newQueue.showInfo();
        
        System.out.println("Pop in stack============================");
        Member remove = newQueue.pop();
        System.out.println("Popped member is " + remove);
        
        System.out.println("Stack===================================");
        newQueue.showInfo();
    }
}