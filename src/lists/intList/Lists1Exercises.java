package lists.intlist;
public class Lists1Exercises {
  /** Returns an IntList identical to L, but with
    * each element incremented by x. L is not allowed
    * to change. */
  public static IntList incrList(IntList L, int x) {
      IntList Q = new IntList(0, null);
      IntList pointerQ = Q;
      IntList pointerL = L;
      while(pointerL != null){
          pointerQ.rest = new IntList(pointerL.first + x, null);
          pointerQ = pointerQ.rest;
          pointerL = pointerL.rest;
      }
      return Q.rest;      
  }

  /** Returns an IntList identical to L, but with
    * each element incremented by x. Not allowed to use
    * the 'new' keyword. */
  public static IntList dincrList(IntList L, int x) {
      IntList temp = L;
      while (temp != null) {
          temp.first += x;
          temp = temp.rest;
      }
      return L; 
  }

  public static void main(String[] args) {
      IntList L = new IntList(5, null);
      L.rest = new IntList(7, null);
      L.rest.rest = new IntList(9, null);

      System.out.println(L.size());
      System.out.println(L.iterativeSize());

      // Test your answers by uncommenting. Or copy and paste the
      // code for incrList and dincrList into IntList.java and
      // run it in the visualizer.
      System.out.println(L.get(1));
      System.out.println(incrList(L, 3));
      System.out.println(L);
      System.out.println(dincrList(L, 3));        
  }
}