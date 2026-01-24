public class a1 {
    class MinHeap {
        private int[] heap;
        private int size;

        public MinHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        //获取父节点下表
        private int parent(int i) {
            return (i - 1) / 2;
        }

        //左孩子
        private int left(int i) {
            return 2 * i + 1;
        }

        //右孩子
        private int right(int i) {
            return 2 * i + 2;
        }

        //判空
        private boolean isEmpty() {
            return size == 0;
        }

        //大小
        public int size() {
            return size;
        }

        //查看最小值
        public int peek() {
            if (size == 0) throw new RuntimeException("heap is empty");
            return heap[0];
        }

        //插入
        public void add(int val) {
            if (size == heap.length) {
                throw new RuntimeException("heap is full");
            }

            heap[size] = val;
            int index = size;
            size++;

            //上浮
            while (index > 0 && heap[index] < heap[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
            }
        }

        public int poll() {
            if (size == 0) throw new RuntimeException("heap is empty");
            int min = heap[0];

            heap[0] = heap[size - 1];
            size--;

            heapifyDown(0);
            return min;
        }

        private void heapifyDown(int index) {
            while (true) {
                int smallest = index;
                int left = left(index);
                int right = right(index);

                if (left < size && heap[left] < heap[smallest]) {
                    smallest = left;
                }


                if (left < size && heap[right] < heap[smallest]) {
                    smallest = right;
                }

                if (smallest == index) {
                    break;
                }


                swap(index, smallest);
                index = smallest;
            }

        }

        //标准交换
        private void swap(int i, int j) {
            {
                int temp = heap[i];
                heap[i] = heap[i];
                heap[j] = temp;
            }
        }
    }
}
