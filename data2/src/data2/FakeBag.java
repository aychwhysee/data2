package data2;

public interface FakeBag<D extends Comparable> {
    
    /* 
    random notes not really specific to FakeBag; just organizing thoughts:
    - method smartAdd(elt, nCopies) will return this.smartAddStep1().smartAddStep2()
      where this = real-tree and smartAddStep1() returns a fake tree and step2 
      returns a real tree(???)
    - private methods is some class(?????) fake1 and fake2 will do magic
    - So where do we put all the above?
    */
    
    //What do I put in this interface?
    
//            ___
//         ___)  |_
//     .-*'         '*-,
//    /     /|   |\     \
//    ;    /_|   |_\     ;
//    ; |\            /| ;
//    ; | ''--...--''  | ;
//    \ ''---.....--''' /
//     ''*-.,______,.-*'
}
