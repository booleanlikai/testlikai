package com.xiaoming.test;

public class PairTest3 {

    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 8000000, 2010, 2, 26, 77377);
        Manager cfo = new Manager("xiao ming", 7000000, 2010, 2, 18, 10000);
        Pari<Manager> buddies = new Pari<>(ceo, cfo);
        new PairTest3().printBuddies(buddies);
        Manager[] managers={ceo,cfo};
        Pari<Employee> result =new Pari<>();
        new PairTest3().minmaxBonus(managers,result);
        System.out.println("first:"+result.getFirst().getName()+"  second:"+result.getSecond().getName());
        new PairTest3().maxminBonus(managers,result);
        System.out.println("first:"+result.getFirst().getName()+"  second:"+result.getSecond().getName());
    }

    public void printBuddies(Pari<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + "and" + second.getName() + "are buddies");
    }

    public void minmaxBonus(Manager[] a, Pari<? super Manager> result) {
        if (a.length == 0)
            return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i].getBonus() < min.getBonus())
                min = a[i];
            if (a[i].getBonus() < max.getBonus())
                max = a[i];
        }
        result.setSecond(max);
        result.setFirst(min);
    }

    public void maxminBonus(Manager[] a, Pari<? super Manager> result) {
        minmaxBonus(a, result);
        PairAlg.swap(result);
    }

}
