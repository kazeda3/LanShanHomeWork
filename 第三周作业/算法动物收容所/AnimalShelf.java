package 蓝山作业.第三周作业.算法动物收容所;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelf {
    Queue<Integer> queueCat = new LinkedList<>();
    Queue<Integer> queueDog = new LinkedList<>();
    public AnimalShelf() {

    }

    public void enqueue(int[] animal) {
        if(animal[1] == 0){//如果是猫
            queueCat.add(animal[0]);
            queueCat.add(animal[1]);
        }else {//如果是狗
            queueDog.add(animal[0]);
            queueDog.add(animal[1]);
        }
    }

    public int[] dequeueAny() {
        if(!queueCat.isEmpty() && !queueDog.isEmpty()){//如果都非空
            if(queueCat.peek() > queueDog.peek()){
                return new int[]{queueCat.poll(),queueCat.poll()};
            }else {
                return new int[]{queueDog.poll(),queueDog.poll()};
            }
        }else if(queueCat.isEmpty()){
            return dequeueDog();
        }else if(queueDog.isEmpty()){
            return dequeueCat();
        }
        return new int[]{-1,-1};
    }

    public int[] dequeueDog() {
        if(!queueDog.isEmpty()) {
            return new int[]{queueDog.poll(), queueDog.poll()};
        }
        return new int[]{-1,-1};
    }

    public int[] dequeueCat() {
        if(!queueCat.isEmpty()) {
            return new int[]{queueCat.poll(), queueCat.poll()};
        }
        return new int[]{-1,-1};
    }
}


/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */
