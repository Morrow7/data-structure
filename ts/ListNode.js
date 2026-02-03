var ListNode = /** @class */ (function () {
    function ListNode(val, next) {
        this.val = val !== null && val !== void 0 ? val : 0;
        this.next = next !== null && next !== void 0 ? next : null;
    }
    return ListNode;
}());
function mergeTwoLists(l1, l2) {
    // const dummy = new ListNode();
    // let cur = dummy;
    // while (l1 && l2) {
    //     if (l1.val < l2.val) {
    //         cur.next = l1;
    //         l1 = l1.next;
    //     } else {
    //         cur.next = l2;
    //         l2 = l2.next;
    //     }
    //     cur = cur.next;
    // }
    // cur.next = l1 ?? l2;
    // return dummy.next;
    //递归
    if (!l1)
        return l2;
    if (!l2)
        return l1;
    if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2); //递归合并剩余部分
        return l1; //返回当前较小的节点作为头
    }
    else {
        l2.next = mergeTwoLists(l1, l2.next); //递归合并剩余部分
        return l2; //返回当前较小的节点作为头
    }
}
