public class a1 {
    //链表节点
    class Node{
        String key;
        int value;
        Node next;

        Node(String key,int value){
            this.key=key;
            this.value=value;
        }
    }

    Node[] table =new Node[10];  //哈希表的桶数组

    int hash(String key){
        return key.hashCode() % table.length;
    }

    //put方法（插入/删除）
    void put(String key,int value){
        //算出桶坐标
        int index=hash(key);
        Node cur=table[index];

        //桶威空（无冲突
        if(cur==null){
            table[index]=new Node(key,value);
            return;
        }

        //桶不为空，发生冲突
        while(true) {
            //情况一 key已存在，更新值
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            //情况二，走到链表末尾
            if (cur.next == null) break;
            cur = cur.next;
        }
        //尾插新节点
            cur.next=new Node(key,value);
        }

        //get（查找）
        int get(String key) {
        //定位桶
            int index = hash(key);
            Node cur = table[index];
            //遍历链表查找
            while (cur != null) {
                if (cur.key.equals(key)) return cur.value;
                cur = cur.next;
            }
            return -1;
        }
    }
