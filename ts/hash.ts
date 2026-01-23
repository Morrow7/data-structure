remove(value:T){
  const dummy=new LsitNode<T>(null as any,this.head);
  let cur=dummy;

  while(cur.next){
    if(cur.next.value===value){
      cur.next=cur.next.next;
      break;
    }
    cur=cur.next;
  this.head=dummy.next;
}
