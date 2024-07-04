package ds.PriorityQueue;

import ds.Queue.QueueImpl;

import java.util.Queue;

public class PriorityQueue<E extends Priority> implements QueueImpl<E> {

    Priority[] queue;
    int size;


    public PriorityQueue(int capacity) {
        this.queue = new Priority[capacity];
        this.size = 0;
    }

    /*
时间复杂度：O（logn）
1. 入堆新元素，加入到数组末尾（索引位置 child）
2. (上浮）
    不断比较新加元素与它父节点（parent）优先级
  - 如果父节点优先级低，则向下移动，并找到下一个parent
  - 直至父节点优先级更高或child = 0为止
 */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2; // java 自动向下取整 （floor）

        while (child > 0 && value.priority() > queue[parent].priority()) {
            queue[child] = queue[parent];
            child = parent; //child index move up
            parent = (child - 1) / 2; // parent index move down
        }
        queue[child] = value;
        return true;
    }

    /*
    时间复杂度 ：O（logn)
    1. 交换堆顶和尾部元素，让尾部元素出队
    2. （下潜）
      - 从堆顶开始，将父元素与两个孩子较大者交换
      - 直到父元素大于两个孩子，或没有孩子为止
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size-1);
        size--; // remove the last element
        Priority e = queue[size];
        queue[size] = null; //help GC

        // 下潜
        down(0);

        return (E) e;
    }

    private void down(int parent) {
        int l = parent * 2 + 1;
        int r = l + 1;
        int max = parent; //假设父节点最大

        if(l < size && queue[l].priority() > queue[max].priority()) {
            max = l;
        }
        if(r < size && queue[r].priority() > queue[max].priority()) {
            max = r;
        }

        if(max != parent) {
            swap(parent, max);
            down(max); //递归下潜
        }
    }

    private void swap(int i, int j) {
        Priority temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) queue[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == queue.length;
    }
}




