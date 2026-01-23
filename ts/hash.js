remove(value, T);
{
    var dummy = new LsitNode(null, this.head);
    var cur = dummy;
    while (cur.next) {
        if (cur.next.value === value) {
            cur.next = cur.next.next;
            break;
        }
        cur = cur.next;
        this.head = dummy.next;
    }
}
