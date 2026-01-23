public class a1 {
    class Node{
        String key;
        int value;
        Node next;

        Node(String key,int value){
            this.key=key;
            this.value=value;
        }
    }

    Node[] table =new Node[10];

    int hash(String key){
        return key.hashCode() % table.length;
    }

    void put(String key,int value){
        int index=hash(key);
        Node cur=table[index];

        if(cur==null){
            table[index]=new Node(key,value);
            return;
        }
        while(true) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            if (cur.next == null) break;
            cur = cur.next;
        }
            cur.next=new Node(key,value);
        }

        int get(String key) {
            int index = hash(key);
            Node cur = table[index];
            while (cur != null) {
                if (cur.key.equals(key)) return cur.value;
                cur = cur.next;
            }
            return -1;
        }
    }
